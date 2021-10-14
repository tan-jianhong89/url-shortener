FROM openjdk:8-jdk-alpine

# Refer to Maven build -> finalName
ARG JAR_FILE=target/url-shortener.jar

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=gcp", "-jar","app.jar"]