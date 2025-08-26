FROM gradle:jdk21-jammy AS build

WORKDIR /app

COPY . .

RUN chmod +x gradlew && ./gradlew build --no-daemon

FROM eclipse-temurin:21-jre-jammy

# Set the working directory
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]