/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/
package com.avatech.dahub.${projectName?lower_case}.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan(basePackages = "com.avatech.edi.dahub.${projectName?lower_case}.repository.mapper")
public class ${projectName?cap_first}Application {

    public static void main(String[] args) {
         SpringApplication.run(${projectName?cap_first}Application.class, args);
    }

}