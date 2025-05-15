package com.sky.gatewayserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HomeController {
    @RequestMapping("/home")
    public Mono<String> contactSupport() {
        return Mono.just("Gateway server is up and running!!");
    }
}
