package com.avatech.edi.codegen.data;

/**
 * @author Fancy
 * @date 2019/9/21
 */
@Deprecated()
public enum ORMType {

    MYBATIS(0,"MyBatis"),
    JPA(1,"JPA")
    ;

    private int key;

    private String name;

    ORMType(int key,String name){
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
