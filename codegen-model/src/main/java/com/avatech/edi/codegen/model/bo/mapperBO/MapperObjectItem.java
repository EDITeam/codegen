package com.avatech.edi.codegen.model.bo.mapperBO;

import com.avatech.edi.codegen.model.bo.ProjectInitial;
import com.avatech.edi.codegen.model.bo.Table;
import com.avatech.edi.codegen.model.bo.TableLine;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务对象行
 */
public class MapperObjectItem extends Table {

    public static MapperObjectItem createMapperObjectItem(Table table, ProjectInitial projectInitial) {
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
