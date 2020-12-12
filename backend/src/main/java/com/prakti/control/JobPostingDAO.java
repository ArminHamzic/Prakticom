package com.prakti.control;

import java.util.List;
import java.util.Optional;

import com.prakti.model.Company;
import com.prakti.model.FieldOfWork;
import com.prakti.model.JobPosting;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

@Transactional
@ApplicationScoped
public class JobPostingDAO implements PanacheRepository<JobPosting> {

    @Inject
    CompanyDAO companyRepository;

    public List<JobPosting> findAllJobPostings(){
        return JobPosting.findAll().list();
    }

    public JobPosting findJobPostingById(Long id){
        Optional<JobPosting> optionalJobPosting = JobPosting.findByIdOptional(id);
        return optionalJobPosting.orElseThrow(NotFoundException::new);
    }

    public List<JobPosting> findJobPostingByCompanyId(Long companyId){
        Company company = companyRepository.findCompanyById(companyId);
        return list("company_id",company.id);
    }

    public List<JobPosting> findJobPostingsByFieldOfWork(FieldOfWork fieldOfWork){
        return list("field_of_work", fieldOfWork.ordinal());
    }

    public JobPosting persistJobPosting(JobPosting jobPosting){
        return this.getEntityManager().merge(jobPosting);
    }

    public void updateJobPosting(Long id, JobPosting jobPosting){
        JobPosting updateJobPosting = findJobPostingById(id);
        updateJobPosting.CopyProperties(jobPosting);
        if(jobPosting.company!=null) updateJobPosting.company = jobPosting.company;
        if(jobPosting.jobApplications!=null) updateJobPosting.jobApplications = jobPosting.jobApplications;
        persistJobPosting(updateJobPosting);
    }

    public void deleteJobPosting(Long id){
        delete(findJobPostingById(id));
    }
}
