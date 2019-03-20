package com.avatech.edi.codegen.model.bo.mapperBO;

import java.util.List;

/**
 * mapper对象
 */
public class MapperObject {

    /**
     * 包名称
     */
    private String packageName;

    /**
     * mapper对象名称
     */
    private String mapperName;

    /**
     * mapper明细
     */
    private List<MapperObjectItem> mapperObjectItems;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getMapperName() {
        return mapperName;
    }

    public void setMapperName(String mapperName) {
        this.mapperName = mapperName;
    }

    public List<MapperObjectItem> getMapperObjectItems() {
        return mapperObjectItems;
    }

    public void setMapperObjectItems(List<MapperObjectItem> mapperObjectItems) {
        this.mapperObjectItems = mapperObjectItems;
    }
}
