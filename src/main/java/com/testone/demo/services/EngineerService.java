package com.testone.demo.services;

import com.testone.demo.models.Engineer;

import java.util.List;

public interface EngineerService extends CrudService<Engineer, Long> {
    List<Engineer> findBySkills(String skill);
    List<Engineer> findBySkills(Long id);
}
