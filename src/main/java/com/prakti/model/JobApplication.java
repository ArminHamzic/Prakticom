package com.prakti.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "JOB_APPLICATION", schema = "prakticom")
public class JobApplication extends PanacheEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "id")
    public Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_POSTING_ID", referencedColumnName = "id")
    public JobPosting jobPosting;

    @Column(name = "POSTING_DATE")
    public Date postingDate;

    public JobApplication CopyProperties(JobApplication other){
        if(other.id != null){
            student = other.student;
            jobPosting = other.jobPosting;
            postingDate = other.postingDate;
        }
        return this;
    }
}

