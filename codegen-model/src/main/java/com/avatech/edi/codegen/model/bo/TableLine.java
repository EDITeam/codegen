package com.avatech.edi.codegen.model.bo;

import java.util.ArrayList;
import java.util.List;

public class TableLine {

    public TableLine() {

    }

    private String tableName;

    private String tableProName;

    private String fieldName;

    private String fieldDesc;

    private String fieldType;

    private String proName;

    private String proDataType;



    public void setTableName(String tableName) {
        this.tableName = tableName;
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

    public String getFieldDesc() {
        return fieldDesc;
    }

    public void setFieldDesc(String fieldDesc) {
        this.fieldDesc = fieldDesc;
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


}
