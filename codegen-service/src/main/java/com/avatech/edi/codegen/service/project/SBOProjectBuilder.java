package com.avatech.edi.codegen.service.project;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.codegen.model.bo.project.modelparameter.APIModelParameter;
import com.avatech.edi.codegen.model.bo.project.modelparameter.BaseModelParameter;
import com.avatech.edi.codegen.service.model.APIModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    @Override
    public void createProject(List<DomainModel> domainModels, ProjectStructure projectStructure) {
        BaseModelParameter modelParameter = new APIModelParameter(projectStructure);
        apiModelService.createModelFile(domainModels,modelParameter);
    }
}
