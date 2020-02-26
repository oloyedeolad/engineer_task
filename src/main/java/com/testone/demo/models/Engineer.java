package com.testone.demo.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "engineers")
public class Engineer extends BasicEntity {

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "engineer_skills", joinColumns = @JoinColumn(name = "engineer_id"), inverseJoinColumns = @JoinColumn(name = "skill_id"))
    @JsonManagedReference
    private Set<Skill> skills = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Engineer(String name) {
        this.name = name;
    }

    public Engineer(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engineer engineer = (Engineer) o;
        return Objects.equals(name, engineer.name) &&
                Objects.equals(skills, engineer.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, skills);
    }

    @Override
    public String toString() {
        return "Engineer{" +
                "name='" + name + '\'' +
                ", skills=" + skills +
                ", id=" + id +
                '}';
    }
}
