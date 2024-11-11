# Use the official Eclipse Temurin base image for JDK 21 on Alpine
FROM eclipse-temurin:21-jdk-alpine

# Specify a build argument with the default JAR file location
ARG JAR_FILE=target/*.jar

# Copy the JAR file into the container as app.jar
COPY ${JAR_FILE} /app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]