package com.avatech.edi.codegen.service.imp;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.ProjectInitial;
import com.avatech.edi.codegen.service.IProjectService;
import com.avatech.edi.codegen.service.imp.project.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
     * @param projectInitial
     */
    @Override
    public void createProject(List<DomainModel> domainModels, ProjectInitial projectInitial) {
        commonProjectService.createProject(domainModels,projectInitial);
        modelProjectService.createProject(domainModels,projectInitial);
        repositoryProjectService.createProject(domainModels,projectInitial);
        repositoryBusinessOneProjectServcie.createProject(domainModels,projectInitial);
        serviceProjectService.createProject(domainModels,projectInitial);
        controllerProjectService.createProject(domainModels,projectInitial);
    }
}
