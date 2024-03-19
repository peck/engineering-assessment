package com.jack.engineeringassessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.jack")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
