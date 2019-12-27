package com.avatech.edi.codegen.data;

import lombok.Getter;

/**
 * @author Fancy
 * @date 2019/11/13
 */
@Getter
public enum TableType {

    bott_NoObject(0,"bott_NoObject"),
    bott_Document(1,"bott_Document"),
    bott_DocumentLines(2,"bott_DocumentLines"),
    bott_MasterData(3,"bott_MasterData"),
    bott_MasterDataLines(4,"bott_MasterDataLines"),
    bott_SimpleData(5,"bott_SimpleData"),
    bott_SimpleDataLines(6,"bott_SimpleDataLines");

    public static final TableType[] ALL = { bott_NoObject
            , bott_Document
            ,bott_DocumentLines
            ,bott_MasterData
            ,bott_MasterDataLines
            ,bott_SimpleData
            ,bott_SimpleDataLines};

    private int key;

    private String name;

    TableType(int key, String name){
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
