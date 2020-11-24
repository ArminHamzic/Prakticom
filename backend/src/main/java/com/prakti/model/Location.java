package com.prakti.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table(name = "LOCATION", schema = "PRAKTICOM")
public class Location extends PanacheEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID")
    public Company company;

    @Column(name = "STREET_NAME")
    public String streetName;

    @Column(name = "CITY")
    public String city;

    @Column(name = "ZIP_CODE")
    public String zipCode;

    @Column(name = "COUNTRY")
    public String country;

    public Location CopyProperties(Location other){
        if(other.id != null){
            company = other.company;
            streetName = other.streetName;
            city = other.city;
            zipCode = other.zipCode;
            country = other.country;
        }
        return this;
    }

}
