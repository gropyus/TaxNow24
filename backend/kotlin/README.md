# Backend - Kotlin

A kotlin spring boot service that can perform various tax calculations for the [frontend](../../frontend/).
It uses maven as a build tool.

## Prerequisites
* [java](https://yarnpkg.com/getting-started/install) (at least jdk version 17)

## Installing dependencies
```bash
./mvnw install
```

## Tests and checks
To run all tests:
```bash
./mvnw verify
```

## Run locally
To start the service locally at http://localhost:8080:
```bash
./mvnw spring-boot:run
```

To interact with it:
```bash
# interact - get the list of supported states
curl localhost:8080/states
# interact - define the tax amount per state
curl -X POST -H 'Content-Type: application/json' -d '0.08' localhost:8080/states/UT/tax
```

## Create production jar
To create a production jar locally run:
```bash
./mvnw clean package spring-boot:repackage
```
