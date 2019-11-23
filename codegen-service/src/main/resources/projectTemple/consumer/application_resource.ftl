server:
  port: 9101

spring:
  application:
    name: ${serviceName}
  cloud:
    consul:
      host: localhost
      port: 8500
      discovery:
        service-name: purchase.service.provider
        health-check-url: http://${r'${'}spring.cloud.client.ip-address${r'}'}:${r'${'}server.port${r'}'}/actuator/health
        healthCheckInterval: 15s