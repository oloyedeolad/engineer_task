package com.testone.demo;


import com.testone.demo.models.Engineer;
import com.testone.demo.models.Score;
import com.testone.demo.models.Skill;
import com.testone.demo.repositories.EngineerRepository;
import com.testone.demo.repositories.ScoreRepository;
import com.testone.demo.repositories.SkillRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ScoreRepositoryTest {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private EngineerRepository engineerRepository;
    @Autowired
    private SkillRepository skillRepository;

    private Score score, score2, score3, score4;
    Engineer createdEngineer;

    @Before
    public void setUp() {
        createdEngineer = engineerRepository.save(new Engineer("Jackie Chan"));
        Engineer createdEngineer2 = engineerRepository.save(new Engineer("Jet Li"));
        Skill skill1 = new Skill("Machine Learning", "its artificial intelligence");
        Skill skill2 = new Skill("Database Systems", "Its database management");

        List<Skill> skillList = new ArrayList<>();
        skillList.add(skill1);
        skillList.add(skill2);
        skillRepository.saveAll(skillList);
        score = new Score(createdEngineer, skill1, 20);
        score2 = new Score(createdEngineer, skill2, 30);
        score3 = new Score(createdEngineer2, skill1, 15);
        score4 = new Score(createdEngineer2, skill2, 50);

        List<Score> list = new ArrayList<>();
        list.add(score);
        list.add(score2);
        list.add(score3);
        list.add(score4);

        scoreRepository.saveAll(list);
    }

    @Test
    public void TestFindByEngineerId() {


       List<Score> scoreList =  scoreRepository.findAllByEngineer_Id(1L);
       assertThat(scoreList.size() > 1);
       assertThat(!scoreList.isEmpty());
    }


    @Test
    public void TestFindBySkillHighestScore() {

        List<Score> scoreList = scoreRepository.findTopNByScore(1, 1L);
        assertThat(!scoreList.isEmpty());
        assertThat(scoreList.size() > 0);
        assertThat(scoreList.get(0).getMark() > scoreList.get(1).getMark());
    }

}
