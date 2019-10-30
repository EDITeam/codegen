package com.avatech.edi.condegen.data;

import lombok.Getter;

@Getter
public enum DBType {

    MSSQL(0,"MSSQL"),
    HANA(1,"HANA"),
    MYSQL(2,"MYSQL"),
    ORACLE(3,"ORACLE"),
    MATERIALDB(4,"MATERILDB");

    private int key;

    private String name;

     DBType(int key,String name){
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
