package com.prakti.control;

import com.prakti.control.mapper.CompanyMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CompanyService {

    @Inject
    CompanyMapper companyMapper;


}
