package com.solugenix.restaurantMenuOrderingSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = {"com.solugenix.restaurantMenuOrderingSystem.exception"})
public class RestaurantMenuOrderingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantMenuOrderingSystemApplication.class, args);
    }
}
