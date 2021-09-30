# Build stage
FROM maven:3.3.3 #-jdk:8-jdk-alpine AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn clean install



