package com.avatech.edi.codegen.service.imp.project.controller;

import com.avatech.edi.codegen.model.bo.BusinessObject;
import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.ProjectInitial;
import com.avatech.edi.codegen.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControllerProjectService implements IProjectService {

    @Autowired
    private HttpProjectService httpProjectService;

    @Autowired
    private SoapProjectService soapProjectService;

    @Autowired
    private JobProjectServcie jobProjectServcie;

    /**
     * 创建控制层模块
     * @param domainModels
     * @param projectInitial
     */
    @Override
    public void createProject(List<DomainModel> domainModels, ProjectInitial projectInitial) {
        httpProjectService = new HttpProjectService();
        for (DomainModel domainModel:domainModels) {
            httpProjectService.createHttpProjectFile(BusinessObject.createBusinessObject(domainModel,projectInitial),projectInitial);
        }
    }

}
