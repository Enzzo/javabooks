FROM openjdk:17-jdk-slim
LABEL maintainer="Sergey Vasilev <vasilevnogliki@yandex.ru>"
WORKDIR /app
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]