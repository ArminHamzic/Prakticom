package com.prakti.model.DocumentEntities;

import com.prakti.model.Company;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table(name = "COMPANY_DOCUMENT", schema = "PRAKTICOM")
public class CompanyDocument extends PanacheEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCUMENT_ID", referencedColumnName = "id")
    public Document document;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "id")
    public Company company;
}
