package com.prakti.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table(name = "LOCATION", schema = "PRAKTICOM")
public class Location extends PanacheEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID")
    public Company company;
    @Column
    public String country;
    @Column
    public String zipCode;
    @Column
    public String streetName;
    @Column
    public int streetNumber;

    public Location CopyProperties(Location other){
        if(other.id != null){
            company = other.company;
            country = other.country;
            zipCode = other.zipCode;
            streetName = other.streetName;
            streetNumber = other.streetNumber;
        }
        return this;
    }

}
