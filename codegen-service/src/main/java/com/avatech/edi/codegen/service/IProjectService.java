package com.avatech.edi.codegen.service;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.ProjectInitial;

import java.util.List;

public interface IProjectService {

    void createProject(List<DomainModel> domainModels, ProjectInitial projectInitial);
}
