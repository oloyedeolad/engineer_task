package com.testone.demo.controllers;


import com.testone.demo.models.Skill;
import com.testone.demo.services.SkillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/skills")
public class SkillController {


    private SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping
    public ResponseEntity<Skill> createSKill(@Valid @RequestBody Skill skill) throws URISyntaxException {
        Skill createdSkill = skillService.save(skill);
        return ResponseEntity.created(new URI("/" + createdSkill.getId())).body(createdSkill);
    }
}
