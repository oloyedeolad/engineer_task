package com.testone.demo.controllers;

import com.testone.demo.models.Score;
import com.testone.demo.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping
    public ResponseEntity<Score> createScore(@Valid @RequestBody Score score) {
        Score createdScore = scoreService.save(score);
        return ResponseEntity.ok().body(createdScore);
    }

    @GetMapping("/engineer/{id}")
    public ResponseEntity<List> getEngineersScores(@PathVariable("id") Long along) {
        List<Score> scoreList = scoreService.findByEngineerId(along);
        return ResponseEntity.ok().body(scoreList);
    }


    @GetMapping("/engineer/{id}/average")
    public ResponseEntity<Double> getAverageEngineerScore(@PathVariable("id") Long along) {
        List<Score> scoreList = scoreService.findByEngineerId(along);

        return ResponseEntity.ok().body(getAverage(scoreList));

    }


    public ResponseEntity<List<Score>> findTopNEngineer(@RequestBody int pet, @PathVariable("id") Long along) {
        List<Score> list =   scoreService.findTopNEngineer(pet, along);
        return ResponseEntity.ok().body(list);
    }


    private Double getAverage(List<Score> list) {
        double a = 0;
        for (Score score: list)
        {
             a += score.getScore();
        }

        return a/list.size();
    }
}

