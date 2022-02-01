package com.example.leaf.controller;

import com.example.leaf.model.Researcher;
import com.example.leaf.service.ResearcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class ResearchController {

    @Autowired
    public ResearcherService researcherService;





    //get hello world
    @GetMapping(path = "/hello-world/")
    public String getHelloWorld(){
        return "hello world";
    }

    //create researcher
    @PostMapping("/researcher/")
    public Researcher createResearcher(@RequestBody Researcher researcherObj){
        return researcherService.createResearcher(researcherObj);
    }

    //GET LIST OF RESEARCHERS
    @GetMapping("/researchers/")
    public List<Researcher> getResearcherList(){
        return researcherService.getResearcherList();
    }

    //GET ONLY ONE RESEARCHER
    @GetMapping("/researcher/{researcherId}/")
    public Optional<Researcher> getOneResearcher(@PathVariable(value = "researcherId")Long researcherId){
        return researcherService.getOneResearcher(researcherId);
    }
//UPDATE RESEARCHER RECORD
    @PutMapping("/researcher/{researcherId}/")
    public Researcher updateResearcher(@PathVariable(value = "researcherId") Long researcherId,
                                       @RequestBody Researcher researcherObj){
        return researcherService.updateResearcher(researcherId, researcherObj);
    }









}
