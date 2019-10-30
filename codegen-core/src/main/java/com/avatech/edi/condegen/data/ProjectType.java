package com.avatech.edi.condegen.data;

import lombok.Getter;

/**
 * @author Fancy
 * @date 2019/9/21
 * 项目类型
 */
@Getter
public enum ProjectType {

    /**
     * Dahub 应用类项目
     */
    DAHUB_APPLICATION(0,"Dahub-Application"),

    /**
     * Dahub 服务类项目
     */
    DAHUB_SERVICE(1,"Dahub-Service"),

    /**
     * 简单服务项目
     */
    SIMPLE_SERVICE(2,"SimpleService"),

    /**
     *  B1服务项目
     */
    SBO_PROJECT(3,"SBOProject")
    ;

    private int key;

    private String name;

    ProjectType(int key,String name){
        this.key = key;
        this.name = name;
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }
}
