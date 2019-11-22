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
        health-check-url: http://${spring.cloud.client.ip-address}:${server.port}/actuator/health
        healthCheckInterval: 15s