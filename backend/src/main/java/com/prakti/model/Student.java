package com.prakti.model;

import com.prakti.model.DocumentEntities.StudentDocument;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "STUDENT", schema = "PRAKTICOM")
public class Student extends PanacheEntity {
    @Column(name = "USER_NAME", unique = true)
    public String userName;
    @Column(name = "FIRST_NAME")
    public String firstName;
    @Column(name = "LAST_NAME")
    public String lastName;
    @Column(unique = true)
    public String email;
    @Column(unique = true)
    public String phoneNumber;
    @Column
    public Date birthDate;
    @Column
    public String school;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    public List<StudentDocument> documents = new ArrayList<>();

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    public List<JobApplication> jobApplications = new ArrayList<>();


    public Student CopyProperties(Student other){
        if(other.id != null){
            firstName = other.firstName;
            lastName = other.lastName;
            email = other.email;
            phoneNumber = other.phoneNumber;
            birthDate = other.birthDate;
            school = other.school;
            documents = other.documents;
            jobApplications = other.jobApplications;
        }
        return this;
    }
}
