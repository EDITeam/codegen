package com.avatech.edi.codegen.data;

import lombok.Getter;

/**
 * @author Fancy
 * @date 2019/10/30
 */
@Getter
public enum ModelEnum {

    /**
     * Core 模块
     */
    CORE(0,"core"),

    /**
     * model 模块
     */
    MODEL(1,"model"),

    /**
     * service 模块
     */
    SERVICE(2,"service"),

    /**
     *  api 模块
     */
    API(3,"api"),

    /**
     *  starter 模块
     */
    STARTER(4,"starter"),

    /**
     *  client 模块
     */
    CLIENT(5,"client"),

    /**
     *  repository 模块
     */
    REPOSITORY(6,"repository")
    ;

    private int key;

    private String name;

    ModelEnum(int key,String name){
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
