package com.avatech.edi.codegen.service.imp.sql;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.codegen.service.imp.project.CommonService;
import com.avatech.edi.codegen.data.DataBaseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
import java.util.List;

@Component
public class HANADataBaseHandler implements DataBaseHandler {

    @Autowired
    private CommonService commonService;

    @Override
    public DataBaseType getDBType() {
        return DataBaseType.HANA;
    }

    /**
     * 创建HANA数据库脚本
     * @param domainModels
     * @param projectInitial
     */
    @Override
    public void createDBSqlScript(List<DomainModel> domainModels, ProjectStructure projectInitial) {
        String resourceFilePath = String.format("%s/%s.microservice/src/main/resources/sql",projectInitial.getProjectFilePath(),projectInitial.getProjectName());
        File file = new File(resourceFilePath);
        file.mkdirs();
        file = new File(resourceFilePath);
        HashMap map = new HashMap();

        for (DomainModel domainModel:domainModels){
            map.put("tables",domainModel.getTableList());
            commonService.createTmpleCode(map,resourceFilePath +"/"+domainModel.getModelName()+".sql","db_hana.ftl");
        }

    }
}
