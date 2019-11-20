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
     * json属性
     */
    private String jsonProperty;

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
     * 字段长度
     */
    private Integer fieldSize;

    /**
     * 是否主键
     */
    private boolean isKey;

    /**
     * 是否必须字段
     */
    private boolean isRequired;



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

    public Integer getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(Integer fieldSize) {
        this.fieldSize = fieldSize;
    }

    public String getJsonProperty() {
        return jsonProperty;
    }

    public void setJsonProperty(String jsonProperty) {
        this.jsonProperty = jsonProperty;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean required) {
        isRequired = required;
    }
}
