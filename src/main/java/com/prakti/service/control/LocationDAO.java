package com.prakti.service.control;

import com.prakti.model.Location;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;

@Transactional
@ApplicationScoped
public class LocationDAO implements PanacheRepository<Location> {

    public List<Location> findAllLocations(){
        return Location.findAll().list();
    }

    public Location findLocationById(Long id){
        Optional<Location> optionalLocation = Location.findByIdOptional(id);
        return optionalLocation.orElseThrow(NotFoundException::new);
    }

    public Location persistLocation(Location location){
        persist(location);
        return location;
    }

    public void updateLocation(Long id, Location location){
        Location updateLocation = findLocationById(id);
        updateLocation.CopyProperties(location);
        persist(updateLocation);
    }

    public void deleteLocation(Long id){
        delete(findLocationById(id));
    }
}
