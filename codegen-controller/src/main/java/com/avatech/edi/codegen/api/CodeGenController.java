package com.avatech.edi.codegen.api;


import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.ProjectInitial;
import com.avatech.edi.codegen.service.IDataStructureFileService;
import com.avatech.edi.codegen.service.IProjectService;
import com.avatech.edi.codegen.service.imp.DataStructureFileServiceImp;
import com.avatech.edi.condegen.common.StringUtils;
import com.avatech.edi.condegen.data.DBType;
import com.avatech.edi.condegen.data.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CodeGenController {

    @Autowired
    private IProjectService projectService;

    @Autowired
    private IDataStructureFileService dataStructureFileService;

    @GetMapping("/projectinfo")
    public String getProjectInfo()
    {
        ProjectInitial projectInitial = new ProjectInitial();
        projectInitial.setProjectName("ava");
        projectInitial.setDataBaseType(DBType.HANA);
        projectInitial.setOrmType(Dictionary.ORMTypes_MYBATIS);
        projectInitial.setProjectType(Dictionary.Single_Model);
        projectInitial.setDataFilePath("C:\\Temp\\Out");
        projectInitial.setProjectFilePath("C:\\Temp\\In");
        projectInitial.setSerializaFormat(Dictionary.SerializaTypes_JSON);
        return projectInitial.toString();
    }

    @PostMapping("/project")
    public String createProject(@RequestBody ProjectInitial projectInitial){
        if(StringUtils.isEmpty(projectInitial.getDataFilePath())){
            return "数据结构路径为空";
        }
        if(StringUtils.isEmpty(projectInitial.getProjectName())){
            return "项目名称为空";
        }
        if(StringUtils.isEmpty(projectInitial.getProjectFilePath())){
            return "项目路径为空";
        }
        try{
            List<DomainModel> domainModels = dataStructureFileService.readerDataStructureFile(projectInitial.getDataFilePath());
            projectService.createProject(domainModels,projectInitial);
            return "创建项目成功";
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
