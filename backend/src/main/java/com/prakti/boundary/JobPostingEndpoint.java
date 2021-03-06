package com.prakti.boundary;

import com.prakti.control.CompanyDAO;
import com.prakti.control.JobPostingDAO;
import com.prakti.model.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/api/jobPosting")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Transactional
public class JobPostingEndpoint {

    @Inject
    JobPostingDAO jobPostingRepository;

    @Inject
    CompanyDAO companyRepository;

    @GET
    public List<JobPosting> getAllJobPostings(){

        List<JobPosting> jobPostings = jobPostingRepository.findAllJobPostings();
        jobPostings.forEach(this::doLoader);
        return jobPostings;
    }

    @GET
    @Path("{id}")
    public JobPosting getJobPostingById(@PathParam("id")Long id){
        JobPosting jobPosting = jobPostingRepository.findJobPostingById(id);
        doLoader(jobPosting);
        return jobPosting;
    }

    @GET
    @Path("/company/{company_id}")
    public List<JobPosting> getJobPostingByCompanyId(@PathParam("company_id") Long companyId){

        List<JobPosting> jobPostings = jobPostingRepository.findJobPostingByCompanyId(companyId);
        jobPostings.forEach(this::doLoader);
        return jobPostings;
    }

    @GET
    @Path("/{fieldOfWork}")
    public List<JobPosting> getJobPostingsByFieldOfWork(@QueryParam("fieldOfWork")FieldOfWork fieldOfWork){
        List<JobPosting> jobPostings = jobPostingRepository.findJobPostingsByFieldOfWork(fieldOfWork);
        jobPostings.forEach(this::doLoader);
        return jobPostings;
    }

    private void doLoader(JobPosting jobPosting) {
        Company loadCompany = jobPosting.company;
        List<Location> loadLocations = loadCompany.locations;
        List<JobPosting> loadJobPostings = loadCompany.jobPostings;
    }

    @POST
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createJobPosting(@PathParam("id") Long companyId, @Context UriInfo info, JobPosting jobPosting) {
        if (jobPosting == null) return Response.noContent().build();
        Company company = companyRepository.findCompanyById(companyId);
        JobPosting newJobPosting = new JobPosting();
        newJobPosting.company = company;
        newJobPosting.CopyProperties(jobPosting);
        JobPosting savedJobPosting = jobPostingRepository.persistJobPosting(newJobPosting);
        URI uri = info.getAbsolutePathBuilder().path("/" + savedJobPosting.getId()).build();
        return Response.created(uri).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteJobPosting(@PathParam("id") Long id) {
        try {
            jobPostingRepository.deleteJobPosting(id);
        } catch (EntityNotFoundException e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("Reason", "Job Posting with id " + id + " does not exist")
                    .build();
        }
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") Long id, JobPosting jobPosting) {
        JobPosting j = jobPostingRepository.findJobPostingById(id);
        if (j == null) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("Reason", "JobPosting with id " + id + " does not exist")
                    .build();
        } else {
            jobPostingRepository.updateJobPosting(id,jobPosting);
            return Response.ok(jobPosting).build();
        }
    }
}
