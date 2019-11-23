package com.avatech.edi.codegen.service.project;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.codegen.model.bo.project.modelparameter.BaseModelParameter;
import com.avatech.edi.codegen.model.bo.project.modelparameter.ClientModelParameter;
import com.avatech.edi.codegen.model.bo.project.modelparameter.ConsumerModelParameter;
import com.avatech.edi.codegen.model.bo.project.modelparameter.ProviderModelParameter;
import com.avatech.edi.codegen.service.TemplateService;
import com.avatech.edi.codegen.service.model.ClientModelService;
import com.avatech.edi.codegen.service.model.ConsumerModelService;
import com.avatech.edi.codegen.service.model.ProviderModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Fancy
 * @date 2019/10/30
 * Dahub应用类型项目创建
 */
@Component
public class DahubApplicationProjectBuilder implements IProjectService {

    @Autowired
    private TemplateService templateService;

    @Autowired
    private ProviderModelService providerModelService;

    @Autowired
    private ConsumerModelService consumerModelService;

    @Autowired
    private ClientModelService clientModelService;

    @Override
    public void createProject(List<DomainModel> domainModels, ProjectStructure projectStructure) {
        //create provider
        BaseModelParameter modelParameter = new ProviderModelParameter(projectStructure);
        providerModelService.createPOM(modelParameter);
        providerModelService.createSourcesFile(domainModels,modelParameter);
        providerModelService.createTestsFile(domainModels,modelParameter);

        //create consumer
        modelParameter = new ConsumerModelParameter(projectStructure);
        consumerModelService.createPOM(modelParameter);
        consumerModelService.createSourcesFile(domainModels,modelParameter);
        consumerModelService.createTestsFile(domainModels,modelParameter);

        modelParameter = new ClientModelParameter(projectStructure);
        clientModelService.createPOM(modelParameter);
        clientModelService.createSourcesFile(domainModels,modelParameter);
        clientModelService.createTestsFile(domainModels,modelParameter);
    }

}
