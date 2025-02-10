# Use JDK 22 as the base image
FROM openjdk:22-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/*.jar app.jar

# Expose the port the application runs on
EXPOSE 8090

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
