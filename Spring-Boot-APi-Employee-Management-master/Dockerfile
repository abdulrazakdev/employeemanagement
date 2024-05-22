FROM openjdk:17-jdk-slim  # Base image with JDK

WORKDIR /app

COPY pom.xml ./
RUN mvn clean package -DskipTests

COPY target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
