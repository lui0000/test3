﻿# Instructions

## 1. Install PostgreSQL and restore the database:
If PostgreSQL is not installed, please install it as it is required to run the application.  
In the root of the project, you will find the file `cities_dump.backup`.  
Download it, then log into PostgreSQL.  
Create a database named `cities`.  
After creating the database, perform the restore using the following command:

```bash
pg_restore -d cities cities_dump.backup
```

## 2. Database configuration
In the `src/main/resources` directory, create the file `application.properties`.  
In this file, add the following:

```properties
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/cities
spring.datasource.username=
spring.datasource.password=

spring.jpa.properties.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.show_sql=true

spring.mvc.hiddenmethod.filter.enabled=true
```

Set your own values for the following fields:

```properties
spring.datasource.username=
spring.datasource.password=
```

After that, go to `user-docker-compose.yaml` and fill in the following fields with your PostgreSQL username and password:

```yaml
SPRING_DATASOURCE_USERNAME:
SPRING_DATASOURCE_PASSWORD:
```

## 3. Running the container
Congratulations, you're almost there!  
To start the container, run the following command:

```bash
docker-compose -f users-docker-compose.yml up --build
```

To stop the containers started by Docker Compose, you can use the following command:

```bash
docker-compose -f users-docker-compose.yml down
```
