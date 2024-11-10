FROM eclipse-temurin:17.0.12_7-jre-ubi9-minimal

WORKDIR /app

COPY target/loans-0.0.1-SNAPSHOT.jar /app

EXPOSE 8083

CMD ["java", "-jar", "loans-0.0.1-SNAPSHOT.jar"]