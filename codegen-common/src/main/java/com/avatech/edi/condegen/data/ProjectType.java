package com.avatech.edi.condegen.data;

/**
 * @author Fancy
 * @date 2019/9/21
 */
public enum ProjectType {

    MUTIL_MODUE(0,"MutilModel"),
    SIGNAL_MODLE(1,"SignalModel")
    ;

    private int key;

    private String name;

    ProjectType(int key,String name){
        this.key = key;
        this.name = name;
    }
}
