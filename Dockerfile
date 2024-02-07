##FROM openjdk:8
##ADD target/employee-service-0.0.1-SNAPSHOT.jar app.jar
##ENTRYPOINT ["java", "-jar", "/app.jar"]
#
# #Use an official OpenJDK 17 runtime as a parent image
#FROM openjdk:17-jdk-slim
#
## Set the working directory to /app
#WORKDIR /app
#
## Copy the JAR file into the container at /app
#COPY target/employee-service-0.0.1-SNAPSHOT.jar /app/app.jar
#
## Expose port 8080
#EXPOSE 8080
#
## Command to run the application
#CMD ["java", "-jar", "app.jar"]
#
#
#FROM adoptopenjdk:11-jre-hotspot
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java", "-jar", "/app.jar"]
