package com.prakti.model.DocumentEntities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;


@Entity
@Table(name = "DOCUMENT_PURPOSE", schema = "PRAKTICOM")
public class DocumentPurpose extends PanacheEntityBase {

    @Id
    @SequenceGenerator(
            name ="documentPurposeSequence",
            sequenceName = "document_purpose_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "documentPurposeSequence"
    )
    public Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "DOCUMENT_PURPOSE")
    public PossibleDocumentPurposes DocumentPurpose;
}
