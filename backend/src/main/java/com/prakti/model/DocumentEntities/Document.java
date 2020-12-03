package com.prakti.model.DocumentEntities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.validator.constraints.URL;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Entity
@Table(name = "DOCUMENT", schema = "PRAKTICOM")
public class Document extends PanacheEntityBase {

    @Id
    @SequenceGenerator(
            name ="documentSequence",
            sequenceName = "document_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "documentSequence"
    )
    public Long id;

    @URL
    @Column(name = "DOCUMENT_URL")
    public String documentUrl;

    @JsonbTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MIME_TYPE_ID", referencedColumnName = "id")
    public MimeType mimeType;

    @JsonbTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCUMENT_PURPOSE_ID", referencedColumnName = "id")
    public DocumentPurpose documentPurpose;

    public Long getId() {
        return id;
    }
}
