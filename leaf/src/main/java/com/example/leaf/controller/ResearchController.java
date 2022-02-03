package com.example.leaf.controller;

import com.example.leaf.model.Plant;
import com.example.leaf.model.Researcher;
import com.example.leaf.model.Section;
import com.example.leaf.model.Student;
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
//////////////////////////////////////////////////////RESEARCHER \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
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

    //DELETE RESEARCHER RECORD
    @DeleteMapping("/researcher/{researcherId}")
    public Optional<Researcher> deleteResearcher(@PathVariable (value = "researcherId") Long researcherId){

        return researcherService.deleteResearcher(researcherId);
    }

//    ///////////////////////////////////////////////SECTIONS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
////THERE ARE MANY SECTIONS THAT BELONG TO ONE RESEARCHER WHERE THEY CONDUCT THEIR INDIVIDUAL PROJECTS
//    @PostMapping("/researcher/{researcherId}/section/")
//    public Section createResearcherSection(@PathVariable(value = "researcherId")Long researcherId,
//                                           @RequestBody Section sectionObj){
//        return researcherService.createResearcherSection(researcherId, sectionObj);
//    }
//
//    //get the list of sections for that one researcher
//    @GetMapping("/researcher/{researcherId}/section/")
//    public List<Section> getResearcherSectionList(@PathVariable(value = "researcherId")Long researcherId){
//        return researcherService.getResearcherSectionList(researcherId);
//    }
//
//    //delete sectionid with researcher id
//    @DeleteMapping("/researcher/{researcherId}/section/{sectionId}/")
//    public Optional<Section> deleteResearcherSection(@PathVariable(value="researcherId")Long researcherId,
//                                                        @PathVariable(value = "sectionId")Long sectionId){
//        return researcherService.deleteResearcherSection(researcherId, sectionId);
//    }
//
//    //GET SECTION LIST FOR A RESEARCHER
//    @GetMapping("/sections/")
//    public List<Section> getAllSections(){
//        return researcherService.getAllSections();
//    }
//

    ///////////////////////////////STUDENTS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    @GetMapping("/students/")
    public List<Student> getAllStudents(){
        return researcherService.getAllStudents();
    }

    //get all students under a researcher
    @GetMapping("/researcher/{researcherId}/students/")
    public List<Student> getAllResearcherStudents(@PathVariable(value = "researcherId")Long researcherId){
        return researcherService.getAllResearcherStudents(researcherId);
    }

    //CREATE STUDENT WITH RESEARCHERID
    @PostMapping("/researcher/{researcherId}/student/")
    public Student createResearcherStudent(@PathVariable(value = "researcherId")Long researcherId,
                                           @RequestBody Student studentObj){
        return researcherService.createResearcherStudent(researcherId, studentObj);
    }

    //UPDATE
    @PutMapping("/researcher/{researcherId}/student/{studentId}/")
    public Student updateResearcherStudent(@PathVariable (value = "researcherId")Long researcherId,
                                           @PathVariable(value = "studentId")Long studentId,
                                           @RequestBody Student studentObj){
        return researcherService.updateResearcherStudent(researcherId, studentId, studentObj);
    }

    //DELETE student ///
    @DeleteMapping("/researcher/{researcherId}/student/{studentId}/")
    public Optional<Student> deleteResearcherStudent(@PathVariable (value= "researcherId")Long researcherId,
                                                     @PathVariable(value = "studentId")Long studentId){
        return researcherService.deleteResearcherStudent(researcherId, studentId);
    }


    //student get all plants list

/////////////////////////////////// PLANTS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//researchid, sectionid, ==> create new plant

    @PostMapping("/researcher/{researcherId}/section/{sectionId}/plant/")
    public Plant createSectionPlant(@PathVariable(value = "researcherId")Long researcherId,
                                    @PathVariable(value = "sectionId")Long sectionId,
                                    @RequestBody Plant plantObj){
        return researcherService.createSectionPlant(researcherId, sectionId, plantObj);
    }

    //get plant list
    @GetMapping("/researcher/{researcherId}/section/{sectionId}/plant/")
    public List<Plant> getPlantList(@PathVariable(value = "researcherId")Long researcherId,
                                    @PathVariable(value = "sectionId")Long sectionId){
        return researcherService.getPlantList(researcherId, sectionId);
    }

//update on plant section

    @PutMapping("/researcher/{researcherId}/section/{sectionId}/plant/{plantId}/")
    public Plant updateSectionPlant(@PathVariable(value = "researcherId")Long researcherId,
                                    @PathVariable(value = "sectionId")Long sectionId,
                                    @PathVariable(value = "plantId")Long plantId,
                                    @RequestBody Plant plantObj){
        return researcherService.updateSectionPlant(researcherId, sectionId, plantId, plantObj);
    }


    //getallplants
    @GetMapping("/plants/")
    public List<Plant> getAllPlantList(){
        return researcherService.getAllPlantList();
    }



    //delete one plant section


    @DeleteMapping("/researcher/{researcherId}/section/{sectionId}/plant/{plantId}/")
    public Optional<Plant> deleteSectionPlant(@PathVariable(value = "researcherId")Long researcherId,
                                    @PathVariable(value = "sectionId")Long sectionId,
                                    @PathVariable(value = "plantId")Long plantId){
        return researcherService.deleteSectionPlant(researcherId, sectionId, plantId);
    }


    /////////////////////////////////students and plant\\\\\\\\\\\\\\\\\\\\\\\\\\


//    @PatchMapping("/student/{studentId}/plant/{plantId}/")
    @PutMapping("/plant/{plantId}/student/{studentId}/")
    public Plant putStudentPlant (@PathVariable(value = "studentId")Long studentId,
                                    @PathVariable(value = "plantId")Long plantId){
        return researcherService.putStudentPlant(studentId, plantId);
    }





}
