package com.sky.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class GatewayserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayserverApplication.class, args);
    }

    @Bean
    public RouteLocator configureRoutes(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes().route(route->route
                .path("/skyorg/accounts/**")
                .filters(f->f.rewritePath("/skyorg/accounts/(?<segment>.*)","/${segment}")
                        .addRequestHeader("X-Response-Time", LocalDateTime.now().toString())
                        .circuitBreaker(config -> config.setName("accountscircuitbreaker")
                                .setFallbackUri("forward:/accountscustomercare")))
                .uri("lb://ACCOUNTS"))
                .route(route->route.path("/skyorg/loans/**")
                        .filters(f->f.rewritePath("/skyorg/loans/(?<segment>.*)","/${segment}")
                                .addRequestHeader("X-Response-Time", LocalDateTime.now().toString())
                                .circuitBreaker(config -> config.setName("loanscircuitbreaker")
                                        .setFallbackUri("forward:/loansscustomercare"))
                                  ).uri("lb://LOANS"))
                .route(route->route.path("/skyorg/cards/**")
                        .filters(f->f.rewritePath("/skyorg/cards/(?<segment>.*)","/${segment}")
                                .addRequestHeader("X-Response-Time", LocalDateTime.now().toString())
                                .circuitBreaker(config -> config.setName("cardscircuitbreaker")
                                        .setFallbackUri("/cardscustomercare"))
                                ).uri("lb://CARDS")
                ).build();
    }

}
