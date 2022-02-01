package com.example.leaf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class ResearchController {


    //get hello world
    @GetMapping(path = "/hello-world/")
    public String getHelloWorld(){
        return "hello world";
    }






}
