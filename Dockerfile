# -----------------------------
# Stage 1: Build the application
# -----------------------------
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory inside container
WORKDIR /app

# Copy pom.xml and download dependencies (cached for faster builds)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# -----------------------------
# Stage 2: Run the application
# -----------------------------
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/spring-practice-application-0.0.1.jar app.jar

# Expose application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
