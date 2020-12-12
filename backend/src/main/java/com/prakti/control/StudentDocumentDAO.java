package com.prakti.control;

import com.prakti.model.DocumentEntities.StudentDocument;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class StudentDocumentDAO implements PanacheRepositoryBase<StudentDocument, Long> {

    public StudentDocument persistDocument(StudentDocument document) {
        return this.getEntityManager().merge(document);
    }
}
