package com.prakti.control;

import java.util.List;
import java.util.Optional;

import com.prakti.model.JobApplication;
import com.prakti.model.JobPosting;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

@Transactional
@ApplicationScoped
public class JobApplicationDAO implements PanacheRepository<JobApplication> {

    @Inject
    JobPostingDAO jobPostingRepository;

    public List<JobApplication> findAllJobApplications(){
        return JobApplication.findAll().list();
    }

    public JobApplication findJobApplicationById(Long id){
        Optional<JobApplication> optionalJobApplication = JobApplication.findByIdOptional(id);
        return optionalJobApplication.orElseThrow(NotFoundException::new);
    }


    public JobApplication findJobApplicationByJobPosting(Long jobPostingId){
        JobPosting jobPosting = jobPostingRepository.findJobPostingById(jobPostingId);
        Optional<JobApplication> optionalJobApplication = find("job_posting_id",jobPosting.getId()).singleResultOptional();
        return optionalJobApplication.orElseThrow(NotFoundException::new);
    }

    public JobApplication persistJobApplication(JobApplication jobApplication){
        persist(jobApplication);
        return jobApplication;
    }

    public void updateJobApplication(Long id, JobApplication jobApplication){
        JobApplication updateJobApplication = findJobApplicationById(id);
        updateJobApplication.CopyProperties(jobApplication);
        persist(updateJobApplication);
    }

    public void deleteJobApplication(Long id){
        delete(findJobApplicationById(id));
    }
}
