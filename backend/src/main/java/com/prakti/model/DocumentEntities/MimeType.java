package com.prakti.model.DocumentEntities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
public class MimeType extends PanacheEntityBase {

    @Id
    @SequenceGenerator(
            name ="mimeTypeSequence",
            sequenceName = "mime_type_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "mimeTypeSequence"
    )
    public Long id;

    @Enumerated(EnumType.ORDINAL)
    public AllowedFileFormats MimeType;
}
