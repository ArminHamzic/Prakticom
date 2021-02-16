package com.prakti.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SKILL", schema = "PRAKTICOM")
public class Skill extends PanacheEntityBase implements Serializable {

    @Id
    @SequenceGenerator(
            name ="skillSequence",
            sequenceName = "skill_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "skillSequence"
    )
    public Long id;

    @Column
    public String name;

    @Column
    public Rating rating;

    public Skill() {

    }
}
