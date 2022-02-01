package com.example.leaf.service;

import com.example.leaf.exceptions.InformationExistException;
import com.example.leaf.exceptions.InformationNotFoundException;
import com.example.leaf.model.Researcher;
import com.example.leaf.repository.ResearcherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //GET ONE RESEARCHER WITH ID
    public Optional<Researcher> getOneResearcher(Long researcherId){

        Optional<Researcher> researcher = researcherRepository.findById(researcherId);
        if(researcher.isPresent()){
            return researcher;
        }else{
            throw new InformationNotFoundException("Researcher with id of " + researcherId +  " not found");
        }

    }

//UPDATE THE RESEARCHER RECORD
    public Researcher updateResearcher(Long researcherId, Researcher researcherObj) {
        System.out.println("Service calling updateResearcher==>");
        Optional<Researcher> researcher = researcherRepository.findById(researcherId);
        if (researcher.isPresent()) {
            Researcher updateResearcher = researcherRepository.findById(researcherId).get();
            updateResearcher.setFirstName(researcherObj.getFirstName());
            updateResearcher.setLastName(researcherObj.getLastName());
            updateResearcher.setEmail(researcherObj.getEmail());
            updateResearcher.setPhone(researcherObj.getPhone());
            updateResearcher.setTitle(researcherObj.getTitle());
            return researcherRepository.save(updateResearcher);
        } else {
            throw new InformationNotFoundException("Researcher with id " + researcherId + " not found");
        }
    }






}
