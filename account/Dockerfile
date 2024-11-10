FROM eclipse-temurin:17.0.12_7-jre-ubi9-minimal

WORKDIR /app

COPY target/account-0.0.1-SNAPSHOT.jar /app

EXPOSE 8081

CMD ["java", "-jar", "account-0.0.1-SNAPSHOT.jar"]