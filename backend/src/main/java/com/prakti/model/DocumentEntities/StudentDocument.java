package com.prakti.model.DocumentEntities;

import com.prakti.model.Student;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Entity
@Table(name = "STUDENT_DOCUMENT", schema = "PRAKTICOM")
public class StudentDocument extends PanacheEntityBase {


    @Id
    @SequenceGenerator(
            name ="studentDocumentSequence",
            sequenceName = "student_document_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "studentDocumentSequence"
    )
    public Long id;

    @JsonbTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCUMENT_ID", referencedColumnName = "id")
    public Document document;

    @JsonbTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "id")
    public Student student;

    public Long getId() {
        return id;
    }
}
