FROM openjdk:17-alpine
COPY ./build/libs/kusithm_part_study-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
