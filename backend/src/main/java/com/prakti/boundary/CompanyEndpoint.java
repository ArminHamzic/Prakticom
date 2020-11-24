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
    CompanyDAO companyRepository;

    @GET
    public List<Company> getAllCompanies(){
        return companyRepository.findAllCompanies();
    }

    @GET
    @Path("{id}")
    public Company getCompanyById(@PathParam("id")Long id){
        return companyRepository.findCompanyById(id);
    }

    @GET
    @Path("/{url}")
    public Company getCompanyByUrl(@QueryParam("url")String url){
        return companyRepository.findCompanyByUrl(url);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCompany(@Context UriInfo info, Company company) {
        if (company == null) return Response.noContent().build();
        Company savedCompany = companyRepository.persistCompany(company);
        URI uri = info.getAbsolutePathBuilder().path("/" + savedCompany.id).build();
        return Response.created(uri).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteCompany(@PathParam("id") Long id) {
        try {
            companyRepository.deleteCompany(id);
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
        Company c = companyRepository.findById(id);
        if (c == null) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("Reason", "Company with id " + id + " does not exist")
                    .build();
        } else {
            companyRepository.updateCompany(id,company);
            return Response.ok(company).build();
        }
    }
}
