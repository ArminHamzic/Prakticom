package com.prakti.control;

import java.util.List;
import java.util.Optional;

import com.prakti.model.Company;
import com.prakti.model.JobPosting;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.vertx.reactivex.ext.shell.system.Job;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

@Transactional
@ApplicationScoped
public class JobPostingDAO implements PanacheRepository<JobPosting> {

    public List<JobPosting> findAllJobPostings(){
        return JobPosting.findAll().list();
    }

    public JobPosting findJobPostingById(Long id){
        Optional<JobPosting> optionalJobPosting = JobPosting.findByIdOptional(id);
        return optionalJobPosting.orElseThrow(NotFoundException::new);
    }


    public JobPosting findJobPostingByCompanyId(Company company){
        Optional<JobPosting> optionalJobPosting = find("company_id",company.id).singleResultOptional();
        return optionalJobPosting.orElseThrow(NotFoundException::new);
    }

    public JobPosting persistJobPosting(JobPosting jobPosting){
        persist(jobPosting);
        return jobPosting;
    }

    public void updateJobPosting(Long id, JobPosting jobPosting){
        JobPosting updateJobPosting = findJobPostingById(id);
        updateJobPosting.CopyProperties(jobPosting);
        persist(updateJobPosting);
    }

    public void deleteJobPosting(Long id){
        delete(findJobPostingById(id));
    }
}
