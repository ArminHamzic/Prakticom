package com.prakti.boundary;

import com.prakti.control.CompanyDAO;
import com.prakti.control.CompanyDocumentDAO;
import com.prakti.control.LocationDAO;
import com.prakti.model.Company;
import com.prakti.model.DocumentEntities.CompanyDocument;
import com.prakti.model.Location;

import javax.annotation.security.RolesAllowed;
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

@Path("/api/company")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class CompanyEndpoint {

    @Inject
    CompanyDAO companyRepository;

    @Inject
    LocationDAO locationRepository;

    @Inject
    CompanyDocumentDAO companyDocumentDAO;

    @GET
    public List<Company> getAllCompanies(){
        return companyRepository.listAll();
    }

    @GET
    @Path("{id}")
    public Company getCompanyById(@PathParam("id")Long id){
        return companyRepository.findCompanyById(id);
    }

    @GET
    @Path("filter")
    public List<Company> getFilteredObjects(@QueryParam("name")String name, @QueryParam("location")String location){
        return companyRepository.filterByNameAndLocation(name, location);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCompany(@Context UriInfo info, Company company) {
        if (company == null) return Response.noContent().build();
        Company newCompany = new Company();
        companyRepository.persist(newCompany);
        company.locations.forEach(l ->{
            Location location = new Location();
            location.CopyProperties(l);
            location.company = newCompany;
            location = locationRepository.persistLocation(location);
            newCompany.locations.add(location);
        });
        // TODO: Implement Documents or Serialization Error
        /*company.documents.forEach(d -> {
            CompanyDocument document = new CompanyDocument();
            document.company = newCompany;
            document.document = d.document;
            document = companyDocumentDAO.persistDocument(document);
            newCompany.documents.add(document);
        });*/
        newCompany.CopyProperties(company);
        Company savedCompany = companyRepository.persistCompany(newCompany);
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
            return Response.ok().build();
        }
    }
}
