package com.prakti.boundary;

import com.prakti.control.JobApplicationDAO;
import com.prakti.model.JobApplication;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/jobApplication")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JobApplicationEndpoint {

    @Inject
    JobApplicationDAO jobApplicationRepository;

    @GET
    public List<JobApplication> getAllJobApplications(){
        return jobApplicationRepository.findAllJobApplications();
    }

    @GET
    @Path("{id}")
    public JobApplication getJobApplicationById(@PathParam("id")Long id){
        return jobApplicationRepository.findJobApplicationById(id);
    }

    @GET
    @Path("/{jobPosting}")
    public JobApplication getJobApplicationByJobPostingId(@QueryParam("id") Long jobPostingId){
        return jobApplicationRepository.findJobApplicationByJobPosting(jobPostingId);
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createJobApplication(@Context UriInfo info, JobApplication jobApplication) {
        if (jobApplication == null) return Response.noContent().build();
        JobApplication savedJobApplication = jobApplicationRepository.persistJobApplication(jobApplication);
        URI uri = info.getAbsolutePathBuilder().path("/" + savedJobApplication.id).build();
        return Response.created(uri).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteJobApplication(@PathParam("id") Long id) {
        try {
            jobApplicationRepository.deleteJobApplication(id);
        } catch (EntityNotFoundException e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("Reason", "JobApplication with id " + id + " does not exist")
                    .build();
        }
        return Response.noContent().build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") Long id, JobApplication jobApplication) {
        JobApplication j = jobApplicationRepository.findById(id);
        if (j == null) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("Reason", "JobApplication with id " + id + " does not exist")
                    .build();
        } else {
            jobApplicationRepository.updateJobApplication(id,jobApplication);
            return Response.ok(jobApplication).build();
        }
    }
}
