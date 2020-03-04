package com.testone.demo.services;

import com.testone.demo.models.Score;

import java.util.List;

public interface ScoreService extends CrudService<Score, Long> {
    List<Score> findByEngineerId(Long along);
    List<Score> findTopNEngineer(int n);
}
