package com.example.leaf.service;

import com.example.leaf.exceptions.InformationNotFoundException;
import com.example.leaf.model.Researcher;
import com.example.leaf.model.Student;
import com.example.leaf.repository.ResearcherRepository;
import com.example.leaf.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private ResearcherRepository researcherRepository;

    @Autowired
    public void setResearcherRepository(ResearcherRepository researcherRepository){
        this.researcherRepository = researcherRepository;
    }

    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    ///////////////////////////////STUDENTS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//GET ALL STUDENTS
    public List<Student> getAllStudents(){
        System.out.println("Service calling getAllStudents ==> ");
        return studentRepository.findAll();
    }

//GET all students under a researcher
    public List<Student> getAllResearcherStudents(Long researcherId){
        System.out.println("service calling getAllResearcherStudents ==>");
        Optional<Researcher> researcher = researcherRepository.findById(researcherId);
        if(researcher.isPresent()){
            return researcher.get().getStudentList();

        }else{
            throw new InformationNotFoundException("researcher with id " + researcherId + "not found");
        }
    }

//CREATE a student
    public Student createResearcherStudent(Long researcherId, Student studentObj){
        System.out.println("service calling createResearcherStudent ==>");
        Optional<Researcher> researcher = researcherRepository.findById(researcherId);
        if(researcher.isPresent()){
            studentObj.setResearcher(researcher.get());
            return studentRepository.save(studentObj);
        }else{
            throw new InformationNotFoundException("Researcher with id " + researcherId + " not found");
        }
    }

//UPDATE a student
    public Student updateResearcherStudent(Long researcherId, Long studentId, Student studentObj){
        System.out.println("service calling updateResearcherStudent ==>");
        Optional<Researcher> researcher = researcherRepository.findById(researcherId);
        if(researcher.isPresent()){
            for(Student student : researcher.get().getStudentList() ){
                if(student.getId() == studentId){
                    Student studentUpdate = studentRepository.findById(studentId).get();
                    studentUpdate.setFirstName(studentObj.getFirstName());
                    studentUpdate.setLastName(studentObj.getLastName());
                    studentUpdate.setEmail(studentObj.getEmail());
                    studentUpdate.setPhone(studentObj.getPhone());
                    studentUpdate.setIsActive(studentObj.getIsActive());
                    studentUpdate.setWorkType(studentObj.getWorkType());

                    return studentRepository.save(studentUpdate);
                }
                throw new InformationNotFoundException("Student with id " + studentId + " not found");
            }
        }
        throw new InformationNotFoundException("Researcher with id " + researcherId + " not found");
    }


//DELETE a student
    public Optional<Student> deleteResearcherStudent(Long researcherId, Long studentId){
        System.out.println("service calling deleteResearcherStudent ==>");
        Optional<Researcher> researcher = researcherRepository.findById(researcherId);
        if(researcher.isPresent()){
            for(Student student : researcher.get().getStudentList()){
                if(student.getId() == studentId){
                    Student student1 = studentRepository.findById(studentId).get();
                    studentRepository.deleteById(studentId);
                    return Optional.of(student1);
                }
                throw new InformationNotFoundException("Student with id " + studentId + " not found");
            }
        }
        throw new InformationNotFoundException("Researcher with id " + researcherId + " not found");

    }



}
