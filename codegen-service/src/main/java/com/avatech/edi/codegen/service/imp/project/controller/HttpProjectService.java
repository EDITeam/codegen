package com.avatech.edi.codegen.service.imp.project.controller;

import com.avatech.edi.codegen.model.bo.BusinessObject;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.codegen.service.imp.project.CommonService;
import com.avatech.edi.codegen.data.ProjectData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;

/**
 * http协议项目服务
 */
@Service
public class HttpProjectService {

    @Autowired
    private CommonService commonService;

    public void createHttpProjectFile(BusinessObject businessObject, ProjectStructure projectInitial){

        String controllerFilePath = projectInitial.getProjectFilePath()+ "/" + String.format(ProjectData.SINGLE_BASE_CONTROLLER_PROJECT_URL,projectInitial.getProjectName(), projectInitial.getProjectName());
        File file = new File(controllerFilePath);
        file.mkdirs();
        HashMap map = new HashMap();
        map.put("businessObject",businessObject);
        commonService.createTmpleCode(map, controllerFilePath +"/" + businessObject.getBussinessObjectName()+ "Controller.java","controller.ftl");
    }


}
