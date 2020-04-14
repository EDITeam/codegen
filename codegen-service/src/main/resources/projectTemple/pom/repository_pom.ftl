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
            <artifactId>${modelInfo.projectName}_model</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
    <#if projectInfo.dataBaseType == "MSSQL">
        <dependency>
            <groupId>com.microsoft.sqlserver</groupId>
            <artifactId>mssql-jdbc</artifactId>
        </dependency>
    </#if>
    <#if projectInfo.dataBaseType == "HANA">
        <dependency>
            <groupId>com.sap.cloud.db.jdbc</groupId>
            <artifactId>ngdbc</artifactId>
            <!--<version>2.3.48</version>-->
        </dependency>
    </#if>
    <#if projectInfo.dataBaseType == "MYSQL">
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
    </#if>
    <#if projectInfo.dataBaseType == "POSTGRESQL">
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <!--<scope>runtime</scope>-->
        </dependency>
    </#if>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.1</version>
        </dependency>
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper-spring-boot-starter</artifactId>
            <version>1.2.13</version>
        </dependency>
    </dependencies>

    <build>
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.xml</include>
                </includes>
            </resource>
        </resources>
    </build>
</project>