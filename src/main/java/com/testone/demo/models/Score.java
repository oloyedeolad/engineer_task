package com.testone.demo.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Score extends BasicEntity {

    @ManyToOne
    @JoinColumn(name = "engineer_id")
    Engineer engineer;
    @ManyToOne()
    @JoinColumn(name = "skill_id")
    Skill skill;
    private int mark;
}
