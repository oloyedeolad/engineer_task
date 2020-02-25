package com.testone.demo;

import com.testone.demo.models.Engineer;
import com.testone.demo.models.Skill;
import com.testone.demo.repositories.EngineerRepository;
import com.testone.demo.repositories.SkillRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }
        @Bean
        public CommandLineRunner mappingDemo(SkillRepository skillRepository,
                                             EngineerRepository engineerRepository) {
            return args -> {

                // create an Engineer
                Engineer engineer = new Engineer("Susan Wenger");

                // save the engineer
                Engineer createdEngineer = engineerRepository.save(engineer);
                // create three skills
                Skill skill1 = new Skill("Machine Learning", "its artificial intelligence");
                Skill skill2 = new Skill("Database Systems", "Its database management");
                Skill skill3 = new Skill("Web Basics", "web design");

                // save skills
                List<Skill> list = skillRepository.saveAll(Arrays.asList(skill1, skill2, skill3));

                //createdEngineer.getSkills().add(skill1);
                // add skills to the engineer
                createdEngineer.getSkills().addAll(list);

                // update engineer
                engineerRepository.save(createdEngineer);
            };
        }


}
