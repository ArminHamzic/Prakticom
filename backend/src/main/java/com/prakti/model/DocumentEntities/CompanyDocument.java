package com.prakti.model.DocumentEntities;

import com.prakti.model.Company;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Entity
@Table(name = "COMPANY_DOCUMENT", schema = "PRAKTICOM")
public class CompanyDocument extends PanacheEntityBase {

    @Id
    @SequenceGenerator(
            name ="companyDocumentSequence",
            sequenceName = "company_document_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "companySequence"
    )
    public Long id;

    @JsonbTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCUMENT_ID", referencedColumnName = "id")
    public Document document;

    @JsonbTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "id")
    public Company company;

    public Long getId() {
        return id;
    }
}
