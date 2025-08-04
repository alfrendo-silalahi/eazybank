FROM amazoncorretto:21

WORKDIR /app

COPY target/api__gateway-1.0.0.jar /app

EXPOSE 9000

CMD ["java", "-jar", "api__gateway-1.0.0.jar"]