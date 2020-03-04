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

    @GetMapping("/top/{id}/{len}")
    public ResponseEntity<List<Score>> findTopNEngineer(@PathVariable("len") int pet, @PathVariable("id") int along) {
        List<Score> list =   scoreService.findTopNEngineer(pet);
        if (list.size() < along || list.size() < 1) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(list.subList(0, along));
    }



    private Double getAverage(List<Score> list) {
        double a = 0;
        for (Score score: list)
        {
             a += score.getMark();
        }

        return a/list.size();
    }
}

