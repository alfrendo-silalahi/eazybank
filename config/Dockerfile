FROM amazoncorretto:21

WORKDIR /app

COPY target/config-server-1.0.0.jar /app

EXPOSE 8084

CMD ["java", "-jar", "config-server-0.0.1-SNAPSHOT.jar"]