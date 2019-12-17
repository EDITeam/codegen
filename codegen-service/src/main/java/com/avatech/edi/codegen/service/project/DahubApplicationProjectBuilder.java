package com.avatech.edi.codegen.service.project;

import com.avatech.edi.codegen.data.ServiceProtocolType;
import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.codegen.model.bo.project.modelparameter.*;
import com.avatech.edi.codegen.service.TemplateService;
import com.avatech.edi.codegen.service.model.*;
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
    private ClientModelService clientModelService;

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

        if(projectStructure.getServiceProtocol().equals(ServiceProtocolType.HTTP)){
            modelParameter = new APIModelParameter(projectStructure);
            apiModelService.createPOM(modelParameter);
            apiModelService.createSourcesFile(domainModels,modelParameter);
            apiModelService.createTestsFile(domainModels,modelParameter);
            projectStructure.getModelNames().add(modelParameter.getModelName());
        }else if(projectStructure.getServiceProtocol().equals(ServiceProtocolType.SOAP)){

        }

        modelParameter = new ClientModelParameter(projectStructure);
        clientModelService.createPOM(modelParameter);
        clientModelService.createSourcesFile(domainModels,modelParameter);
        clientModelService.createTestsFile(domainModels,modelParameter);
        projectStructure.getModelNames().add(modelParameter.getModelName());

    }

}
