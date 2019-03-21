package com.avatech.edi.codegen.service.imp.project.repositorybusinessone;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.ProjectInitial;
import com.avatech.edi.codegen.service.IProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepositoryBusinessOneProjectServcie implements IProjectService {

    /**
     * 创建B1仓储模块
     * @param domainModels
     */
    @Override
    public void createProject(List<DomainModel> domainModels, ProjectInitial projectInitial) {

    }
}
