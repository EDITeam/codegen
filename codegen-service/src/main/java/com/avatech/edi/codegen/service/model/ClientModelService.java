package com.avatech.edi.codegen.service.model;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.modelparameter.BaseModelParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * @author Fancy
 * @date 2019/10/30
 */
@Component
public class ClientModelService extends AbstractModelService  {

    private static final Logger logger = LoggerFactory.getLogger(ClientModelService.class);

    public ClientModelService() {
        super("feignclient_pom.ftl");
    }

    @Override
    public void createSourcesFile(List<DomainModel> domainModels, BaseModelParameter modelParameter) {
        try {
            super.createSourcesFile(domainModels,modelParameter);
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
