package com.musala.dronesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@ComponentScan("com.musala.dronesservice")
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
