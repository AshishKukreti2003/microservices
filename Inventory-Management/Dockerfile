# Fetching latest version of Java
FROM openjdk:18

# Setting up work directory
WORKDIR /app

# Copy the jar file into our app
COPY ./target/Inventory-Management-0.0.1-SNAPSHOT.jar /app

# Exposing port 1005
EXPOSE 1005

# Starting the application
CMD ["java", "-jar", "Inventory-Management-0.0.1-SNAPSHOT.jar"]