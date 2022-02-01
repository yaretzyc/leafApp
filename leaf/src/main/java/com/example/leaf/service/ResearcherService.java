package com.example.leaf.service;

import com.example.leaf.exceptions.InformationExistException;
import com.example.leaf.exceptions.InformationNotFoundException;
import com.example.leaf.model.Researcher;
import com.example.leaf.model.Section;
import com.example.leaf.repository.ResearcherRepository;
import com.example.leaf.repository.SectionRepository;
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

    private SectionRepository sectionRepository;

    @Autowired
    public void setSectionRepository(SectionRepository sectionRepository){
        this.sectionRepository= sectionRepository;
    }


    public Researcher createResearcher(Researcher researcherObj){
        System.out.println("Service calling createResearcher method ==> ");

        Researcher researcher  = researcherRepository.findByEmail(researcherObj.getEmail());

        if(researcher != null){ //researcher NOT NULL MEANS IT EXISTS ; IF IT IS NULL MEANS DOES NOT EXISTS
            throw new InformationExistException("researcher with email" + researcher.getEmail()  + " already exists");
        }else{
            return researcherRepository.save(researcherObj); //if  null then does not exist than save the data
        }
    }

    ///get list of researchers
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


    ///////////////////////////////////////////////SECTIONS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


    //creating a section using the researcherId
    public Section createResearcherSection(Long researcherId, Section sectionObj){
        System.out.println("Service calling createResearcherSection ==> ");

        Optional<Researcher> researcher = researcherRepository.findById(researcherId);
        if(researcher.isPresent()){
            sectionObj.setResearcher(researcher.get());
            return sectionRepository.save(sectionObj);
        }else {
            throw new InformationNotFoundException("Researcher with id "  + researcherId + " not found");

        }

    }


    public List<Section> getResearcherSectionList(Long researcherId){
        System.out.println("Service calling getResearcherSectionList ==> ");

        Optional<Researcher> researcher = researcherRepository.findById(researcherId);
        if(researcher.isPresent()){
            return researcher.get().getSectionList();
        }else {
            throw new InformationNotFoundException("Researcher with an id of " + researcherId + " was not found");
        }


    }










}
