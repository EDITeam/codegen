package com.avatech.edi.codegen.data;

import lombok.Getter;

/**
 * @author Fancy
 * @date 2019/10/30
 * 服务协议类型
 */
@Getter
public enum ServiceProtocolType {

    /**
     * Http协议 ，rest api风格
     */
    HTTP(0,"HTTP"),
    SOAP(1,"SOAP"),
    RPC(2,"RPC")
    ;

    public static final ServiceProtocolType[] ALL = { HTTP, SOAP ,RPC};

    private int key;

    private String name;

    ServiceProtocolType(int key, String name){
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
