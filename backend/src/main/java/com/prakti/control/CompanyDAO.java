package com.prakti.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

import com.prakti.model.Company;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

@Transactional
@ApplicationScoped
public class CompanyDAO implements PanacheRepository<Company> {


    public Company findCompanyById(Long id){
        Optional<Company> optionalCompany = Company.find("id", id).singleResultOptional();
        return optionalCompany.orElseThrow(NotFoundException::new);
    }

    public List<Company> findAllCompanies(){
        return Company.findAll().list();
    }

    public Company findCompanyByEmail(String email){
        Optional<Company> optionalCompany = find("email",email).singleResultOptional();
        return optionalCompany.orElseThrow(NotFoundException::new);
    }

    public Company findCompanyByUrl(String url){
        Optional<Company> optionalCompany = find("url",url).singleResultOptional();
        return optionalCompany.orElseThrow(NotFoundException::new);
    }

    public Company persistCompany(Company company){
        return this.getEntityManager().merge(company);
    }

    public void updateCompany(Long id, Company company){
        Company updateCompany = findCompanyById(id);
        updateCompany.CopyProperties(company);
        if(company.jobPostings != null) updateCompany.jobPostings = company.jobPostings;
        if(company.locations != null) updateCompany.locations = company.locations;
        persistCompany(updateCompany);
    }

    public void deleteCompany(Long id){
        delete(findCompanyById(id));
    }

    public List<Company> filterByNameAndLocation(String name, String location){
        List<Company> companies = findAllCompanies();
        List<Company> filtered = new ArrayList<Company>();
        int length = location.length();
        AtomicBoolean hasGivenLocation = new AtomicBoolean(false);
        companies.forEach(i -> {
            if(location.length() != 0){
                i.locations.forEach(l -> {
                    if(l.city.toLowerCase().equals(location.toLowerCase())){
                        hasGivenLocation.set(true);
                    }
                });
            }

            if(i.name.toLowerCase().contains(name.toLowerCase()) && hasGivenLocation.get()){
                filtered.add(i);
            }
            else if(i.name.toLowerCase().contains(name.toLowerCase()) && hasGivenLocation.get() && !location.isEmpty()){
                filtered.add(i);
            }
            else if(i.name.toLowerCase().contains(name.toLowerCase()) && !hasGivenLocation.get() && location.length() == 0){
                filtered.add(i);
            }
        });
        if(filtered.size() != 0){
            return filtered;
        }
        companies.forEach(c -> {
            c.jobPostings.forEach(jP -> {
               if(jP.jobTitle.equals(name)){
                   filtered.add(c);
               }
            });
        });
        return filtered;
    }
}
