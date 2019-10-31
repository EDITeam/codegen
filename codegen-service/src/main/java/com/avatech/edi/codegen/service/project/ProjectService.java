package com.avatech.edi.codegen.service.project;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.codegen.service.project.IProjectService;
import com.avatech.edi.codegen.service.imp.project.common.CommonProjectService;
import com.avatech.edi.codegen.service.imp.project.controller.ControllerProjectService;
import com.avatech.edi.codegen.service.imp.project.model.ModelProjectService;
import com.avatech.edi.codegen.service.imp.project.repository.RepositoryProjectService;
import com.avatech.edi.codegen.service.imp.project.repositorybusinessone.RepositoryBusinessOneProjectServcie;
import com.avatech.edi.codegen.service.imp.project.service.ServiceProjectService;
import com.avatech.edi.condegen.data.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class ProjectService implements IProjectService{

    @Autowired
    private CommonProjectService commonProjectService;

    @Autowired
    private ModelProjectService modelProjectService;

    @Autowired
    private RepositoryProjectService repositoryProjectService;

    @Autowired
    private RepositoryBusinessOneProjectServcie repositoryBusinessOneProjectServcie;

    @Autowired
    private ServiceProjectService serviceProjectService;

    @Autowired
    private ControllerProjectService controllerProjectService;


    /**
     * 创建项目模板
     * @param domainModels
     * @param projectStructure
     */
    @Override
    public void createProject(List<DomainModel> domainModels, ProjectStructure projectStructure) {

        
        commonProjectService.createProject(domainModels,projectStructure);
        modelProjectService.createProject(domainModels,projectStructure);
        repositoryProjectService.createProject(domainModels,projectStructure);
        repositoryBusinessOneProjectServcie.createProject(domainModels,projectStructure);
        serviceProjectService.createProject(domainModels,projectStructure);
        controllerProjectService.createProject(domainModels,projectStructure);

        if(projectStructure.getProjectType().equals(Dictionary.Single_Model)){

        }
    }
}
