package com.avatech.edi.codegen.service.project;

import com.avatech.edi.codegen.data.ServiceProtocolType;
import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.codegen.model.bo.project.modelparameter.APIModelParameter;
import com.avatech.edi.codegen.model.bo.project.modelparameter.BaseModelParameter;
import com.avatech.edi.codegen.model.bo.project.modelparameter.StarterModelParameter;
import com.avatech.edi.codegen.service.TemplateService;
import com.avatech.edi.codegen.service.model.APIModelService;
import com.avatech.edi.codegen.service.model.StarterModelService;
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


    @Autowired
    private StarterModelService starterModelService;

    @Autowired
    private APIModelService apiModelService;

    @Override
    public void createProject(List<DomainModel> domainModels, ProjectStructure projectStructure) {
        BaseModelParameter modelParameter = new StarterModelParameter(projectStructure);
        starterModelService.createPOM(modelParameter);
        starterModelService.createSourcesFile(domainModels,modelParameter);
        starterModelService.createTestsFile(domainModels,modelParameter);
        projectStructure.getModelNames().add(modelParameter.getModelName());


        modelParameter = new APIModelParameter(projectStructure);
        apiModelService.createPOM(modelParameter);
        apiModelService.createSourcesFile(domainModels,modelParameter);
        apiModelService.createTestsFile(domainModels,modelParameter);
        projectStructure.getModelNames().add(modelParameter.getModelName());
    }

}
