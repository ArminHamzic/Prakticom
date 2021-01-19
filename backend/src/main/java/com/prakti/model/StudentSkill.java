package com.prakti.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "STUDENT_SKILL", schema = "PRAKTICOM")
public class StudentSkill extends PanacheEntityBase implements Serializable {

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
    Long id;


    public Skill skill;

    @JsonbTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "id")
    public Student student;
}
