package com.testone.demo;


import com.testone.demo.controllers.EngineerController;
import com.testone.demo.models.Engineer;
import com.testone.demo.models.Skill;
import com.testone.demo.services.EngineerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EngineerController.class)
public class EngineerRestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EngineerService engineerService;

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
        engineers.add(engineer2);

        given(engineerService.findAll()).willReturn(engineers);
    }


    @Test
    public void getAllengineers () throws Exception {

        mvc.perform(get("/api/engineer/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }
}
