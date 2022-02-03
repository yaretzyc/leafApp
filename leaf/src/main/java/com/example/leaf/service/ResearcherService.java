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

/////////////////////////////////////////////////////RESEARCHER \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//CREATE researcher
    public Researcher createResearcher(Researcher researcherObj){
        System.out.println("Service calling createResearcher method ==> ");

        Researcher researcher  = researcherRepository.findByEmail(researcherObj.getEmail());

        if(researcher != null){ //researcher NOT NULL MEANS IT EXISTS ; IF IT IS NULL MEANS DOES NOT EXISTS
            throw new InformationExistException("researcher with email " + researcher.getEmail()  + " already exists");
        }else{
            return researcherRepository.save(researcherObj); //if  null then does not exist than save the data
        }
    }

//GET list of researchers
    public List<Researcher> getResearcherList(){
        System.out.println("Service calling getResearcherList ==> ");
        return researcherRepository.findAll();
    }

//GET ONE RESEARCHER WITH ID
    public Optional<Researcher> getOneResearcher(Long researcherId){
        System.out.println("Service Calling getOneResearcher ==>");
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

//DELETE RESEARCHER RECORD
    public Optional<Researcher> deleteResearcher(Long researcherId){
        System.out.println("Service calling deleteResearcher ==>");
        Optional<Researcher> researcher = researcherRepository.findById(researcherId);
        if(researcher.isPresent()) {
            researcherRepository.deleteById(researcherId);
            return researcher;
        }else{
            throw new InformationNotFoundException("Researcher with id " + researcherId + " not found");
        }
    }

}
