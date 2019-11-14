package com.avatech.edi.codegen.model.bo;

import com.avatech.edi.codegen.data.TableType;

import java.util.ArrayList;
import java.util.List;

/**
 * 类-表关系
 */
public class Table {

    public static String getViewName(String tableName){
        String prefixTableName = tableName.substring(0,tableName.lastIndexOf("_"));
        String suffixTableName = tableName.substring(tableName.lastIndexOf("_"),tableName.length());
        return prefixTableName+"_VIEW"+suffixTableName;
    }

    public Table(){
        this.tableLines = new ArrayList<>();
    }

    /**
     * 包名称
     */
    private String packageName;

    /**
     * 表名称
     */
    private String tableName;

    /**
     * 对应的视图名称
     */
    private String viewName;

    /**
     * 表描述
     */
    private String tableDes;

    private String tableProperty;

    /**
     * 表类型
     */
    private TableType tableType;

    private List<TableLine> tableLines;

    private List<BusinessObjectMap> businessObjectMaps;

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

    public TableType getTableType() {
        return tableType;
    }

    public void setTableType(TableType tableType) {
        this.tableType = tableType;
    }

    public List<TableLine> getTableLines() {
        if(tableLines == null){
            tableLines = new ArrayList<>();
        }
        return tableLines;
    }

    public void setTableLines(List<TableLine> tableLines) {
        this.tableLines = tableLines;
    }

    public List<BusinessObjectMap> getBusinessObjectMaps() {
        if(businessObjectMaps == null){
            businessObjectMaps = new ArrayList<>();
        }
        return businessObjectMaps;
    }

    public void setBusinessObjectMaps(List<BusinessObjectMap> businessObjectMaps) {
        this.businessObjectMaps = businessObjectMaps;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }


}
