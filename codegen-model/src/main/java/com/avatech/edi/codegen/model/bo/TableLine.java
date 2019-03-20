package com.avatech.edi.codegen.model.bo;

import java.util.ArrayList;
import java.util.List;

public class TableLine {


    /**
     * 表名称
     */
    private String tableName;

    /**
     * 表对应类名称
     */
    private String tableProName;

    /**
     * 字段名称
     */
    private String fieldName;

    /**
     * 属性描述
     */
    private String proDesc;

    /**
     * 字段类型
     */
    private String fieldType;

    /**
     * 属性名称
     */
    private String proName;

    /**
     * 属性类型
     */
    private String proDataType;

    /**
     * 是否主键
     */
    private boolean isKey;



    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public String getTableProName() {
        return tableProName;
    }

    public void setTableProName(String tableProName) {
        this.tableProName = tableProName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProDataType() {
        return proDataType;
    }

    public void setProDataType(String proDataType) {
        this.proDataType = proDataType;
    }


    public boolean isKey() {
        return isKey;
    }

    public void setKey(boolean key) {
        isKey = key;
    }
}
