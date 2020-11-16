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


}
