FROM maven:3.8.4 AS maven

LABEL MAINTAINER="ahmedennaime20@gmail.com"

WORKDIR /usr/src/app

COPY . .

RUN mvn package 

FROM openjdk:17

ARG JAR_FILE=backend-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/backend.jar

ENTRYPOINT ["java","-jar","/opt/app/backend.jar"]

