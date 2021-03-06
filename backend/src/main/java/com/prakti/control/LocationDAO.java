package com.prakti.control;

import com.prakti.model.Company;
import com.prakti.model.Location;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;

@Transactional
@ApplicationScoped
public class LocationDAO implements PanacheRepositoryBase<Location, Long> {

    @Inject
    CompanyDAO companyRepository;

    public Location findLocationById(Long id){
        Optional<Location> optionalLocation = Location.findByIdOptional(id);
        return optionalLocation.orElseThrow(NotFoundException::new);
    }

    public List<Location> findLocationsByCompanyId(Long companyId){
        Company company = companyRepository.findCompanyById(companyId);
        List<Location> locations = Location.find("company_id", company.id).list();
        if(locations.size() == 0){throw new NotFoundException();}
        else{return locations;}
    }

    public Location persistLocation(Location location){
        return this.getEntityManager().merge(location);
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
