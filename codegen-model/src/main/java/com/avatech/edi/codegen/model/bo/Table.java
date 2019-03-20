package com.avatech.edi.codegen.model.bo;

import java.util.ArrayList;
import java.util.List;

public class Table {

    public Table(){
        this.tableLines = new ArrayList<>();
    }

    private String packageName;

    private String tableName;

    private String tableDes;

    private String tableProperty;

    private Integer tableType;

    private List<TableLine> tableLines;

    private BusinessObject businessObject;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableDes() {
        return tableDes;
    }

    public void setTableDes(String tableDes) {
        this.tableDes = tableDes;
    }

    public String getTableProperty() {
        return tableProperty;
    }

    public void setTableProperty(String tableProperty) {
        this.tableProperty = tableProperty;
    }

    public Integer getTableType() {
        return tableType;
    }

    public void setTableType(Integer tableType) {
        this.tableType = tableType;
    }

    public List<TableLine> getTableLines() {
        return tableLines;
    }

    public void setTableLines(List<TableLine> tableLines) {
        this.tableLines = tableLines;
    }

    public BusinessObject getBusinessObject() {
        return businessObject;
    }

    public void setBusinessObject(BusinessObject businessObject) {
        this.businessObject = businessObject;
    }
}
