package com.prakti.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "JOB_POSTING", schema = "PRAKTICOM")
public class JobPosting extends PanacheEntity {
    public String jobTitle;
}
