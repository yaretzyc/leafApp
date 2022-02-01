package com.example.leaf.controller;

import com.example.leaf.model.Researcher;
import com.example.leaf.service.ResearcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/researchers/")
    public List<Researcher> getResearcherList(){
        return researcherService.getResearcherList();
    }






}
