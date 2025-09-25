FROM openjdk:21-jdk-slim

EXPOSE 9966

WORKDIR /app

COPY target/bookmark-service.jar app.jar

CMD ["java","-jar","app.jar"]