package com.prakti.model;

import com.prakti.model.DocumentEntities.StudentDocument;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.validator.constraints.Email;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import java.io.Serializable;
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
    public Date birthDate;
    @Column
    public String school;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    public List<StudentDocument> documents = new ArrayList<>();

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    public List<JobApplication> jobApplications = new ArrayList<>();


    public void CopyProperties(Student other){
        this.userName = other.userName;
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.email = other.email;
        this.phoneNumber = other.phoneNumber;
        this.birthDate = other.birthDate;
        this.school = other.school;
    }
}
