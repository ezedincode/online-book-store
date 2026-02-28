# Use Java 17 LTS base image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the Spring Boot JAR into the container as app.jar
COPY target/online-book-store-0.0.1-SNAPSHOT.jar ./app.jar

# Expose port 8080 (Spring Boot default)
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java","-jar","/app.jar"]