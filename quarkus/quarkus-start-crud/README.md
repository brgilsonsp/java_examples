# quarkus-start-crud Project

Esse projeto utiliza Quarkus, o framkework Java Supersonic e Subatomic.
Esse projeto comunica com um banco de dados MySQL



## Dependências lib

Documentação Swagger: quarkus-smallrye-openapi
ORM, implementação do Hibernate: quarkus-hibernate-orm-panache
Driver para conexão com o BD MySQL: quarkus-jdbc-mysql
Bind JSON to POJO: quarkus-jaxb
CDI: quarkus-arc
API REST: quarkus-resteasy
Unit Test: quarkus-junit5
Integration Test: rest-assured

## Depdência infra-estrutura

MySQL:
    Utilize o Docker para subir a imagem do MySQL 8
        docker run --network host -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=teste -d --rm mysql:8.0.19


## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-start-crud-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
