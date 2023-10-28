FROM amazoncorretto:11

WORKDIR /app

COPY . .

CMD ["java", "-jar", "target/transacao-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080
