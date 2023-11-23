# Fetching latest version of Java
FROM openjdk:18

# Setting up work directory
WORKDIR /app

# Copy the jar file into our app
COPY ./target/Product-Service-0.0.1-SNAPSHOT.jar /app

# Exposing port 1004
EXPOSE 1004

# Starting the application
CMD ["java", "-jar", "Product-Service-0.0.1-SNAPSHOT.jar"]