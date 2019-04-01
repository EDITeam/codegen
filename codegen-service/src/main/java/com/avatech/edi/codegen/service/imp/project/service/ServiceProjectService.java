package com.avatech.edi.codegen.service.imp.project.service;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.ProjectInitial;
import com.avatech.edi.codegen.model.bo.Table;
import com.avatech.edi.codegen.model.bo.mapperBO.MapperObject;
import com.avatech.edi.codegen.model.bo.mapperBO.MapperObjectItem;
import com.avatech.edi.codegen.service.IProjectService;
import com.avatech.edi.codegen.service.config.BusinessServiceException;
import com.avatech.edi.codegen.service.imp.project.CommonService;
import com.avatech.edi.codegen.service.imp.project.mapper.MapperResourceService;
import com.avatech.edi.codegen.service.imp.project.mapper.MapperService;
import com.avatech.edi.condegen.data.Dictionary;
import com.avatech.edi.condegen.data.ProjectData;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;

@Service
public class ServiceProjectService implements IProjectService {


    @Autowired
    private CommonService commonService;

    /**
     * 创建服务模块
     * @param domainModels
     */
    @Override
    public void createProject(List<DomainModel> domainModels, ProjectInitial projectInitial) {
        // TODO 创建文件夹
        String serviceFilePath;
        if (projectInitial.getProjectType().equals(Dictionary.Single_Model)) {
            serviceFilePath = projectInitial.getProjectFilePath() + "/" + String.format(ProjectData.SINGLE_BASE_SERVICE_PROJECT_URL, projectInitial.getProjectName(), projectInitial.getProjectName());
        } else {
            serviceFilePath = projectInitial.getProjectFilePath() + "/" + String.format(ProjectData.MULTIPLE_BASE_SERVICE_PROJECT_URL, projectInitial.getProjectName(), projectInitial.getProjectName());
        }
        File file = new File(serviceFilePath);
        file.mkdirs();

        MapperObject mapperObject;
        HashMap root = new HashMap();
        for (DomainModel domainModel : domainModels) {
            mapperObject = new MapperObject();
            mapperObject.setFilePath(serviceFilePath);
            mapperObject.setMapperObjName(domainModel.getModelName());
            mapperObject.setPackageName(String.format("com.avatech.edi.%s", projectInitial.getProjectName()));
            root.put("mapperObject", mapperObject);
            commonService.createTmpleCode(root, serviceFilePath + "/" + mapperObject.getMapperObjName() + "Service.java", "service.ftl");
        }
    }


}
