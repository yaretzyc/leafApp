package com.example.leaf.service;

import com.example.leaf.exceptions.InformationExistException;
import com.example.leaf.model.Researcher;
import com.example.leaf.repository.ResearcherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResearcherService {

    private ResearcherRepository researcherRepository;

    @Autowired
    public void setResearcherRepository(ResearcherRepository researcherRepository){
        this.researcherRepository = researcherRepository;
    }


    public Researcher createResearcher(Researcher researcherObj){
        System.out.println("Service calling createResearcher method ==> ");

        Researcher researcher  = researcherRepository.findByEmail(researcherObj.getEmail());

        if(researcher != null){ //CATEGORY NOT NULL MEANS IT EXISTS ; IF IT IS NULL MEANS DOES NOT EXISTS
            throw new InformationExistException("researcher with email" + researcher.getEmail()  + " already exists"); //409 //category.getName9) is like indian
        }else{
            return researcherRepository.save(researcherObj); //if  null then doesn;t exist than save the data

        }
    }

    ///get list of researchers
    public List<Researcher> getResearcherList(){
        return researcherRepository.findAll();
    }

    //


}