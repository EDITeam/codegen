package com.avatech.dahupt.${projectName?lower_case}.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/
@SpringBootApplication
@MapperScan(basePackages = "com.avatech.edi.dahub.${projectName?lower_case}.repository.mapper")
public class ${projectName?upper_case}Application {

    public static void main(String[] args) {
         SpringApplication.run(${projectName?upper_case}Application.class, args);
    }

}