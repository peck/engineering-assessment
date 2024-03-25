package com.dtx.it.foodtruck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class FoodTruckApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodTruckApplication.class, args);
    }

}
