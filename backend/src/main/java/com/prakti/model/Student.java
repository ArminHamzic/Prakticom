package com.prakti.model;

import com.prakti.model.DocumentEntities.StudentDocument;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.validator.constraints.Email;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "STUDENT", schema = "PRAKTICOM")
public class Student extends PanacheEntityBase implements Serializable {

    @Id
    @SequenceGenerator(
            name ="studentSequence",
            sequenceName = "student_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "studentSequence"
    )
    Long id;

    @Column(name = "USER_NAME", unique = true)
    public String userName;
    @Column(name = "FIRST_NAME")
    public String firstName;
    @Column(name = "LAST_NAME")
    public String lastName;
    @Email
    @Column(unique = true)
    public String email;
    @Column(unique = true)
    public String phoneNumber;
    @JsonbDateFormat(value = "yyyy-MM-dd")
    @Column
    public LocalDate birthDate;
    @Column
    public String school;

    @Transient
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    public List<StudentDocument> documents = new ArrayList<>();

    @Transient
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    public List<JobApplication> jobApplications = new ArrayList<>();


    public void CopyProperties(Student other){
        if (other.userName != null) this.userName = other.userName;
        if (other.firstName != null) this.firstName = other.firstName;
        if (other.lastName != null) this.lastName = other.lastName;
        if (other.email != null) this.email = other.email;
        if (other.phoneNumber != null) this.phoneNumber = other.phoneNumber;
        if (other.birthDate != null) this.birthDate = other.birthDate;
        if (other.school != null) this.school = other.school;
    }

    public Long getId() {
        return id;
    }
}
