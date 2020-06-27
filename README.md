# Project Title

It is a take-home coding challenge.

## Getting Started

There are 3 ways to run this Spring Boot application.

* [Run in a local IDE](#run-in-a-local-ide)
* [Run as an executable Jar file](#run-as-an-executable-jar-file)
* [Run in a Docker container](#run-in-a-docker-container)

### General Info

* A `Swagger` page is configured to visually test the endpoints after the application is up and running. See [Running the test](#running-the-test) for more details.
* Detailed Javadoc is added to `ViaHomeworkService.java` for my thought process of the solution.
* Junit tests with `Mockito` are available to verify the correctness of the solution. 

### Prerequisites

* Install JDK 8.
* Install Apache Maven (i.e. 3.6.3).
* Install the local IDE (i.e. IntelliJ). ***Note that Lombok is used to reduce boilerplate codes, and you need to install the lombok plugin in your IDE.***
* Install Docker (i.e. Desktop version or Docker Toolbox for Windows 10 Home)

### Run in a local IDE

* Clone the project from [GitHub](https://github.com/terrydship/via-homework) to your local IDE (i.e. IntelliJ)
* Download and resolve all the maven dependencies.
* Run `HomeworkApplication.java` to start the application, alternatively run the following command in the terminal.
```
mvn spring-boot:run
```
* Run `ViaHomeworkServiceTest.java` and `ViaHomeworkControllerTest.java` for the test cases.

### Run as an executable Jar file

* Run the following command in the IDE terminal or a command window, assuming you are under the project root folder.
```
mvn clean package
java -jar target/homework-0.0.1.jar
```

### Run in a Docker container

* **Important:** Depending on if you are using `Docker Desktop` version or `Docker Toolbox`, the IP address to access the 
application endpoints could be different, you may verify with the following command
```
docker-machine ip
```
* Run the following command to generate the .jar file for the application.
```
mvn clean package
```
* Build the docker image with the following command, where `terrydship/via-homework` is a custom tag name.
```
docker build -t terrydship/via-homework .
```
* Run the docker container from the image with the following command, where `terrydship/via-homework` is the tag name I previously created.
```
docker run -p 8080:8080 terrydship/via-homework
```
* Some other useful command lines when running the application in docker
```
docker container ls
docker stop {CONTAINER ID}

docker image ls
docker image rm {IMAGE ID} -f
```

### Running the test

Once the application is up and running, you may do the following:

* Use the following URL to access the `Swagger` page to visually test the solutions.
i.e. `http://localhost:8080/homework/api/swagger-ui.html`. Expand the `Controller` section
on the page to test the endpoints.
```
http://{host}:{port}/homework/api/swagger-ui.html
```

* Use the following URL to check if two strings are anagrams of each other.
i.e. `http://localhost:8080/homework/api/anagrams/cinema/iceman`
```
http://{host}:{port}/homework/api/anagrams/{string1}/{string2}
```

* Use the following URL to check if two strings are anagrams of each other.
i.e. `http://localhost:8080/homework/api/anagrams/abcd`
```
http://{host}:{port}/homework/api/anagrams/{string1}
```
A `RuntimeException` with a 400 http status code will be thrown when input string is not alpha-numerical.
