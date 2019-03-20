package com.avatech.edi.codegen.service.imp.project;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.ProjectInitial;
import com.avatech.edi.codegen.service.IProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProjectService implements IProjectService {

    /**
     * 创建服务模块
     * @param domainModels
     */
    @Override
    public void createProject(List<DomainModel> domainModels, ProjectInitial projectInitial) {

    }
}
