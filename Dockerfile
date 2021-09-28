FROM openjdk:8-jdk-alpine
ENV server.port=8081
ADD ./target/core-service.jar app.jar
CMD ["java", "-jar","/app.jar"]
