package com.prakti.control;

import com.prakti.model.DocumentEntities.CompanyDocument;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class CompanyDocumentDAO implements PanacheRepositoryBase<CompanyDocument, Long> {

    public CompanyDocument persistDocument(CompanyDocument document) {
        return this.getEntityManager().merge(document);
    }
}
