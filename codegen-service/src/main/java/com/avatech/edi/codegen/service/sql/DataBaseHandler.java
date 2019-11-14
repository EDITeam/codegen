package com.avatech.edi.codegen.service.sql;

import com.avatech.edi.codegen.data.ModelConstant;
import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.codegen.data.DataBaseType;
import com.avatech.edi.codegen.model.bo.project.modelparameter.BaseModelParameter;
import com.avatech.edi.codegen.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public abstract class DataBaseHandler {

    @Autowired
    private TemplateService templateService;

    public abstract DataBaseType getDBType();

    public void createDBSqlScript(List<DomainModel> domainModels, BaseModelParameter baseModelParameter){
        String sqlResourceFilePath = baseModelParameter.getProjectStructure().getProjectFilePath()
                + "/"
                + baseModelParameter.getProjectName()
                + "/"
                + baseModelParameter.getModelName()
                + "/"
                + ModelConstant.MODEL_RESOURCES_BASE_PATH.replace(".","/")
                + "/"
                + "sql";
        File file = new File(sqlResourceFilePath);
        file.mkdirs();
        HashMap map = new HashMap();
        for (DomainModel domainModel:domainModels){
            map.put("tables",domainModel.getTableList());
            templateService.createTmpleFile(map
                    ,sqlResourceFilePath +"/"+domainModel.getModelName()+".sql"
                    ,"database"
                    ,getTemplateFile(this.getDBType()));
        }
    }

    private String getTemplateFile(DataBaseType dataBaseType){
        switch (dataBaseType){
            case HANA:return "db_hana.ftl";
            case MSSQL:return "db_mssql.ftl";
            case MYSQL:return "db_mysql.ftl";
            case POSTGRESQL:return "db_postgresql.ftl";
            default:return "";
        }
    }
}
