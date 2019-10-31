package com.avatech.edi.codegen.service.project;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Fancy
 * @date 2019/10/30
 * Dahub应用类型项目创建
 */
@Component
public class DahubApplicationProjectBuilder implements IProjectService {


    @Override
    public void createProject(List<DomainModel> domainModels, ProjectStructure projectInitial) {

    }
}
