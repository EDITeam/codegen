package com.avatech.edi.codegen.service.imp.project.common;

import com.avatech.edi.codegen.model.bo.BusinessObject;
import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.ProjectInitial;
import com.avatech.edi.codegen.service.IProjectService;
import com.avatech.edi.codegen.service.config.BusinessServiceException;
import com.avatech.edi.codegen.service.imp.project.CommonService;
import com.avatech.edi.condegen.common.StringUtils;
import com.avatech.edi.condegen.data.Dictionary;
import com.avatech.edi.condegen.data.ProjectData;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.utility.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
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
    public void createProject(List<DomainModel> domainModels, ProjectInitial projectInitial) {
        // TODO 创建文件夹


        // TODO 创建POM文件

        createPOM(projectInitial);
        // TODO 创建类文件
        createApplication(projectInitial);

    }

    private void createPOM(ProjectInitial projectInitial) {
        if (projectInitial.getProjectType().equals(Dictionary.Single_Model)) {
            File file = new File(projectInitial.getProjectFilePath() + "/"+projectInitial.getProjectName()+".micservice");
            file.mkdirs();
            HashMap map = new HashMap();
            map.put("projectinfo", projectInitial);
            commonService.createTmpleCode(map, projectInitial.getProjectFilePath() + "/" + String.format(ProjectData.BASE_APPLICATION_URL,projectInitial.getProjectName())  + "/pom.xml", "pom.ftl");
        }
    }


    private void createApplication(ProjectInitial projectInitial){
        String controllerFilePath = projectInitial.getProjectFilePath() + "/" + String.format(ProjectData.APPLICATION_URL,projectInitial.getProjectName(), projectInitial.getProjectName());
        String resourceFilePath = String.format("%s/%s.micservice/src/main/resources",projectInitial.getProjectFilePath(),projectInitial.getProjectName());
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
