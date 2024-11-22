FROM amazoncorretto:21

WORKDIR /app

COPY target/loan-1.0.0-SNAPSHOT.jar /app

EXPOSE 8083

CMD ["java", "-jar", "loan-1.0.0.jar"]