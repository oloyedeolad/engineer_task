package com.testone.demo.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;




@Entity
@Table(name = "engineers")
@Getter
@Setter
public class Engineer extends BasicEntity {

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "engineer_skills", joinColumns = @JoinColumn(name = "engineer_id"), inverseJoinColumns = @JoinColumn(name = "skill_id"))
    @JsonManagedReference
    private Set<Skill> skills = new HashSet<>();

    @OneToMany(mappedBy = "engineer")
    private  Set<Score> score;

    public Engineer(String name) {
        this.name = name;
    }

    public Engineer(){

    }



}
