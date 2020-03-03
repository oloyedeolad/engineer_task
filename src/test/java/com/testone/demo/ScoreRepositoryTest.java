package com.testone.demo;


import com.testone.demo.models.Engineer;
import com.testone.demo.models.Score;
import com.testone.demo.models.Skill;
import com.testone.demo.repositories.EngineerRepository;
import com.testone.demo.repositories.ScoreRepository;
import com.testone.demo.repositories.SkillRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ScoreRepositoryTest {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private EngineerRepository engineerRepository;
    @Autowired
    private SkillRepository skillRepository;

    private Score score, score2;

    @Before
    private void setUp() {
        Engineer createdEngineer = engineerRepository.save(new Engineer("Jackie Chan"));
        Engineer createdEngineer2 = engineerRepository.save(new Engineer("Jet Li"));
        Skill skill1 = new Skill("Machine Learning", "its artificial intelligence");
        Skill skill2 = new Skill("Database Systems", "Its database management");

        score = new Score(createdEngineer, skill1, 20);
        score2 = new Score(createdEngineer, skill2, 30);

        scoreRepository.save(score);
    }




}
