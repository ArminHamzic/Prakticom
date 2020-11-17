package com.prakti.boundary;

import com.prakti.control.CompanyDAO;
import com.prakti.model.Company;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/company")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CompanyEndpoint {

    @Inject
    CompanyDAO companyRepo;

    @GET
    public List<Company> getAllCompanies(){
        return companyRepo.findAllCompanies();
    }

    @GET
    @Path("/{id}")
    public Company getCompanyById(@QueryParam("id")Long id){
        return companyRepo.findCompanyById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCompany(@Context UriInfo info, Company company) {
        if (company == null) return Response.noContent().build();
        Company savedCompany = companyRepo.persistCompany(company);
        URI uri = info.getAbsolutePathBuilder().path("/" + savedCompany.id).build();
        return Response.created(uri).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteCompany(@PathParam("id") Long id) {
        try {
            companyRepo.deleteCompany(id);
        } catch (EntityNotFoundException e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("Reason", "Company with id " + id + " does not exist")
                    .build();
        }
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") Long id, Company company) {
        Company c = companyRepo.findById(id);
        if (c == null) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("Reason", "Company with id " + id + " does not exist")
                    .build();
        } else {
            companyRepo.updateCompany(id,company);
            return Response.ok(company).build();
        }
    }
}
