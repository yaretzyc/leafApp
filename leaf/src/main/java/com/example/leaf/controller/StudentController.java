package com.example.leaf.controller;

import com.example.leaf.model.Student;
import com.example.leaf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class StudentController {

    @Autowired
    public StudentService studentService;

    ///////////////////////////////STUDENTS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//GET ALL STUDENTS
    @GetMapping("/students/")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

//GET all students under a researcher
    @GetMapping("/researcher/{researcherId}/students/")
    public List<Student> getAllResearcherStudents(@PathVariable(value = "researcherId")Long researcherId){
        return studentService.getAllResearcherStudents(researcherId);
    }

//CREATE a student
    @PostMapping("/researcher/{researcherId}/student/")
    public Student createResearcherStudent(@PathVariable(value = "researcherId")Long researcherId,
                                           @RequestBody Student studentObj){
        return studentService.createResearcherStudent(researcherId, studentObj);
    }

//UPDATE a student
    @PutMapping("/researcher/{researcherId}/student/{studentId}/")
    public Student updateResearcherStudent(@PathVariable (value = "researcherId")Long researcherId,
                                           @PathVariable(value = "studentId")Long studentId,
                                           @RequestBody Student studentObj){
        return studentService.updateResearcherStudent(researcherId, studentId, studentObj);
    }

//DELETE a student
    @DeleteMapping("/researcher/{researcherId}/student/{studentId}/")
    public Optional<Student> deleteResearcherStudent(@PathVariable (value= "researcherId")Long researcherId,
                                                     @PathVariable(value = "studentId")Long studentId){
        return studentService.deleteResearcherStudent(researcherId, studentId);
    }


}
