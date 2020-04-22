package com.avatech.edi.codegen.service.model;

import com.avatech.edi.codegen.data.ServiceProtocolType;
import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.modelparameter.BaseModelParameter;
import com.avatech.edi.codegen.service.TemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @author Fancy
 * @date 2019/10/30
 */
@Component
public class APIModelService extends AbstractModelService {

    private static final Logger logger = LoggerFactory.getLogger(APIModelService.class);

    @Autowired
    private TemplateService templateService;

    public APIModelService() {
        super("api_pom.ftl");
    }

    @Override
    public void createSourcesFile(List<DomainModel> domainModels, BaseModelParameter modelParameter) {
        try {
            super.createSourcesFile(domainModels,modelParameter);

            for (DomainModel domainModel:domainModels) {
                HashMap map = new HashMap();
                map.put("domainModel",domainModel);
                map.put("projectName",modelParameter.getProjectNamePrefix());
                if(modelParameter.getProjectStructure().getServiceProtocol().equals(ServiceProtocolType.HTTP)) {
                    templateService.createTmpleFile(map
                            , modelParameter.getSourcesBasePath().concat(File.separator).concat(domainModel.getModelName().concat("V1API.java"))
                            , "api"
                            , "api.ftl");
                }else if(modelParameter.getProjectStructure().getServiceProtocol().equals(ServiceProtocolType.SOAP)){
                    templateService.createTmpleFile(map
                            , modelParameter.getSourcesBasePath().concat(File.separator).concat("I".concat(domainModel.getModelName().concat("API.java")))
                            , "api"
                            , "soapapi.ftl");

                    String implSourceFullFilePath = modelParameter.getSourcesBasePath()
                            .concat(File.separator)
                            .concat("impl");
                    File file = new File(implSourceFullFilePath);
                    file.mkdirs();
                    templateService.createTmpleFile(map
                            , implSourceFullFilePath.concat(File.separator).concat(domainModel.getModelName().concat("APIImpl.java"))
                            , "api"
                            , "apiimp.ftl");
                }
            }
            if(modelParameter.getProjectStructure().getServiceProtocol().equals(ServiceProtocolType.SOAP)) {
                String configSourceFullFilePath = modelParameter.getSourcesBasePath()
                        .concat(File.separator)
                        .concat("config");
                File file = new File(configSourceFullFilePath);
                file.mkdirs();
                HashMap map = new HashMap();
                map.put("domainModels",domainModels);
                map.put("projectName",modelParameter.getProjectNamePrefix());
                templateService.createTmpleFile(map
                        , configSourceFullFilePath.concat(File.separator).concat("CxfConfig.java")
                        , "api"
                        , "cxfconfig.ftl");
            }


        } catch (IOException e) {
            logger.error("创建资源文件异常:",e);
        }
    }

    @Override
    public void createTestsFile(List<DomainModel> domainModels, BaseModelParameter modelParameter) {
        try {
            if(!modelParameter.getProjectStructure().getServiceProtocol().equals(ServiceProtocolType.SOAP)) {
                super.createTestsFile(domainModels, modelParameter);
            }
        } catch (IOException e) {
            logger.error("创建资源文件异常:",e);
        }
    }



}
