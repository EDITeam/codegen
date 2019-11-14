package com.avatech.edi.codegen.service.sql;

import com.avatech.edi.codegen.data.DataBaseType;
import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.codegen.model.bo.project.modelparameter.BaseModelParameter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Fancy
 * @date 2019/11/14
 */
@Component
public class MsSqlHandler extends DataBaseHandler{

    @Override
    public DataBaseType getDBType() {
        return DataBaseType.MSSQL;
    }

    @Override
    public void createDBSqlScript(List<DomainModel> domainModels, BaseModelParameter baseModelParameter) {
        super.createDBSqlScript(domainModels,baseModelParameter);
    }
}
