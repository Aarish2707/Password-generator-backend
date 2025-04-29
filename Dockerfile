# Use a lightweight Java image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the JAR file
COPY target/PwdGenerator-0.0.1-SNAPSHOT.jar app.jar

# Expose app port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
