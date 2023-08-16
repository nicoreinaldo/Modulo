FROM openjdk:11
WORKDIR /app
EXPOSE 8080
COPY target/reinaldo-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]