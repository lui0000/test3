FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=build/libs/testing-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
