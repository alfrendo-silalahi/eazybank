package dev.alfrendosilalahi.eazybank.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator eazybankRoutesConfig(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/eazybank/account/**")
                        .filters(f -> f
                                .rewritePath("/eazybank/account/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
                        )
                        .uri("lb://ACCOUNT"))
                .route(p -> p
                        .path("/eazybank/card/**")
                        .filters(f -> f.rewritePath("/eazybank/card/(?<segment>.*)", "/${segment}"))
                        .uri("lb://CARD"))
                .route(p -> p
                        .path("/eazybank/loan/**")
                        .filters(f -> f.rewritePath("/eazybank/loan/(?<segment>.*)", "/${segment}"))
                        .uri("lb://LOAN"))
                .build();
    }

}
