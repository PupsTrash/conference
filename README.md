# Conference test task
***
### Technologies used: Spring Boot, Spring Data Jpa (in memory db H2, autofill), Spring Security, Spring Mvc, Gradle, jUnit, Docker, Flyway, Swagger
***
## The task
Create a web application "Conference".

The user must be able to register for the conference and view the talks.
Presenters can create talks and choose time to talk in rooms.
It is necessary to provide that the reports do not overlap each 
other in time in the same room, i.e. there cannot be 2 lectures in the 
room at the same time. The schedule must also be accessible via the REST API.

### Roles:
Administrator, Speaker, Listener

### Pages:
- main - contains the schedule of talks, broken down by room.
- registration - only listeners can register. You do not need to confirm your registration.
- list of reports - available to the speaker. displays a list of reports for a presenter with CRUD capabilities. Also on the page it is necessary to implement the choice of the time of the report in the schedule.
- list of users - available only to an administrator with CRUD capabilities. 
_Only the administrator can make presenters out of users._
  
- You don't have to create a CRUD page for ROOM, just fill it in at the start of the application


> Postman collection in main package
conference.postman_collection.json


### HOW TO BUILD 
run command via cmd/terminal 

`docker-compose build`



### HOW TO RUN
run command via cmd/terminal

`docker-compose up`
