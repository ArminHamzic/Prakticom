package com.prakti.model.DocumentEntities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table(name = "DOCUMENT", schema = "PRAKTICOM")
public class Document extends PanacheEntity {
    @Column(name = "DOCUMENT_URL")
    public String documentUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MIME_TYPE_ID", referencedColumnName = "id")
    public MimeType mimeType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCUMENT_PURPOSE_ID", referencedColumnName = "id")
    public DocumentPurpose documentPurpose;

}
