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
            <groupId>com.avatech.edi</groupId>
            <artifactId>edi-framework-common</artifactId>
            <version>2.0.0</version>
        </dependency>
        <dependency>
            <groupId>com.avatech.edi</groupId>
            <artifactId>edi-framework-model</artifactId>
            <version>2.0.0</version>
        </dependency>
        <dependency>
            <groupId>com.google.guava</groupId>
            <artifactId>guava</artifactId>
            <version>28.2-jre</version>
        </dependency>
    </dependencies>

</project>