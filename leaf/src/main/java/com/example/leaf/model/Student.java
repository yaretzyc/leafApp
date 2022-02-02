package com.example.leaf.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String workType;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private Boolean isActive;

    //here map to the plant_id so that have list of plants

    @OneToMany(mappedBy= "student", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Plant> plantList;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "researcher_id")
    private Researcher researcher;



    //constructors

    public Student() {
    }

    public Student(Long id, String firstName, String lastName, String workType, String email, String phone, Boolean isActive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.workType = workType;
        this.email = email;
        this.phone = phone;
        this.isActive = isActive;
    }
    //getters and setters


    public Researcher getResearcher() {
        return researcher;
    }

    public void setResearcher(Researcher researcher) {
        this.researcher = researcher;
    }

    public List<Plant> getPlantList() {
        return plantList;
    }

    public void setPlantList(List<Plant> plantList) {
        this.plantList = plantList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

//    public void addStudentId(Plant plantIdd) {
////        return plantIdd.
//
//    }

//    public void addNewPlant(Plant plant) {
//        plantList.add(plant);
//    }


//    public boolean addStudentId(Plant plantIdd) {
////        return getPlantList().add(plantIdd);
//        return plantIdd.setStudent();

//    }

}
