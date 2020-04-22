<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <packaging>pom</packaging>
    <#if projectInfo.modelNames?has_content>
    <modules>
        <#list projectInfo.modelNames as modelName>
        <module>${modelName}</module>
        </#list>
    </modules>
    </#if>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.8.RELEASE</version>
        <relativePath/>
    </parent>
    <groupId>com.avatech.dahupt</groupId>
    <artifactId>${projectInfo.projectName}</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>${projectInfo.projectName}</name>
    <description>${projectInfo.projectName}</description>

    <properties>
        <java.version>1.8</java.version>
        <#if projectInfo.projectType == "DAHUPT_APPLICATION" || projectInfo.projectType == "DAHUPT_SERVICE">
        <spring-cloud.version>Greenwich.SR3</spring-cloud.version>
        <spring-cloud-alibaba.version>0.2.1.RELEASE</spring-cloud-alibaba.version>
        </#if>
    </properties>

    <repositories>
        <repository>
            <id>edi.maven</id>
            <name>EDI Maven Repository</name>
            <url>http://114.113.221.167:18081/repository/maven-public/</url>
            <releases>
                <enabled>true</enabled>
            </releases>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </repository>
    </repositories>

    <dependencies>
    <#if projectInfo.projectType == "DAHUPT_APPLICATION" || projectInfo.projectType == "DAHUPT_SERVICE">
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
        </dependency>
        <dependency>
            <groupId>com.avatech.edi</groupId>
            <artifactId>dahupt-common-security</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
    </#if>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
            <exclusions>
                <exclusion>
                    <groupId>org.junit.vintage</groupId>
                    <artifactId>junit-vintage-engine</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
    </dependencies>

    <#if projectInfo.projectType == "DAHUPT_APPLICATION" || projectInfo.projectType == "DAHUPT_SERVICE">
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-alibaba-dependencies</artifactId>
                <version>${spring-cloud-alibaba.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${r'${spring-cloud.version}'}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
    </#if>

</project>
