FROM maven:3.9.4-amazoncorretto-21 AS build
WORKDIR /app
COPY pom.xml ./
COPY src ./src
RUN mvn clean package -DskipTests

# Imagen final
FROM amazoncorretto:21.0.4-alpine3.18
WORKDIR /app


COPY --from=build /app/target/pagos-0.0.1-SNAPSHOT.jar app.jar
# COPY .env .env

EXPOSE 8010

ENTRYPOINT ["java", "-jar", "app.jar"]