<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>${modelInfo.projectName}</artifactId>
        <groupId>com.avatech.dahupt</groupId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>${modelInfo.modelName}</artifactId>

    <dependencies>
        <dependency>
            <groupId>com.avatech.dahupt</groupId>
            <artifactId>${modelInfo.projectName}_service</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
        <#if projectInfo.serviceProtocol == "SOAP">
            <dependency>
                <groupId>org.apache.cxf</groupId>
                <artifactId>cxf-spring-boot-starter-jaxws</artifactId>
                <version>3.2.4</version>
            </dependency>
        </#if>
    </dependencies>

</project>