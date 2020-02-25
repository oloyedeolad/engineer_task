package com.testone.demo;


import com.testone.demo.models.Engineer;
import com.testone.demo.models.Skill;
import com.testone.demo.repositories.EngineerRepository;
import com.testone.demo.repositories.SkillRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EngineerRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private EngineerRepository engineerRepository;
    @Autowired
    private SkillRepository skillRepository;



    @Test
    public void createEngineerTest() {
       Engineer createdEngineer = engineerRepository.save(new Engineer("Jackie Chan"));
       assertThat(createdEngineer.getName() == "Jackie Chan");
    }

    @Test
    public void attachSkillsToEngineerTest() {
        Engineer createdEngineer = engineerRepository.save(new Engineer("Jackie Chan"));
        Skill skill1 = new Skill("Machine Learning", "its artificial intelligence");
        Skill skill2 = new Skill("Database Systems", "Its database management");

        List<Skill> list = skillRepository.saveAll(Arrays.asList(skill1, skill2));
        createdEngineer.getSkills().addAll(list);
        assertThat(list.size() == 2);
        assertThat(list.contains(skill1));
    }

    @Test
    public void findEngineerBySkillTest() {


        List<Engineer> engineers = engineerRepository.findAllBySkills_title("Machine Learning");

        assertThat(engineers.size() > 0);

    }


}
