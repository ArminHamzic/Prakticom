package com.prakti.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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

    public Company CopyProperties(Company other){
        if(other.id != null){
            name = other.name;
            description = other.description;
            contactName = other.contactName;
            contactEmail = other.contactEmail;
            contactPhoneNumber = other.contactPhoneNumber;
            url = other.url;
        }
        return this;
    }
}
