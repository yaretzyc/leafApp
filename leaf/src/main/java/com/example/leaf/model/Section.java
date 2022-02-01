package com.example.leaf.model;

import javax.persistence.*;

@Entity
@Table(name = "sections")
public class Section {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String type;

    @Column
    private String location;


    //map to the researcher to have the id here
    // one researcher is in charge of one or many sections


    //constructors
    public Section() {
    }

    public Section(Long id, String type, String location) {
        Id = id;
        this.type = type;
        this.location = location;
    }


    //getters and setters


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
