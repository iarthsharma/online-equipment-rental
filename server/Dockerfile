# Build stage
FROM maven:3.8.6-openjdk-17 AS build
WORKDIR /workspace/server

# Copy only POM first to leverage Docker cache
COPY pom.xml .
# Download dependencies
RUN mvn dependency:go-offline

# Copy source code
COPY src src
# Build application
RUN mvn package -DskipTests

# Runtime stage
FROM openjdk:17.0.2-jdk-slim
WORKDIR /app

# Copy built JAR from build stage
COPY --from=build /workspace/server/target/*.jar app.jar

# Set environment variables
ENV SPRING_DATA_MONGODB_URI=${MONGO_URI}
ENV SERVER_PORT=8080
ENV TZ=UTC

# Expose application port
EXPOSE 8080

# Set health check
HEALTHCHECK --interval=30s --timeout=3s \
  CMD curl -f http://localhost:8080/actuator/health || exit 1

# Run application with security and memory optimizations
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]