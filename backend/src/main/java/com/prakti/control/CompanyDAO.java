package com.prakti.control;

import java.util.List;
import java.util.Optional;

import com.prakti.model.Company;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

@Transactional
@ApplicationScoped
public class CompanyDAO implements PanacheRepository<Company> {


    public Company findCompanyById(Long id){
        Optional<Company> optionalCompany = Company.find("id", id).singleResultOptional();
        return optionalCompany.orElseThrow(NotFoundException::new);
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
}
