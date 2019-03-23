package com.avatech.edi.${projectInitial.projectName}.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ${projectInitial.projectName?upper_case}Application {

    public static void main(String[] args) {
        SpringApplication.run(${projectInitial.projectName?upper_case}Application.class, args);
    }

}