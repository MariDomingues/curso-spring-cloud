from openjdk:12-alpine
COPY ./loja/target/loja-0.0.1-SNAPSHOT.jar /app/loja-0.0.1-SNAPSHOT.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "loja-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080