package com.avatech.edi.codegen.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.avatech.edi.codegen")
@SpringBootApplication
public class CodeGenApplication {
    public static void main(String[] args){
        SpringApplication.run(CodeGenApplication.class,args);
    }
}
