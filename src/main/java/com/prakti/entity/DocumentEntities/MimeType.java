package com.prakti.entity.DocumentEntities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table(name = "MIME_TYPE", schema = "PRAKTICOM")
public class MimeType extends PanacheEntity {
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "MIME_TYPE")
    public AllowedFileFormats MimeType;
}
