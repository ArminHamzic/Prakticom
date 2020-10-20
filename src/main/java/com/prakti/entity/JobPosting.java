package com.prakti.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "JOB_POSTING", schema = "PRAKTICOM")
public class JobPosting extends PanacheEntity {
    @Column
    public String jobTitle;
    @Column
    public String jobDescription;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "id")
    public Company company;
    @Column
    public Date postingDate;
    @Column
    public String timeSpan;

    public JobPosting CopyProperties(JobPosting other){
        if(other.id != null){
            jobTitle = other.jobTitle;
            jobDescription = other.jobDescription;
            company = other.company;
            postingDate = other.postingDate;
            timeSpan = other.timeSpan;
        }
        return this;
    }

}
