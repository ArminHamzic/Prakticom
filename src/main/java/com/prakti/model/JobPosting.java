package com.prakti.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "JOB_POSTING", schema = "PRAKTICOM")
public class JobPosting extends PanacheEntity {

    @Column(name = "JOB_TITLE")
    public String jobTitle;
    @Column(name = "JOB_DESCRIPTION")
    public String jobDescription;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "id")
    public Company company;
    @Column(name = "POSTING_DATE")
    public Date postingDate;
    @Column
    public String timespan;

    public JobPosting CopyProperties(JobPosting other){
        if(other.id != null){
            jobTitle = other.jobTitle;
            jobDescription = other.jobDescription;
            company = other.company;
            postingDate = other.postingDate;
            timespan = other.timespan;
        }
        return this;
    }

}
