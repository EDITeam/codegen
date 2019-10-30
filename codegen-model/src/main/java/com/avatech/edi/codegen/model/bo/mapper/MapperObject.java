package com.avatech.edi.codegen.model.bo.mapperBO;

import java.util.ArrayList;
import java.util.List;

/**
 * mapper对象
 */
public class MapperObject {

    private String filePath;

    /**
     * 包名称
     */
    private String packageName;

    /**
     * mapper对象名称
     */
    private String mapperObjName;


    private String mapperApplicationName;


    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

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

    public String getMapperObjName() {
        return mapperObjName;
    }

    public void setMapperObjName(String mapperObjName) {
        this.mapperObjName = mapperObjName;
    }

    public List<MapperObjectItem> getMapperObjectItems() {
        if(mapperObjectItems == null){
            mapperObjectItems = new ArrayList<>();
        }
        return mapperObjectItems;
    }

    public void setMapperObjectItems(List<MapperObjectItem> mapperObjectItems) {
        this.mapperObjectItems = mapperObjectItems;
    }

    public String getMapperApplicationName() {
        return mapperApplicationName;
    }

    public void setMapperApplicationName(String mapperApplicationName) {
        this.mapperApplicationName = mapperApplicationName;
    }
}
