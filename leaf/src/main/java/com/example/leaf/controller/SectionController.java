package com.example.leaf.controller;

import com.example.leaf.model.Section;
import com.example.leaf.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class SectionController {
    @Autowired
    public SectionService sectionService;

    ///////////////////////////////////////////////SECTIONS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

//CREATE a section using the researcherId
    @PostMapping("/researcher/{researcherId}/section/")
    public Section createResearcherSection(@PathVariable(value = "researcherId")Long researcherId,
                                           @RequestBody Section sectionObj){
        return sectionService.createResearcherSection(researcherId, sectionObj);
    }

//GET list of sections for a researcher
    @GetMapping("/researcher/{researcherId}/section/")
    public List<Section> getResearcherSectionList(@PathVariable(value = "researcherId")Long researcherId){
        return sectionService.getResearcherSectionList(researcherId);
    }

//DELETE sectionid with researcherid
    @DeleteMapping("/researcher/{researcherId}/section/{sectionId}/")
    public Optional<Section> deleteResearcherSection(@PathVariable(value="researcherId")Long researcherId,
                                                     @PathVariable(value = "sectionId")Long sectionId){
        return sectionService.deleteResearcherSection(researcherId, sectionId);
    }

//GET SECTION LIST FOR A RESEARCHER
    @GetMapping("/sections/")
    public List<Section> getAllSections(){
        return sectionService.getAllSections();
    }






}
