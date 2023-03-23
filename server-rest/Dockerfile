#FROM eclipse-temurin:17-jdk-jammy
FROM openjdk:11 as base
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN apt-get update && apt-get install -y dos2unix
RUN dos2unix ./mvnw
RUN apt-get remove -y dos2unix
RUN ./mvnw dependency:resolve
COPY src src

FROM base as development
#CMD pwd; ls $(pwd) -al
CMD ["./mvnw", "spring-boot:run", "-Dspring-boot.run.jvmArguments='-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000'"]

FROM base as build
RUN ["./mvnw", "package"]

FROM openjdk:11 as production
EXPOSE 8080
COPY --from=buil /app/target/server-rest-*.jar ./server-rest.jar
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "./server-rest.jar"]