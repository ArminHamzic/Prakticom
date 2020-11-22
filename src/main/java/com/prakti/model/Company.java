package com.prakti.model;

import com.prakti.model.DocumentEntities.StudentDocument;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COMPANY", schema = "PRAKTICOM")
public class Company extends PanacheEntity {
    @Column(unique = true)
    public String name;
    @Column
    public String description;
    @Column(name = "CONTACT_NAME")
    public String contactName;
    @Column(unique = true, name = "CONTACT_EMAIL")
    public String contactEmail;
    @Column(name = "CONTACT_PHONE_NUMBER")
    public String contactPhoneNumber;
    @Column(unique = true)
    public String url;

    @OneToMany(mappedBy = "company_documents")
    public List<StudentDocument> documents = new ArrayList<>();

    @OneToMany(mappedBy = "job_application")
    public List<JobApplication> jobApplications = new ArrayList<>();

    @OneToMany(mappedBy = "job_posting")
    public List<JobPosting> jobPostings = new ArrayList<>();


    public Company CopyProperties(Company other){
        if(other.id != null){
            name = other.name;
            description = other.description;
            contactName = other.contactName;
            contactEmail = other.contactEmail;
            contactPhoneNumber = other.contactPhoneNumber;
            url = other.url;
            documents = other.documents;
            jobApplications = other.jobApplications;
            jobPostings = other.jobPostings;
        }
        return this;
    }
}
