package com.testone.demo.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
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

    @OneToMany(mappedBy = "skill")
    private Set<Score> score;


    public Skill(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Skill() {

    }

}
