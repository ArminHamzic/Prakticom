package com.prakti.service.control;

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

    public List<Company> findAllCompanies(){
        return Company.findAll().list();
    }

    public Company findCompanyById(Long id){
        Optional<Company> optionalCompany = Company.findByIdOptional(id);
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
        persist(company);
        return company;
    }

    public void updateCompany(Long id, Company company){
        Company updateCompany = findCompanyById(id);
        updateCompany.CopyProperties(company);
        persist(updateCompany);
    }

    public void deleteCompany(Long id){
        delete(findCompanyById(id));
    }
}
