package com.example.leaf.service;

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
public class SectionService {

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


    ///////////////////////////////////////////////SECTIONS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

//CREATE a section using the researcherId
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

//get list of sections for a researcher
    public List<Section> getResearcherSectionList(Long researcherId){
        System.out.println("Service calling getResearcherSectionList ==> ");

        Optional<Researcher> researcher = researcherRepository.findById(researcherId);
        if(researcher.isPresent()){
            return researcher.get().getSectionList();
        }else {
            throw new InformationNotFoundException("Researcher with an id of " + researcherId + " was not found");
        }
    }

//DELETE sectionid with researcherid
    public Optional<Section> deleteResearcherSection(Long researcherId, Long sectionId){
        System.out.println("service calling deleteResearcherSection ==> ");
        Optional<Researcher> researcher = researcherRepository.findById(researcherId);
        if(researcher.isPresent()){
            for(Section section : researcher.get().getSectionList()){
                if(section.getId() == sectionId){
                    Section section1 = sectionRepository.findById(sectionId).get();
                    sectionRepository.deleteById(sectionId);
                    return Optional.of(section1);
                }
                throw new InformationNotFoundException("Section with id " + sectionId + " not found");
            }
        }
        throw new InformationNotFoundException("Researcher with id " + researcherId + " not found");

    }

//GET SECTION LIST FOR A RESEARCHER
    public List<Section> getAllSections(){
        System.out.println("service calling getAllResearcherSections");
        return sectionRepository.findAll();
    }










}
