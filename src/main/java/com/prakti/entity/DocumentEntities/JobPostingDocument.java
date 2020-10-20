package com.prakti.entity.DocumentEntities;

import com.prakti.entity.JobPosting;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table(name = "JOB_POSTING_DOCUMENT", schema = "PRAKTICOM")
public class JobPostingDocument extends PanacheEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCUMENT_ID", referencedColumnName = "id")
    public Document document;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_POSTING_ID", referencedColumnName = "id")
    public JobPosting jobPosting;
}
