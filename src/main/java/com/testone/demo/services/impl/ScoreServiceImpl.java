package com.testone.demo.services.impl;

import com.testone.demo.models.Score;
import com.testone.demo.repositories.ScoreRepository;
import com.testone.demo.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public List<Score> findAll() {
        return scoreRepository.findAll();
    }

    @Override
    public Score findById(Long aLong) {
        Optional<Score> optionalScore = scoreRepository.findById(aLong);
        return optionalScore.orElse(null);
    }

    @Override
    public Score save(Score object) {
        return scoreRepository.save(object);
    }

    @Override
    public void delete(Score object) {
        scoreRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        scoreRepository.findById(aLong);
    }

    @Override
    public List<Score> findByEngineerId(Long along) {
        return scoreRepository.findAllByEngineer_Id(along);
    }

    @Override
    public List<Score> findTopNEngineer(int n) {
        return scoreRepository.findTopNByScore(n);
    }
}
