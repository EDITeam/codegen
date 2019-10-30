package com.avatech.edi.codegen.service.project;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Fancy
 * @date 2019/10/30
 */
@Service
@Qualifier("projectFacotryService")
public class ProjectFactoryService implements IProjectService{

    @Autowired
    private SBOProjectBuilder sboProjectBuilder;

    @Autowired
    private SimpleProjectBuilder simpleProjectBuilder;

    @Autowired
    private DahubApplicationProjectBuilder dahubApplicationProjectBuilder;

    @Autowired
    private DahubServiceProjectBuilder dahubServiceProjectBuilder;

    @Override
    public void createProject(List<DomainModel> domainModels, ProjectStructure projectInitial) {
        switch (projectInitial.getProjectType()){
            case DAHUB_APPLICATION:
                dahubApplicationProjectBuilder.createProject(domainModels,projectInitial);
            case DAHUB_SERVICE:
                dahubServiceProjectBuilder.createProject(domainModels,projectInitial);
            case SBO_PROJECT:
                 sboProjectBuilder.createProject(domainModels,projectInitial);
            case SIMPLE_SERVICE:
                simpleProjectBuilder.createProject(domainModels,projectInitial);
        }
    }
}
