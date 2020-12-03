package com.prakti.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Entity
@Table(name = "LOCATION", schema = "PRAKTICOM")
public class Location extends PanacheEntityBase {

    @Id
    @SequenceGenerator(
            name ="locationSequence",
            sequenceName = "location_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "locationSequence"
    )
    Long id;

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

    public Long getId() {
        return id;
    }
}
