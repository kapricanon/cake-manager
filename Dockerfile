FROM maven:3.8-jdk-11-slim AS build
RUN mkdir -p workspace
WORKDIR workspace

COPY pom.xml /workspace
COPY src /workspace/src
COPY frontend /workspace/frontend

RUN mvn -f pom.xml clean install -DskipTests=true


# pull official base image
FROM node:13.12.0-alpine
# install app dependencies
COPY package.json ./
COPY package-lock.json ./
RUN npm install --silent
RUN npm install react-scripts@3.4.1 -g --silent

FROM openjdk:11.0.4-jre
COPY --from=build /workspace/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]