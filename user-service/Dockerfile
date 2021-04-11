FROM openjdk:latest
ADD target/somegeneratedjarfile.jar app.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "app.jar"]