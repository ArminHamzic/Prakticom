package com.prakti.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "JOB_APPLICATION", schema = "prakticom")
public class JobApplication extends PanacheEntityBase {

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
    public Long id;

    @JsonbTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "id")
    public Student student;

    @JsonbTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_POSTING_ID", referencedColumnName = "id")
    public JobPosting jobPosting;

    @Column(name = "POSTING_DATE")
    @JsonbDateFormat(value = "yyyy-MM-dd")
    public Date postingDate;

    public void CopyProperties(JobApplication other){

        this.student = other.student;
        this.jobPosting = other.jobPosting;
        this.postingDate = other.postingDate;
    }

    public Long getId() {
        return id;
    }
}

