package com.avatech.dahupt.${projectName?lower_case}.repository;

import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/
@SpringBootApplication
@MapperScan(basePackages = "com.avatech.dahupt.${projectName?lower_case}.repository.mapper")
public class ${projectName?cap_first}RepositoryApplication {
    @Test
    public void contextLoads() {
    }
}
