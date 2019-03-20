package com.avatech.edi.codegen.model.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * 领域模型
 */
public class DomainModel {

    /**
     * 领域名称
     */
    private String modelName;

    /**
     * 表
     */
    private List<Table> tableList;

    /**
     * 对象
     */
    private List<BusinessObjectMap> businessObjectMaps;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public List<Table> getTableList() {
        if(tableList == null){
            tableList = new ArrayList<>();
        }
        return tableList;
    }

    public void setTableList(List<Table> tableList) {
        this.tableList = tableList;
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
}
