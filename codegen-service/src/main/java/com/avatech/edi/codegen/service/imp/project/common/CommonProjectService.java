package com.avatech.edi.codegen.service.imp.project.common;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.codegen.service.project.IProjectService;
import com.avatech.edi.codegen.service.imp.project.CommonService;
import com.avatech.edi.codegen.service.imp.sql.DataBaseHandler;
import com.avatech.edi.codegen.service.imp.sql.DataBaseHandlerFactory;
import com.avatech.edi.condegen.data.DataBaseType;
import com.avatech.edi.condegen.data.Dictionary;
import com.avatech.edi.condegen.data.ProjectData;
import freemarker.template.utility.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.List;

@Service
public class CommonProjectService implements IProjectService {


    @Autowired
    private CommonService commonService;
     /**
     * 创建公共模块
     * @param domainModels
     */
    @Override
    public void createProject(List<DomainModel> domainModels, ProjectStructure projectInitial) {
        // TODO 创建文件夹


        // TODO 创建POM文件

        createPOM(projectInitial);
        // TODO 创建类文件
        createApplication(projectInitial);

        // TODO 创建sql文件
        createDBSql(domainModels,projectInitial);

    }

    private void createDBSql(List<DomainModel> domainModels, ProjectStructure projectInitial) {
        if(projectInitial.getDataBaseType().equals(DataBaseType.HANA)){
            DataBaseHandler dataBaseHandler = DataBaseHandlerFactory.getDataBaseHandler(DataBaseType.HANA);
            dataBaseHandler.createDBSqlScript(domainModels,projectInitial);
        }
    }

    private void createPOM(ProjectStructure projectInitial) {
        /**
         * 只有单模块在此生成POM文件，多模块在对应模块中生成POM文件
         */
        if (projectInitial.getProjectType().equals(Dictionary.Single_Model)) {
            File file = new File(projectInitial.getProjectFilePath() + "/"+projectInitial.getProjectName()+".microservice");
            file.mkdirs();
            HashMap map = new HashMap();
            map.put("projectinfo", projectInitial);
            commonService.createTmpleCode(map, projectInitial.getProjectFilePath() + "/" + String.format(ProjectData.BASE_APPLICATION_URL,projectInitial.getProjectName())  + "/pom.xml", "pom.ftl");
        }
    }


    private void createApplication(ProjectStructure projectInitial){
        String controllerFilePath = projectInitial.getProjectFilePath() + "/" + String.format(ProjectData.APPLICATION_URL,projectInitial.getProjectName(), projectInitial.getProjectName());
        String resourceFilePath = String.format("%s/%s.microservice/src/main/resources",projectInitial.getProjectFilePath(),projectInitial.getProjectName());
        File file = new File(controllerFilePath);
        file.mkdirs();
        file = new File(resourceFilePath);
        file.mkdirs();
        HashMap map = new HashMap();
        map.put("projectInitial",projectInitial);
        map.put("applicationname","EDI");
        commonService.createTmpleCode(map, controllerFilePath +"/" + StringUtil.capitalize(projectInitial.getProjectName()) + "Application.java","application.ftl");
        commonService.createTmpleCode(map,resourceFilePath +"/application.yml","resourceforapplication.ftl");
        //createTmpleCode(map,resourceFilePath +"/logback-spring.xml","resourceforlog.ftl");
    }


}
