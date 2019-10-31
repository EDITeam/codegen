package com.avatech.edi.codegen.model.bo.mapper;

import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.codegen.model.bo.Table;
import com.avatech.edi.codegen.model.bo.project.modelparameter.BaseModelParameter;

/**
 * 业务对象行
 */
public class MapperObjectItem extends Table {

    public static MapperObjectItem createMapperObjectItem(Table table, ProjectStructure projectInitial) {
        MapperObjectItem mapperObjectItem = new MapperObjectItem();
        mapperObjectItem.setTableName(table.getTableName());
        mapperObjectItem.setBoPackageName(table.getPackageName());
        mapperObjectItem.setBusinessObjectMaps(table.getBusinessObjectMaps());
        mapperObjectItem.setTableType(table.getTableType());
        mapperObjectItem.setTableDes(table.getTableDes());
        mapperObjectItem.setPackageName(table.getPackageName());
        mapperObjectItem.setTableProperty(table.getTableProperty());
        mapperObjectItem.getTableLines().addAll(table.getTableLines());
        return mapperObjectItem;
    }

    public static MapperObjectItem createMapperObjectItem(Table table, BaseModelParameter modelParameter) {
        MapperObjectItem mapperObjectItem = new MapperObjectItem();
        mapperObjectItem.setTableName(table.getTableName());
        mapperObjectItem.setBoPackageName(table.getPackageName());
        mapperObjectItem.setBusinessObjectMaps(table.getBusinessObjectMaps());
        mapperObjectItem.setTableType(table.getTableType());
        mapperObjectItem.setTableDes(table.getTableDes());
        mapperObjectItem.setPackageName(table.getPackageName());
        mapperObjectItem.setTableProperty(table.getTableProperty());
        mapperObjectItem.getTableLines().addAll(table.getTableLines());
        return mapperObjectItem;
    }

    private String boPackageName;

    public String getBoPackageName() {
        return boPackageName;
    }

    public void setBoPackageName(String boPackageName) {
        this.boPackageName = boPackageName;
    }


}
