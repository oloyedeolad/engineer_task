package com.testone.demo.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;




@Entity
@Table(name = "skills")
@Getter
@Setter
public class Skill extends BasicEntity {

    private String title;
    private String description;

    @ManyToMany(mappedBy = "skills", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Engineer> engineers = new HashSet<>();


    public Skill(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Skill() {

    }

}
