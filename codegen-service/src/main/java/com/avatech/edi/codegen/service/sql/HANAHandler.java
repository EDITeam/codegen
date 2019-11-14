package com.avatech.edi.codegen.service.sql;

import com.avatech.edi.codegen.data.ModelConstant;
import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.codegen.model.bo.project.modelparameter.BaseModelParameter;
import com.avatech.edi.codegen.service.imp.project.CommonService;
import com.avatech.edi.codegen.data.DataBaseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
import java.util.List;

@Component
public class HANAHandler extends DataBaseHandler {

    @Autowired
    private CommonService commonService;

    @Override
    public DataBaseType getDBType() {
        return DataBaseType.HANA;
    }

    /**
     * 创建HANA数据库脚本
     * @param domainModels
     * @param baseModelParameter
     */
    @Override
    public void createDBSqlScript(List<DomainModel> domainModels, BaseModelParameter baseModelParameter) {
        super.createDBSqlScript(domainModels,baseModelParameter);
    }
}
