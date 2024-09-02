FROM maven:3.8.4-jdk-11 as build
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11
WORKDIR /app
COPY --from=build ./build/target/*.jar ./application.jar
COPY ./src/main/resources/licitacoes.json ./licitacoes.json
EXPOSE 8080

ENV SPRING_PROFILES_ACTIVE=prod

ENTRYPOINT java -jar application.jar