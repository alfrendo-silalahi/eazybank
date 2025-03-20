FROM amazoncorretto:21

WORKDIR /app

COPY target/config-1.0.0.jar /app

EXPOSE 8084

CMD ["java", "-jar", "config-1.0.0.jar"]