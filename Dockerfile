# Use an official JDK runtime as base image
FROM maven:3.9.9-eclipse-temurin-21 as builder
WORKDIR /app

COPY . .

RUN mvn clean install -DskipTests


FROM eclipse-temurin:21-jdk

# Set working directory in container
WORKDIR /app

# Copy the JAR file into the container
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
