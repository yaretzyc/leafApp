package com.example.leaf.model;

import javax.persistence.*;

@Entity
@Table(name = "plants")
public class plant {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String plantType;

    @Column
    private String plantName;

    @Column
    private Boolean isHealthy;

    @Column
    private Integer numberOfPots;

    @Column
    private String comments;

//map to the section_id bc one section can have many types of plants


    //constructors
    public plant() {
    }

    public plant(Long id, String plantType, String plantName, Boolean isHealthy, Integer numberOfPots, String comments) {
        this.id = id;
        this.plantType = plantType;
        this.plantName = plantName;
        this.isHealthy = isHealthy;
        this.numberOfPots = numberOfPots;
        this.comments = comments;
    }


    //getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlantType() {
        return plantType;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public Boolean getIsHealthy() {
        return isHealthy;
    }

    public void setIsHealthy(Boolean isHealthy) {
        this.isHealthy = isHealthy;
    }

    public Integer getNumberOfPots() {
        return numberOfPots;
    }

    public void setNumberOfPots(Integer numberOfPots) {
        this.numberOfPots = numberOfPots;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
