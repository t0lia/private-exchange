# build backend
FROM maven:3.9.0-amazoncorretto-17 AS MAVEN_TOOL_CHAIN

COPY ./ /tmp/

WORKDIR /tmp/

RUN mvn clean package

# production
FROM amazoncorretto:17

EXPOSE 8080

RUN mkdir /app

COPY --from=MAVEN_TOOL_CHAIN /tmp/target/*.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar", "-Dspring.profiles.active=local","/app.jar"]
