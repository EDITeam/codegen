package com.avatech.edi.codegen.service.project;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;

import java.util.List;

/**
 * 工程接口服务
 */
public interface IProjectService {

    void createProject(List<DomainModel> domainModels, ProjectStructure projectInitial);
}
