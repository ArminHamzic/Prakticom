package com.prakti.boundary;

import com.prakti.control.LocationDAO;
import com.prakti.model.JobApplication;
import com.prakti.model.Location;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/api/location")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LocationEndpoint {

    @Inject
    LocationDAO locationRepository;

    //TODO: Not really necessary
    @GET
    public List<Location> getAllLocations(){

        return locationRepository.listAll();
    }

    @GET
    @Path("{id}")
    public Location getLocationById(@PathParam("id") Long id){

        return locationRepository.findLocationById(id);
    }

    @GET
    @Path("/{company}")
    public List<Location> getLocationByCompanyId(@QueryParam("id") Long companyId){
        return locationRepository.findLocationsByCompanyId(companyId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createLocation(@Context UriInfo info, Location location) {
        if (location == null) return Response.noContent().build();
        Location savedLocation = locationRepository.persistLocation(location);
        URI uri = info.getAbsolutePathBuilder().path("/" + savedLocation.getId()).build();
        return Response.created(uri).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteLocation(@PathParam("id") Long id) {
        try {
            locationRepository.deleteLocation(id);
        } catch (EntityNotFoundException e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("Reason", "Location with id " + id + " does not exist")
                    .build();
        }
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") Long id, Location location) {
        Location l = locationRepository.findById(id);
        if (l == null) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("Reason", "Location with id " + id + " does not exist")
                    .build();
        } else {
            locationRepository.updateLocation(id,location);
            return Response.ok(location).build();
        }
    }
}
