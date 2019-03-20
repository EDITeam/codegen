package com.avatech.edi.codegen.model.bo;

import java.util.List;

public class BusinessObject {

    private String tableName;

    private String tableProName;

    private String objectCode;

    private List<String> childTableNames;

    private List<String> childTableProNames;


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

    public List<String> getChildTableNames() {
        return childTableNames;
    }

    public void setChildTableNames(List<String> childTableNames) {
        this.childTableNames = childTableNames;
    }

    public List<String> getChildTableProNames() {
        return childTableProNames;
    }

    public void setChildTableProNames(List<String> childTableProNames) {
        this.childTableProNames = childTableProNames;
    }
}
