# Etapa 1: Construcción (Maven)
FROM maven:3.9.6-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución (Java)
FROM eclipse-temurin:17-jdk-jammy
COPY --from=build /target/spotify-api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]