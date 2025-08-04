FROM amazoncorretto:21

WORKDIR /app

COPY target/config__server-1.0.0.jar /app

EXPOSE 8084

CMD ["java", "-jar", "config__server-1.0.0.jar"]