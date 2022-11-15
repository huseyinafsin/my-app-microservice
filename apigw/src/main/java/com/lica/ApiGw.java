package com.lica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiGw {
    public static void main(String[] args) {

        SpringApplication.run(ApiGw.class, args);
    }
}