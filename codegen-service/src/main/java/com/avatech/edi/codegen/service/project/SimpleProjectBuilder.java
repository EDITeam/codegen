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
 * 简单项目创建
 */
@Component
public class SimpleProjectBuilder implements IProjectService {

    @Autowired
    private TemplateService templateService;

    @Override
    public void createProject(List<DomainModel> domainModels, ProjectStructure projectStructure) {
    }

}
