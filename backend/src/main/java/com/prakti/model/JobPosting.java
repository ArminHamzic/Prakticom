package com.prakti.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "JOB_POSTING", schema = "PRAKTICOM")
public class JobPosting extends PanacheEntityBase implements Serializable {

    @Id
    @SequenceGenerator(
            name ="jobPostingSequence",
            sequenceName = "job_posting_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "jobPostingSequence"
    )
    Long id;

    @Column(name = "JOB_TITLE")
    public String jobTitle;
    @Column(name = "JOB_DESCRIPTION")
    @Size(max = 2000)
    public String jobDescription;

    @JsonbTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "id")
    public Company company;

    @JsonbDateFormat(value = "yyyy-MM-dd")
    @Column(name = "POSTING_DATE")
    public Date postingDate;
    @Column
    public String timespan;
    @Column(name = "field_of_work")
    public FieldOfWork fieldOfWork;

    @OneToMany(mappedBy = "jobPosting", fetch = FetchType.LAZY)
    public List<JobApplication> jobApplications = new ArrayList<>();

    public void CopyProperties(JobPosting other){
        this.jobTitle = other.jobTitle;
        this.jobDescription = other.jobDescription;
        this.postingDate = other.postingDate;
        this.timespan = other.timespan;
    }

    public Long getId() {
        return id;
    }
}
