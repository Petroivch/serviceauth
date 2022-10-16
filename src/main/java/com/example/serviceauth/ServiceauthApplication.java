package com.example.serviceauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackageClasses = AuthorizationController.class)
public class ServiceauthApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceauthApplication.class, args);
    }

}
