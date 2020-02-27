package com.testone.demo.services;

import com.testone.demo.models.Engineer;
import com.testone.demo.models.Skill;

import java.util.List;

public interface EngineerService extends CrudService<Engineer, Long> {
    List<Engineer> findBySkills(String skill);
    List<Engineer> findBySkills(Skill skill);
}
