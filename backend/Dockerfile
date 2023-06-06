FROM openjdk:17

WORKDIR /app/backend

COPY target/backend-0.0.1-SNAPSHOT.jar backend.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","/app/backend/backend.jar"]