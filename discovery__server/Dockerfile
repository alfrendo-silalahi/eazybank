FROM amazoncorretto:21

WORKDIR /app

COPY target/discovery__server-1.0.0.jar /app

EXPOSE 9000

CMD ["java", "-jar", "discovery__server-1.0.0.jar"]