package com.avatech.dahupt.${projectName?lower_case}.consumer;

import com.ecwid.consul.v1.ConsulClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryProperties;
import org.springframework.cloud.consul.discovery.HeartbeatProperties;
import org.springframework.cloud.consul.discovery.TtlScheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.avatech.dahupt.${projectName?lower_case}.feignclient")
public class ${projectName?cap_first}ConsumerApplication {

    @Autowired(required = false)
    private TtlScheduler ttlScheduler;

    @Bean
    public DahuptConsulServiceRegistry consulServiceRegistry(ConsulClient consulClient, ConsulDiscoveryProperties properties,HeartbeatProperties heartbeatProperties) {
        return new DahuptConsulServiceRegistry(consulClient, properties, ttlScheduler, heartbeatProperties);
    }

    public static void main(String[] args) {
        SpringApplication.run(${projectName?cap_first}ConsumerApplication.class, args);
    }

}