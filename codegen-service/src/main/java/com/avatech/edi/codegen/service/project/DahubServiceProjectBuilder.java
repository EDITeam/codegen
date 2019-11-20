package com.avatech.edi.codegen.service.project;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.codegen.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Fancy
 * @date 2019/10/30
 * Dahub服务类型项目创建
 */
@Component
public class DahubServiceProjectBuilder implements IProjectService{

    @Autowired
    private TemplateService templateService;

    @Override
    public void createProject(List<DomainModel> domainModels, ProjectStructure projectStructure) {

    }


}
