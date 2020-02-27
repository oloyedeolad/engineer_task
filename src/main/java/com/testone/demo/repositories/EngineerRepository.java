package com.testone.demo.repositories;

import com.testone.demo.models.Engineer;
import com.testone.demo.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EngineerRepository extends JpaRepository<Engineer, Long> {
    List<Engineer> findAllBySkills_title(String string);
    List<Engineer> findAllBySkills (Skill skill);
}
