package com.prakti.model.DocumentEntities;

import com.prakti.model.JobPosting;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Entity
@Table(name = "JOB_POSTING_DOCUMENT", schema = "PRAKTICOM")
public class JobPostingDocument extends PanacheEntityBase {

    @Id
    @SequenceGenerator(
            name ="jobPostingDocumentSequence",
            sequenceName = "job_posting_document_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "jobPostingSequence"
    )
    public Long id;

    @JsonbTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCUMENT_ID", referencedColumnName = "id")
    public Document document;

    @JsonbTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_POSTING_ID", referencedColumnName = "id")
    public JobPosting jobPosting;

    public Long getId() {
        return id;
    }
}
