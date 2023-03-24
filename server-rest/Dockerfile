#FROM eclipse-temurin:17-jdk-jammy
FROM openjdk:11 as base
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN apt-get update && apt-get install -y dos2unix
RUN dos2unix ./mvnw
RUN apt-get remove -y dos2unix
RUN ./mvnw dependency:resolve
# COPY src src

FROM base as development
EXPOSE 8080
EXPOSE 5005
COPY src src
ENTRYPOINT ["./mvnw", "spring-boot:run"]
CMD ["-Dspring-boot.run.jvmArguments='-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005'"]

FROM base as build
ADD src src
RUN ["./mvnw", "package"]

FROM openjdk:11 as production
EXPOSE 8080
COPY --from=build /app/target/server-rest-*.jar ./server-rest.jar
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "./server-rest.jar"]