# Fetching latest version of Java
FROM openjdk:18

# Setting up work directory
WORKDIR /app

# Copy the jar file into our app
COPY ./target/Loginservice-0.0.1-SNAPSHOT.jar /app

# Exposing port 1003
EXPOSE 1003

# Starting the application
CMD ["java", "-jar", "Loginservice-0.0.1-SNAPSHOT.jar"]