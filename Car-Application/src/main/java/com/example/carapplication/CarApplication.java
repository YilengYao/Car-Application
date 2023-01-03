package com.example.carapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackageClasses = {
                com.example.carapplication.configuration.ApplicationSpecificSpringComponentScanMarker.class,
                com.example.carapplication.graphql.ApplicationSpecificSpringComponentScanMarker.class
        })
public class CarApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarApplication.class, args);
    }

}
