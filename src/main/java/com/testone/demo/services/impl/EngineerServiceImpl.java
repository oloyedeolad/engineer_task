package com.testone.demo.services.impl;

import com.testone.demo.models.Engineer;
import com.testone.demo.repositories.EngineerRepository;
import com.testone.demo.services.EngineerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EngineerServiceImpl implements EngineerService {

    @Autowired
    private EngineerRepository engineerRepository;

    @Override
    public List<Engineer> findAll() {
        return engineerRepository.findAll();
    }

    @Override
    public Engineer findById(Long aLong) {
        Optional<Engineer> engineerOptional = engineerRepository.findById(aLong);
        return engineerOptional.orElse(null);
    }

    @Override
    public Engineer save(Engineer object) {
        return engineerRepository.save(object);
    }

    @Override
    public void delete(Engineer object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public List<Engineer> findBySkills(String skill) {
        return engineerRepository.findAllBySkills_title(skill);
    }


}
