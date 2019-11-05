package com.avatech.edi.codegen.api.v1;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.codegen.service.IDataStructureFileService;
import com.avatech.edi.codegen.service.project.IProjectService;
import com.avatech.edi.codegen.common.StringUtils;
import com.avatech.edi.codegen.data.DataBaseType;
import com.avatech.edi.codegen.data.Dictionary;
import com.avatech.edi.codegen.data.ProjectType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Fancy
 * @date 2019/10/30
 */

@RestController
@RequestMapping(("/edi/v1/*"))
public class CodeGenV1Api {

    @Autowired
    @Qualifier("projectFacotryService")
    private IProjectService projectService;

    @Autowired
    private IDataStructureFileService dataStructureFileService;

    @GetMapping("/projectinfo")
    public @ResponseBody
    ProjectStructure getProjectInfo() {
        ProjectStructure projectInitial = new ProjectStructure();
        projectInitial.setProjectName("ava");
        projectInitial.setDataBaseType(DataBaseType.HANA);
        projectInitial.setProjectType(ProjectType.SBO_PROJECT);
        projectInitial.setDataFilePath("C:\\Temp\\Out");
        projectInitial.setProjectFilePath("C:\\Temp\\In");
        projectInitial.setSerializaFormat(Dictionary.SerializaTypes_JSON);
        return projectInitial;
    }

    @PostMapping("/project")
    public String createProject(@RequestBody ProjectStructure projectInitial) {
        if (StringUtils.isEmpty(projectInitial.getDataFilePath())) {
            return "数据结构路径为空";
        }
        if (StringUtils.isEmpty(projectInitial.getProjectName())) {
            return "项目名称为空";
        }
        if (StringUtils.isEmpty(projectInitial.getProjectFilePath())) {
            return "项目路径为空";
        }
        try {
            List<DomainModel> domainModels = dataStructureFileService.readerDataStructureFile(projectInitial.getDataFilePath());
            projectService.createProject(domainModels, projectInitial);
            return "创建项目成功";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    private void fileDownload(){}

}
