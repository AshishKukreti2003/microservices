# Fetching latest version of Java
FROM openjdk:18

# Setting up work directory
WORKDIR /app

# Copy the jar file into our app
COPY ./target/Discovery-Service-0.0.1-SNAPSHOT.jar /app

# Exposing port 8176
EXPOSE 8176

# Starting the application
CMD ["java", "-jar", "Discovery-Service-0.0.1-SNAPSHOT.jar"]