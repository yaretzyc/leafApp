# LEAF Database/ERD

## INTRO
LEAF stands for Lake Environmental Aquatic Facility. It is a database created for individual plant research facilites.

## ENTITY RELATIONSHIP DIAGRAMA (ERD):

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
