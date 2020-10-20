package com.prakti.entity.DocumentEntities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table(name = "DOCUMENT_PURPOSE", schema = "PRAKTICOM")
public class DocumentPurpose extends PanacheEntity {
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "DOCUMENT_PURPOSE")
    public PossibleDocumentPurposes DocumentPurpose;
}
