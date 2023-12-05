FROM openjdk:11-jdk
ARG JAR_PATH=./build/libs
ARG JAR_FILE=cqbook-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "app.jar"]