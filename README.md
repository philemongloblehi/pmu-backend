![PMU](https://upload.wikimedia.org/wikipedia/fr/thumb/a/aa/PMU.svg/1200px-PMU.svg.png)

Build Restful CRUD API for a simple Student application using Spring Boot, Mysql, JPA, Hibernate and Kafka.

## Requirements

1. Java - 17.x

2. Maven - 3.x.x

3. Mysql - 5.x.x

4. Spring Boot - 3.x.x

5. Kafka

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/philemongloblehi/pmu-backend.git
```

**2. Create Mysql database**
```bash
create database pmu_db
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Build and run the app using maven**

```bash
mvn package
java -jar target/backend-pmu-0.0.1-SNAPSHOT.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD for Course model.
    
    POST /api/courses
    
    GET /api/courses

    GET /api/courses/{id}

    PUT /api/courses/{id}
    
    DELETE /api/courses/{id}

The app defines following CRUD for Partant model.

    POST /api/partants/courses/id

You can test them using postman or any other rest client.
