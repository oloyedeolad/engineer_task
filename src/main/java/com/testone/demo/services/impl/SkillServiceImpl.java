package com.testone.demo.services.impl;

import com.testone.demo.models.Skill;
import com.testone.demo.repositories.SkillRepository;
import com.testone.demo.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Override
    public Skill findById(Long aLong) {
       Optional<Skill> optionalSkill = skillRepository.findById(aLong);
       return optionalSkill.orElse(null);
    }

    @Override
    public Skill save(Skill object) {
        return skillRepository.save(object);
    }

    @Override
    public void delete(Skill object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
