package com.avatech.edi.${projectInitial.applicationName}.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ${projectInitial.applicationName}Application {

    public static void main(String[] args) {
        SpringApplication.run(${projectInitial.applicationName}Application.class, args);
    }

}