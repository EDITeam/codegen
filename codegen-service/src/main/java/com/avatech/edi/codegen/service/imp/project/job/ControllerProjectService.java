package com.avatech.edi.codegen.service.imp.project.job;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.ProjectInitial;
import com.avatech.edi.codegen.service.IProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControllerProjectService implements IProjectService {

    /**
     * 创建控制层模块
     * @param domainModels
     * @param projectInitial
     */
    @Override
    public void createProject(List<DomainModel> domainModels, ProjectInitial projectInitial) {

    }
}
