package com.avatech.edi.codegen.data;

public interface Dictionary {

    /**
     * Http 服务协议
     */
    Integer ServiceProtocoles_HTTP = new Integer(0);

    /**
     * SOAP 服务协议
     */
    Integer ServiceProtocoles_SOAP = new Integer(1);

    /**
     * ORM框架  JPA
     */
    Integer ORMTypes_JPA = new Integer(0);

    /**
     * ORM框架 Mybatis
     */
    Integer ORMTypes_MYBATIS = new Integer(1);

    /**
     * 数据库 HANA
     */
    Integer DATABASETypes_HANA = new Integer(0);

    /**
     * 数据库 MSSQL
     */
    Integer DATABASETypes_MSSQL = new Integer(1);

    /**
     * 数据库 Mysql
     */
    Integer DATABASETypes_MYSQL = new Integer(2);



    /**
     * Json格式序列号
     */
    Integer SerializaTypes_JSON = new Integer(0);

    /**
     * XML格式序列化
     */
    Integer SerializaTypes_XML = new Integer(1);


    /**
     * 单模块
     */
    Integer Single_Model = new Integer(0);

    /**
     * 多模块
     */
    Integer Multiple_Model = new Integer(1);
}
