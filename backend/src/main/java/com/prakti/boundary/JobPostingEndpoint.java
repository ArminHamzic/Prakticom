package com.prakti.boundary;

import com.prakti.control.JobPostingDAO;
import com.prakti.model.Company;
import com.prakti.model.FieldOfWork;
import com.prakti.model.JobApplication;
import com.prakti.model.JobPosting;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
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
public class JobPostingEndpoint {

    @Inject
    JobPostingDAO jobPostingRepository;

    @GET
    public List<JobPosting> getAllJobPostings(){
        return jobPostingRepository.findAllJobPostings();
    }

    @GET
    @Path("{id}")
    public JobPosting getJobPostingById(@PathParam("id")Long id){
        return jobPostingRepository.findJobPostingById(id);
    }

    @GET
    @Path("/{company}")
    public JobPosting getJobPostingByCompanyId(@QueryParam("id") Long companyId){
        return jobPostingRepository.findJobPostingByCompanyId(companyId);
    }

    @GET
    @Path("/fieldOfWork/{fieldOfWork}")
    public List<JobPosting> getJobPostingsByFieldOfWork(@PathParam("fieldOfWork")FieldOfWork fieldOfWork){
        return jobPostingRepository.findJobPostingsByFieldOfWork(fieldOfWork);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createJobPosting(@Context UriInfo info, JobPosting jobPosting) {
        if (jobPosting == null) return Response.noContent().build();
        JobPosting savedJobPosting = jobPostingRepository.persistJobPosting(jobPosting);
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
        return Response.noContent().build();
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
