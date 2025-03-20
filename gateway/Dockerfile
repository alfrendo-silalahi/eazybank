FROM amazoncorretto:21

WORKDIR /app

COPY target/gateway-1.0.0.jar /app

EXPOSE 9000

CMD ["java", "-jar", "gateway-1.0.0.jar"]