package com.example.leaf.service;

import com.example.leaf.exceptions.InformationNotFoundException;
import com.example.leaf.model.Plant;
import com.example.leaf.model.Researcher;
import com.example.leaf.model.Section;
import com.example.leaf.model.Student;
import com.example.leaf.repository.PlantRepository;
import com.example.leaf.repository.ResearcherRepository;
import com.example.leaf.repository.SectionRepository;
import com.example.leaf.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantService {

    private PlantRepository plantRepository;

    @Autowired
    public void setPlantRepository(PlantRepository plantRepository){
        this.plantRepository = plantRepository;
    }


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

    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    /////////////////////////////////// PLANTS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//CREATE PLANT
    public Plant createSectionPlant(Long researcherId, Long sectionId, Plant plantObj){
        System.out.println("service calling createSectionPlant ==>");
        Optional<Researcher> researcher = researcherRepository.findById(researcherId);
        if(researcher.isPresent()){
            Optional<Section> section = sectionRepository.findById(sectionId);
            if(section.isPresent()){
                plantObj.setSection(section.get());
                return plantRepository.save(plantObj);
            }
            throw new InformationNotFoundException("Section with id " + sectionId + " not found");


        }else{
            throw new InformationNotFoundException("Researcher with id " + researcherId + " not found");
        }
    }


//GET PlantList with RESEARCHERID
    public List<Plant> getPlantList(Long researcherId, Long sectionId){
        System.out.println("service calling getPlantList ==>");
        Optional<Researcher> researcher = researcherRepository.findById(researcherId);
        if(researcher.isPresent()){
            Optional<Section> section = sectionRepository.findById(sectionId);
            if(section.isPresent()){
                return section.get().getPlantList();
            }
            throw new InformationNotFoundException("Section with id " + sectionId + " not found");
        }else{
            throw new InformationNotFoundException("Researcher with id " + researcherId + " not found");
        }
    }

//UPDATE the plant
    public Plant updateSectionPlant(Long researcherId, Long sectionId, Long plantId, Plant plantObj) {
        Optional<Researcher> researcher = researcherRepository.findById(researcherId);
        if (researcher.isPresent()) {
            Optional<Section> section = sectionRepository.findById(sectionId);
            if (section.isPresent()) {
                Optional<Plant> plant = plantRepository.findById(plantId);
                if (plant.isPresent()) {
                    for (Plant plant1 : section.get().getPlantList()) {
                        if (plant1.getId() == plantId) {
                            Plant plantUpdate = plantRepository.findById(plantId).get();
                            plantUpdate.setPlantName(plantObj.getPlantName());
                            plantUpdate.setIsHealthy(plantObj.getIsHealthy());
                            plantUpdate.setPlantType(plantObj.getPlantType());
                            plantUpdate.setNumberOfPots(plantObj.getNumberOfPots());
                            plantUpdate.setComments(plantObj.getComments());

                            return plantRepository.save(plantUpdate);
                        }
                    }
                }
                throw new InformationNotFoundException("plant with id " + plantId + " not found");
            }
            throw new InformationNotFoundException("section with id " + sectionId + " not found");
        }
        throw new InformationNotFoundException("researcher with id " + researcherId + " not found");

    }


//GET ALL PLANTS
    public List<Plant> getAllPlantList(){
        System.out.println("Service calling getAllPlantList ==> ");
        return plantRepository.findAll();
    }

//DELETE PLANT
    public Optional<Plant> deleteSectionPlant(Long researcherId, Long sectionId, Long plantId){
        System.out.println("service calling deleteSectionPlant ==>");
        Optional<Researcher> researcher = researcherRepository.findById(researcherId);
        if(researcher.isPresent()){
            Optional<Section> section = sectionRepository.findById(sectionId);
            if (section.isPresent()){
                for(Plant plant : section.get().getPlantList()){
                    if(plant.getId() == plantId) {
                        Plant plant1 = plantRepository.findById(plantId).get();
                        plantRepository.deleteById(plantId);
                        return Optional.of(plant1);
                    }
                }
                throw new InformationNotFoundException("plant with id " + plantId + " not found");
            }
            throw new InformationNotFoundException("Section with id " + sectionId + " not found");
        }
        throw new InformationNotFoundException("Researcher with id " + researcherId + " not found");

    }

//UPDATE THE PLANT STUDENT_ID COLUMN
    public Plant putStudentPlant(Long studentId, Long plantId){
        System.out.println("Service calling putStudentPlant ==> ");

        Optional<Student> studentIdd = studentRepository.findById(studentId);
        if(studentIdd.isPresent()){
            Optional<Plant> plantIdd = plantRepository.findById(plantId);
            if (plantIdd.isPresent()){
                plantIdd.get().setStudent(studentIdd.get());
                return plantRepository.save(plantIdd.get());
            }
            throw new InformationNotFoundException("plant with " + plantId + " not found");
        }
        throw  new InformationNotFoundException("student with id " + studentId + " not found");
    }



}
