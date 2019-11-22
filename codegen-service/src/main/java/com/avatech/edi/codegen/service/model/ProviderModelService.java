package com.avatech.edi.codegen.service.model;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.modelparameter.BaseModelParameter;
import com.avatech.edi.codegen.service.TemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @author Fancy
 * @date 2019/11/22
 */
public class ProviderModelService extends AbstractModelService {

    private static final Logger logger = LoggerFactory.getLogger(ProviderModelService.class);

    public ProviderModelService() {
        super("provider_pom.ftl");
    }

    @Autowired
    private TemplateService templateService;

    @Override
    public void createSourcesFile(List<DomainModel> domainModels, BaseModelParameter modelParameter) {
        try {
            super.createSourcesFile(domainModels,modelParameter);

            for (DomainModel domainModel:domainModels) {
                HashMap map = new HashMap();
                map.put("domainModel",domainModel);
                map.put("projectName",modelParameter.getProjectNamePrefix());
                templateService.createTmpleFile(map
                        , modelParameter.getSourcesBasePath().concat(File.separator).concat(domainModel.getModelName().concat("V1API.java"))
                        ,"api"
                        ,"api.ftl");

            }

        } catch (IOException e) {
            logger.error("创建资源文件异常:",e);
        }
    }

    @Override
    public void createTestsFile(List<DomainModel> domainModels, BaseModelParameter modelParameter) {
        try {
            super.createTestsFile(domainModels,modelParameter);
        } catch (IOException e) {
            logger.error("创建资源文件异常:",e);
        }
    }
}
