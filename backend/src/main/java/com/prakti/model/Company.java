package com.prakti.model;

import com.prakti.model.DocumentEntities.CompanyDocument;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.validator.constraints.URL;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COMPANY", schema = "PRAKTICOM")
public class Company extends PanacheEntityBase implements Serializable {

    @Id
    @SequenceGenerator(
            name ="companySequence",
            sequenceName = "company_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "companySequence"
    )
    public Long id;
    @Column(unique = true)
    public String name;
    @Column
    @Size(max=2000)
    public String description;
    @Column(name = "CONTACT_NAME")
    public String contactName;
    @Column(name = "CONTACT_EMAIL", unique = true)
    public String contactEmail;
    @Column(name = "CONTACT_PHONE_NUMBER")
    public String contactPhoneNumber;
    @URL
    @Column(unique = true)
    public String url;
    @Column(name = "USER_NAME", unique = true)
    public String userName;
    @Column(name = "PASSWORD")
    public String password;
    @Column(name = "LOGO_URL")
    public String logoUrl;



    /*@OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    public List<CompanyDocument> documents = new ArrayList<>();*/

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<JobPosting> jobPostings = new ArrayList<>();

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Location> locations = new ArrayList<>();


    public void CopyProperties(Company other){

        if(other.name != null) this.name = other.name;
        if(other.description != null)this.description = other.description;
        if(other.contactName != null)this.contactName = other.contactName;
        if(other.contactEmail != null)this.contactEmail = other.contactEmail;
        if(other.contactPhoneNumber != null)this.contactPhoneNumber = other.contactPhoneNumber;
        if(other.url != null)this.url = other.url;
        if(other.userName != null)this.userName = userName;
        if(other.password != null)this.password = password;
        if(other.logoUrl != null)this.logoUrl = logoUrl;
    }

    public Long getId() {
        return id;
    }
}
