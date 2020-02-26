package com.testone.demo.controllers;


import com.testone.demo.models.Engineer;
import com.testone.demo.services.EngineerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/api/engineer")
public class EngineerController {


    private EngineerService engineerService;

    public EngineerController(EngineerService engineerService) {
        this.engineerService = engineerService;
    }

    @PostMapping
    public ResponseEntity<Engineer> createEngineer(@Valid @RequestBody Engineer engineer) throws URISyntaxException {
        Engineer engineerCreated = engineerService.save(engineer);
        return  ResponseEntity.created(new URI("/api/engineer/" + engineerCreated.getId())).body(engineerCreated);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Engineer> findAll() {
        return engineerService.findAll();
    }

    @GetMapping("/skill/{skill}")
    public List<Engineer> findAllBySkillId(@PathVariable("skill") String skill){
        return engineerService.findBySkills(skill);
    }

    @GetMapping("{id}")
    public ResponseEntity<Engineer> findById(@PathVariable("id") Long id){
        Engineer engineer = engineerService.findById(id);
        return ResponseEntity.ok().body(engineer);
    }

    @GetMapping("skills/{id}")
    public ResponseEntity<Set> findEngineerSkills(@PathVariable("id") Long id) {

        Engineer engineer = engineerService.findById(id);
        return ResponseEntity.ok().body(engineer.getSkills());
    }


}
