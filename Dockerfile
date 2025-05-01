FROM eclipse-temurin:21 AS builder

WORKDIR /app

COPY gradlew settings.gradle ./
COPY gradle/ gradle/
COPY app/ app/

RUN chmod +x gradlew

RUN ./gradlew :app:build -x test

FROM eclipse-temurin:21 AS final

WORKDIR /app

EXPOSE 8080

COPY --from=builder /app/app/build/libs/app.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
