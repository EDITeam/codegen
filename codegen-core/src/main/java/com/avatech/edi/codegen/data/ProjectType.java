package com.avatech.edi.codegen.data;

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
    DAHUB_APPLICATION(0,"DAHUB_APPLICATION"),

    /**
     * Dahub 服务类项目
     */
    DAHUB_SERVICE(1,"DAHUB_SERVICE"),

    /**
     * 简单服务项目
     */
    SIMPLE_SERVICE(2,"SIMPLE_SERVICE"),

    /**
     *  B1服务项目
     */
    SBO_PROJECT(3,"SBO_PROJECT")
    ;


    public static final ProjectType[] ALL = { DAHUB_APPLICATION, DAHUB_SERVICE ,SIMPLE_SERVICE,SBO_PROJECT};

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
