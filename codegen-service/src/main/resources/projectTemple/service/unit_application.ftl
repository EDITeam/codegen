package com.avatech.dahupt.${projectName?lower_case};

import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/
@SpringBootApplication
@MapperScan(basePackages = "com.avatech.dahupt.${projectName?lower_case}.repository.mapper")
public class ${projectName?cap_first}ServiceTestApplication {
    @Test
    public void contextLoads() {
    }
}
