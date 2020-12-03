package com.prakti.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Entity
@Table(name = "LOCATION", schema = "PRAKTICOM")
public class Location extends PanacheEntity {

    @JsonbTransient
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

    public void CopyProperties(Location other){
        this.streetName = other.streetName;
        this.city = other.city;
        this.zipCode = other.zipCode;
        this.country = other.country;
    }

}
