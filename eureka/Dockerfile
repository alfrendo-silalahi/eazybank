FROM amazoncorretto:21

WORKDIR /app

COPY target/eureka-1.0.0.jar /app

EXPOSE 9000

CMD ["java", "-jar", "eureka-1.0.0.jar"]