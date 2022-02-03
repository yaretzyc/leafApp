package com.example.leaf.controller;

import com.example.leaf.model.Plant;
import com.example.leaf.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class PlantController {

    @Autowired
    public PlantService plantService;

    /////////////////////////////////// PLANTS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//researchid, sectionid, ==> create new plant

    @PostMapping("/researcher/{researcherId}/section/{sectionId}/plant/")
    public Plant createSectionPlant(@PathVariable(value = "researcherId")Long researcherId,
                                    @PathVariable(value = "sectionId")Long sectionId,
                                    @RequestBody Plant plantObj){
        return plantService.createSectionPlant(researcherId, sectionId, plantObj);
    }

    //get plant list
    @GetMapping("/researcher/{researcherId}/section/{sectionId}/plant/")
    public List<Plant> getPlantList(@PathVariable(value = "researcherId")Long researcherId,
                                    @PathVariable(value = "sectionId")Long sectionId){
        return plantService.getPlantList(researcherId, sectionId);
    }

//update on plant section

    @PutMapping("/researcher/{researcherId}/section/{sectionId}/plant/{plantId}/")
    public Plant updateSectionPlant(@PathVariable(value = "researcherId")Long researcherId,
                                    @PathVariable(value = "sectionId")Long sectionId,
                                    @PathVariable(value = "plantId")Long plantId,
                                    @RequestBody Plant plantObj){
        return plantService.updateSectionPlant(researcherId, sectionId, plantId, plantObj);
    }


    //getallplants
    @GetMapping("/plants/")
    public List<Plant> getAllPlantList(){
        return plantService.getAllPlantList();
    }



    //delete one plant section


    @DeleteMapping("/researcher/{researcherId}/section/{sectionId}/plant/{plantId}/")
    public Optional<Plant> deleteSectionPlant(@PathVariable(value = "researcherId")Long researcherId,
                                              @PathVariable(value = "sectionId")Long sectionId,
                                              @PathVariable(value = "plantId")Long plantId){
        return plantService.deleteSectionPlant(researcherId, sectionId, plantId);
    }




    //    @PatchMapping("/student/{studentId}/plant/{plantId}/")
    @PutMapping("/plant/{plantId}/student/{studentId}/")
    public Plant putStudentPlant (@PathVariable(value = "studentId")Long studentId,
                                  @PathVariable(value = "plantId")Long plantId){
        return plantService.putStudentPlant(studentId, plantId);
    }






}
