package com.prakti.entity.DocumentEntities;

import com.prakti.entity.Student;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT_DOCUMENTS", schema = "PRAKTICOM")
public class StudentDocuments extends PanacheEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCUMENT_ID", referencedColumnName = "id")
    public Document document;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "id")
    public Student documentPurpose;
}
