package com.avatech.edi.codegen.service.imp.sql;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.ProjectInitial;
import com.avatech.edi.codegen.service.imp.project.CommonService;
import com.avatech.edi.condegen.data.DBType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.io.File;
import java.util.HashMap;
import java.util.List;

@Component
public class HANADataBaseHandler implements DataBaseHandler {

    @Autowired
    private CommonService commonService;

    @Override
    public DBType getDBType() {
        return DBType.HANA;
    }

    /**
     * 创建HANA数据库脚本
     * @param domainModels
     * @param projectInitial
     */
    @Override
    public void createDBSqlScript(List<DomainModel> domainModels, ProjectInitial projectInitial) {
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
