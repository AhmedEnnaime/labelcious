FROM maven:3.8.4 AS maven

LABEL MAINTAINER="ahmedennaime20@gmail.com"

WORKDIR /usr/src/app

COPY . .

RUN mvn package 

FROM openjdk:17

ARG JAR_FILE=backend.jar

WORKDIR /opt/app

COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/

ENTRYPOINT ["java","-jar","backend.jar"]