FROM openjdk:8-jdk-alpine
ENV server.port=8081

COPY ./target/core-service-0.0.1-SNAPSHOT.jar app.jar 
CMD ["java", "-jar","/app.jar"]

