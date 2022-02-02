# LEAF Database/ERD

## INTRO
LEAF stands for Lake Environmental Aquatic Facility. It is a database created for individual plant research facilites.

## ENTITY RELATIONSHIP DIAGRAMA (ERD):

## ENDPOINTS

| Request Type | Enpoint | Functionality |
|--|--|--|
  | POST | /api/researcher/ | create a new researcher |
| GET | /api/researcher/{researcherId}/ | get one researcher |
| PUT | /api/researcher/{researcherId}/ | update one researcher |
| DELETE | /api/researcher/{researcherId}/ | delete one researcher |



## TOOLS AND TECHNOLOGIES USED
POSTMAN, JAVA ULTIMATE, POSTGRES DATABASE, GIT, JAVA SPRING BOOT



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



## Challenges
- The plants table 2 foregin keys
