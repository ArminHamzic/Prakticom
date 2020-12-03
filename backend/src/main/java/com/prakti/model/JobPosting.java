package com.prakti.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
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
    public LocalDate postingDate;
    @Column
    public String timespan;
    @Column(name = "field_of_work")
    public FieldOfWork fieldOfWork;

    @Transient
    @OneToMany(mappedBy = "jobPosting", fetch = FetchType.LAZY)
    public List<JobApplication> jobApplications = new ArrayList<>();

    public void CopyProperties(JobPosting other){
        if(other.jobTitle != null)this.jobTitle = other.jobTitle;
        if(other.jobDescription != null)this.jobDescription = other.jobDescription;
        if(other.postingDate != null)this.postingDate = other.postingDate;
        if(other.timespan != null)this.timespan = other.timespan;
        if(other.fieldOfWork != null)this.fieldOfWork = other.fieldOfWork;
    }

    public Long getId() {
        return id;
    }
}
