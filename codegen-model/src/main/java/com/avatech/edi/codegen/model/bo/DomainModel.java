package com.avatech.edi.codegen.model.bo;

import java.util.ArrayList;
import java.util.List;

public class DomainModel {

    public DomainModel() {
        this.tableList = new ArrayList<>();
        this.businessObjects = new ArrayList<>();
    }

    private String modelName;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * 表
     */
    private List<Table> tableList;

    public List<Table> getTableList() {
        return tableList;
    }

    public void setTableList(List<Table> tableList) {
        this.tableList = tableList;
    }

    /**
     * 对象
     */
    private List<BusinessObject> businessObjects;

    public List<BusinessObject> getBusinessObjects() {
        return businessObjects;
    }

    public void setBusinessObjects(List<BusinessObject> businessObjects) {
        this.businessObjects = businessObjects;
    }
}
