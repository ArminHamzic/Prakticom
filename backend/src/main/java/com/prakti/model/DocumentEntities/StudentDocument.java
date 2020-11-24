package com.prakti.model.DocumentEntities;

import com.prakti.model.Student;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT_DOCUMENT", schema = "PRAKTICOM")
public class StudentDocument extends PanacheEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCUMENT_ID", referencedColumnName = "id")
    public Document document;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "id")
    public Student student;
}
