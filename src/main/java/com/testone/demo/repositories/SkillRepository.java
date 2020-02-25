package com.testone.demo.repositories;

import com.testone.demo.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long>
{
}
