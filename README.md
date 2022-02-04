# LEAF Database / SEI PROJECT 2

## INTRO

LEAF stands for Lake Environmental Aquatic Facility. It is a database created for individual research facilites. This idea came about from a previous work experience I had working as a research assistant for a team of reasearchers. There was no way to keep track of plants and everything was handwritten and transferred to an excel sheet. I though maybe it would be better to have a database with the details. LEAF would keep track of researcher's project and who they supervise and what plants students are managing. 

For this project there are four models: researchers, students, sections, and plants.
- __researchers model__: information on a researcher is stored including unique researcher_id, name, email, phone, and title.
- __students model__: information on student including unique student_id, name, workType (contract, etc), phone, isActive, researcher_id (primary researcher the student works with).
- __sections model__: information on they location (on the facility) and type (greenhouse, pond, outdoor, etc).
- **plants model**: Information on the plants in a specific section such as, plantType (terrestrial or aquatic), name, number of pots, isHealthy, comments, section_id, student_id.

#### CONTENTS
- [User Stories](#USER-STORIES)
- [Entity Relationship Diagrama](#ENTITY-RELATIONSHIP-DIAGRAMA-(ERD))
- [Dependencies](#DEPENDENCIES-POM.XML)
- [Endpoints](#ENDPOINTS)
- [Technologies](#TOOLS-AND-TECHNOLOGIES-USED)
- [Download Application](#Downloading-and-Running-Application)
- [Project Challenges](#CHALLENGES)
- [Future Improvements](#FUTURE-IMPROVEMENTS)


## USER STORIES
| | 
|:---|
|1.	As a user, I would like to view all sections that belong to a researcher.
|2.	As a user, I would like to view all plants that are in a section.
|3.	As a user, I would like to view what students are responsible for which plants.
|4.	As a user, I would like to view which student works under which researcher.
|5.	As a user, I would like to view which sections belong to a researcher.
|6.	As a user, I would like to delete records in my database for the student, researcher, plant, and section entities.
|7.	As a user, I would like to create a record in my database for the student, researcher, plant, and section entities.
|8. As a user, I would like to update my database for the student, researcher, plant, and section.

## ENTITY RELATIONSHIP DIAGRAMA (ERD)
### Lucidchart
<p align="center"><img alt="lucidchart_diagram" height="400" src="images/lucidchart.png"/>
   
### Visual Diagram (Intellij Idea)
<p align="center"><img alt="visual diagram from intellij idea" height="750" src="images/visualDiagram.png"/>


## DEPENDENCIES POM.XML
```

   <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

    </dependencies>



```
## ENDPOINTS

| Request Type | Enpoint | Functionality |
|--|--|--|
|RESEARCHERS TABLE|
| 1. POST | /api/researcher/ | create a new researcher |
|2. GET | /api/researchers/ | get ALL researchers |
|3. GET | /api/researcher/{researcherId}/ | get one researcher |
|4. PUT | /api/researcher/{researcherId}/ | update one researcher |
|5. DELETE | /api/researcher/{researcherId}/ | delete one researcher |
|SECTIONS TABLE|
|6. POST | /api/researcher/{researcherId}/section/ | delete one researcher |
|7. GET | /api/sections/ | get all sections |
|8. GET | /api/researcher/{researcherId}/sections/ | get all sections that belong to one researcher |
|9. DELETE | /api/researcher/{researcherId}/section/{sectionId}/ | delete a section |
|STUDENTS TABLE|
|10. GET |/api/students/ | get ALL students |
|11. GET | /api/researcher/{researcherId}/students/ | get students that belong to a researcher |
|12. POST | /api/researcher/{researcherId}/student/ | create a student for a researcher |
|13. PUT | /api/researcher/{researcherId}/student/{studentId}/ | update student |
|14. DELETE | /api/researcher/{researcherId}/student/{studentId}/ | delete a student |
| PLANTS TABLE |
|15. GET |/api/plants/ | get ALL plants |
|16. GET | /api/researcher/{researcherId}/section/{sectionId}/plant/ | get plants that are in a section |
|17. POST | /api/researcher/{researcherId}/section/{sectionId}/plant/ | create a plant in a section |
|18. PUT | /api/researcher/{researcherId}/section/{sectionId}/plant/{plantId}/ | update a plant |
|19. DELETE | /api/researcher/{researcherId}/section/{sectionId}/plant/{plantId}/ | delete a plant |
| PLANTS AND STUDENT TABLE |
|20. PUT | /api/plant/{plantId}/student/{studentId}/ | adding a studentId to the plantId |


## TOOLS AND TECHNOLOGIES USED
POSTMAN, JAVA ULTIMATE, POSTGRES DATABASE, GIT, JAVA SPRING BOOT, lucidCharo for erd diagram

|Name      |           | Purpose     |
| -------- | -------------- |--------------|
| Postman |  <p align="center"><img alt="postman_logo" height="100" src="images/postman.png"/> </p> | Build API Requests
| Intellij Idea 2021.3.1 |   <p align="center"><img alt="intellij_logo" height="100" src="images/intelliji.png"/>| Code Editor for Java Spring Boot Project
| PostgreSQL Database | <p align="center"><img alt="postgresql_logo" height="100" src="images/postgresql.png"/> | Database Mangement system
| GIT | <p align="center"><img alt="git_logo" height="100" src="images/git.png"/>| Version Control System
| Java Spring Boot | <p align="center"><img alt="java spring boot logo" height="100" src="images/javaspringboot.png"/>| Develop the project's web application using Spring Frameworks
| Lucidchart |  <p align="center"><img alt="lucidchart_logo" height="100" src="images/lucidchart_logo.png"/> | Create the Entity Relationship Diagram

## Downloading and Running Application
Usage
--------------
1. Clone repository
```
git clone https://github.com/yaretzyc/leafApp.git
```
2. Create database in PostgreSQL
call it 
```
leaf
```
3. Change Application-dev.properties under the resources package to your user details

```
spring.datasource.username= USERNAME HERE (default is postgres if you don't have a username)
spring.datasource.password= PASSWORD HERE
```
4. Create endpoints in an API Platform 
   
   This project used Postman
   
   ex. to create a researcher use the POST request and JSON with the researchers details to create a body
```
   http://localhost:8080/api/researcher/
```


## CHALLENGES
- One challenge that I faced was my plants table that had 2 foregin keys. The 2 foregin keys where student_id and section_id. The plants model has two Many to One entity relationship with the students and sections models. A student can have many plants that they are in charge of maintaing and a section has many types of plants. The issue came about after creating a plant record (row) the student_id was null. So, to change the null value and assign it an existing student_id number, I created a method in the PlantService called putStudentPlant where I retrieved both ids (plant and student) and then used setStudent() and added the studentId using get() method. Thus, I was able to change the null value to a student_id number.


## FUTURE IMPROVEMENTS
- Since this database can only be used at the local level e.g(one research plant facility) this can be changed to be used with individual researchers who want to manage their research profiles. So, change this to an application that uses JSON Web Tokens in Spring Security to power user authentication. In other words, a researcher can create a profile with email and password and login and navagite the API endpoints.


