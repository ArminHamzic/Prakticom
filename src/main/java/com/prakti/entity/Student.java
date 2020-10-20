package com.prakti.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "STUDENT", schema = "PRAKTICOM")
public class Student extends PanacheEntity {
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

    public Student CopyProperties(Student other){
        if(other.id != null){
            firstName = other.firstName;
            lastName = other.lastName;
            email = other.email;
            phoneNumber = other.phoneNumber;
            birthDate = other.birthDate;
            school = other.school;
        }
        return this;
    }
}
