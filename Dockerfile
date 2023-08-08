    FROM openjdk:8-alpine

MAINTAINER boys.mtv@gmail.com

COPY build/libs/movie-based-0.0.1-SNAPSHOT.jar /app/application.jar

ENTRYPOINT ["java", "-jar", "/app/application.jar"]