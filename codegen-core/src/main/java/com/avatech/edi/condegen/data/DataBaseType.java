package com.avatech.edi.condegen.data;

import lombok.Getter;

/**
 * 数据库类型
 */
@Getter
public enum DataBaseType {

    MSSQL(0,"MSSQL"),
    HANA(1,"HANA"),
    MYSQL(2,"MYSQL"),
    ORACLE(3,"ORACLE"),
    MATERIALDB(4,"MARIADB"),
    POSTGRESQL(5,"POSTGRESQL");

    private int key;

    private String name;

     DataBaseType(int key, String name){
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
