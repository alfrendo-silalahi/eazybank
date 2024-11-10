FROM eclipse-temurin:17.0.12_7-jre-ubi9-minimal

WORKDIR /app

COPY target/cards-0.0.1-SNAPSHOT.jar /app

EXPOSE 8082

CMD ["java", "-jar", "cards-0.0.1-SNAPSHOT.jar"]