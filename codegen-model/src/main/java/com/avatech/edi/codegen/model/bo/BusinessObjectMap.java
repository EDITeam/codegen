package com.avatech.edi.codegen.model.bo;

import java.util.List;

/**
 * 业务对象
 */
public class BusinessObjectMap {

    private String tableName;

    private String tableProName;

    private String objectCode;

    private String objectType;

    private String childTableName;

    private String childTableProName;


    public String getTableName() {
        return tableName;
    }


    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableProName() {
        return tableProName;
    }

    public void setTableProName(String tableProName) {
        this.tableProName = tableProName;
    }

    public String getObjectCode() {
        return objectCode;
    }

    public void setObjectCode(String objectCode) {
        this.objectCode = objectCode;
    }

    public String getChildTableName() {
        return childTableName;
    }

    public void setChildTableNames(String childTableName) {
        this.childTableName = childTableName;
    }

    public String getChildTableProName() {
        return childTableProName;
    }

    public void setChildTableProName(String childTableProName) {
        this.childTableProName = childTableProName;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }
}
