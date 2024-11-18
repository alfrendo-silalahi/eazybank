FROM amazoncorretto:17

WORKDIR /app

COPY target/config-server-0.0.1-SNAPSHOT.jar /app

EXPOSE 8084

CMD ["java", "-jar", "config-server-0.0.1-SNAPSHOT.jar"]