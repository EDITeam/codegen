package com.avatech.edi.codegen.service.project;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.codegen.model.bo.project.modelparameter.*;
import com.avatech.edi.codegen.service.TemplateService;
import com.avatech.edi.codegen.service.model.*;
import com.avatech.edi.codegen.data.ServiceProtocolType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
import java.util.List;

/**
 * @author Fancy
 * @date 2019/10/30
 * SBO 项目创建
 */
@Component
public class SBOProjectBuilder implements IProjectService {

    @Autowired
    private APIModelService apiModelService;

    @Autowired
    private CoreModelService coreModelService;

    @Autowired
    private DomainModelService domainModelService;

    @Autowired
    private StarterModelService starterModelService;

    @Autowired
    private ServiceModelService serviceModelService;

    @Autowired
    private RepositoryModelService repositoryModelService;

    @Autowired
    private TemplateService templateService;

    @Override
    public void createProject(List<DomainModel> domainModels, ProjectStructure projectStructure) {
        BaseModelParameter modelParameter = new CoreModelParameter(projectStructure);
        coreModelService.createPOM(modelParameter);
        coreModelService.createSourcesFile(domainModels,modelParameter);
        coreModelService.createTestsFile(domainModels,modelParameter);
        projectStructure.getModelNames().add(modelParameter.getModelName());

        if(projectStructure.getServiceProtocol().equals(ServiceProtocolType.HTTP)){
            modelParameter = new APIModelParameter(projectStructure);
            apiModelService.createPOM(modelParameter);
            apiModelService.createSourcesFile(domainModels,modelParameter);
            apiModelService.createTestsFile(domainModels,modelParameter);
            projectStructure.getModelNames().add(modelParameter.getModelName());
        }else if(projectStructure.getServiceProtocol().equals(ServiceProtocolType.SOAP)){

        }

        modelParameter = new DomainModelParameter(projectStructure);
        domainModelService.createPOM(modelParameter);
        domainModelService.createSourcesFile(domainModels,modelParameter);
        domainModelService.createTestsFile(domainModels,modelParameter);
        modelParameter.setProjectStructure(projectStructure);
        domainModelService.createSqlResourcesFile(domainModels,modelParameter);
        projectStructure.getModelNames().add(modelParameter.getModelName());

        modelParameter = new ServiceModelParameter(projectStructure);
        serviceModelService.createPOM(modelParameter);
        serviceModelService.createSourcesFile(domainModels,modelParameter);
        serviceModelService.createTestsFile(domainModels,modelParameter);
        projectStructure.getModelNames().add(modelParameter.getModelName());

        modelParameter = new StarterModelParameter(projectStructure);
        starterModelService.createPOM(modelParameter);
        starterModelService.createSourcesFile(domainModels,modelParameter);
        starterModelService.createTestsFile(domainModels,modelParameter);
        projectStructure.getModelNames().add(modelParameter.getModelName());

        modelParameter = new RepositoryModelParameter(projectStructure);
        repositoryModelService.createPOM(modelParameter);
        repositoryModelService.createSourcesFile(domainModels,modelParameter);
        repositoryModelService.createTestsFile(domainModels,modelParameter);
        projectStructure.getModelNames().add(modelParameter.getModelName());

        //调整项目名称
        projectStructure.setProjectName(modelParameter.getProjectName());
        createProjectPOM(projectStructure);


    }

    private void createProjectPOM(ProjectStructure projectStructure) {
        String pomFullFilePath = projectStructure.getProjectFilePath()
                .concat(File.separator)
                .concat(projectStructure.getProjectName())
                .concat(File.separator);
        File file = new File(pomFullFilePath);
        file.mkdirs();
        HashMap map = new HashMap();
        map.put("projectInfo", projectStructure);
        templateService.createTmpleFile(map,pomFullFilePath.concat("pom.xml"),"pom","project_pom.ftl");

    }
}
