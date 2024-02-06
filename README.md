# spring-boot-basic-demo-1

### Basic setup of RESTful API using Springboot 3, using Docker to run mysql database.  

Initial purpose of this was to support the Multiverse SWE2.0 program, specifically as a support for the Backend Module/Workshop.  

### Branch `jwt`:
Adds Authorization using a JSON Web Token.  

Project currently contains Repository, Service, DTO, and Controller for Snippet resource. Additionally, branch includes Repository, Service, and Controller for basic auth - User model with login and register Dtos.  Lastly branch adds use of JWT for authentication.  
Controller currently has the following methods/mappings:
   - `getAllSnippets`- which is protected and requires auth with JWT.
   - `getSnippetById`- which is protected and requires auth with JWT.
   - `createSnippet` - which is protected and requires auth with JWT.  
   - `login` - returns JWT on successful login with EITHER username OR email, and password.
   - `register`

### Order of branch progression - descending from most recent to oldest (excluding `main`):
   - `jwt`
   - `basic-auth`
   - `add-exception`
   - `snippet`
   - `mysql`
   - `start`

### To run:

   - Make sure your Docker container with your database is running (see below)

   - From the command line, navigate to root directory of the project, and enter the following:
```
./mvnw spring-boot:run
```
   - If you have maven locally installed, then run instead:
```
mvn spring-boot:run
```

Alternatively, use Intellij IDEA and simply run the application from within the IDE.



### To run `mysql` database:
   - Install and run Docker Desktop
     
   - In the root directory of the project, run the following command from the terminal:
```
docker compose up -d
```

This will set up your container automatically to run on port 3306 using the configuation of the `docker-compose.yml` file.

   - To stop the container, but not remove it, enter into the terminal:
```
docker compose stop
```
   - To re-start a stopped container, enter into the terminal:
```
docker compose start
```
   - To stop and remove a container, which will also remove any stored data(volumes) enter into the terminal:
```
docker compose down
```
