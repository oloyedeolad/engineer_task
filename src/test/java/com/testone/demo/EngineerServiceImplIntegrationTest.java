package com.testone.demo;

import com.testone.demo.models.Engineer;
import com.testone.demo.models.Skill;
import com.testone.demo.repositories.EngineerRepository;
import com.testone.demo.services.EngineerService;
import com.testone.demo.services.impl.EngineerServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
public class EngineerServiceImplIntegrationTest {

    @TestConfiguration
    static class EngineerServiceImplTestContextConfiguration {

        @Bean
        public EngineerService engineerService() {
            return new EngineerServiceImpl();
        }
    }

    @Autowired
    private EngineerService engineerService;

    @MockBean
    private EngineerRepository engineerRepository;



    @Before
    public void setUp() {
        Engineer engineer = new Engineer("Susan Wenger");
        Engineer engineer2 = new Engineer("Susan Ololade");
        // save the engineer
        // create three skills
        Skill skill1 = new Skill("Machine Learning", "its artificial intelligence");
        Skill skill2 = new Skill("Database Systems", "Its database management");

        engineer.getSkills().add(skill1);
        engineer.getSkills().add(skill2);
        engineer2.getSkills().add(skill2);
        List<Engineer> engineers = new ArrayList<>();
        engineers.add(engineer);
        List<Engineer> engineers2 = new ArrayList<>();
        engineers2.add(engineer2);

        Mockito.when(engineerRepository.findAllBySkills_title(skill1.getTitle()))
                .thenReturn(engineers);

        Mockito.when(engineerRepository.findAllBySkills_id(skill2.getId()))
                .thenReturn(engineers2);
    }


    @Test
    public void when_nameValidEngineers_befound() {

        List<Engineer> foundEngineers = engineerService.findBySkills("Machine Learning");


        assertThat(foundEngineers.size() == 1);
        assertThat(foundEngineers.get(0) != null);
        assertThat(foundEngineers.get(0).getName() == "Susan Wenger");
    }

}
