package com.avatech.edi.codegen.service.model;

import com.avatech.edi.codegen.model.bo.BusinessObject;
import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.modelparameter.BaseModelParameter;
import com.avatech.edi.codegen.service.TemplateService;
import com.avatech.edi.condegen.data.ProjectData;
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

//                String apiFullFilePath = modelParameter.getProjectFilePath()+ "/" + String.format(ProjectData.SINGLE_BASE_CONTROLLER_PROJECT_URL,modelParameter.getProjectName(), modelParameter.getProjectName());
////                File file = new File(apiFullFilePath);
////                file.mkdirs();
                BusinessObject businessObject = BusinessObject.createBusinessObject(domainModel,modelParameter);
                HashMap map = new HashMap();
                map.put("businessObject",businessObject);
                templateService.createTmpleFile(map
                        , modelParameter.getSourcesBasePath().concat(File.separator).concat(businessObject.getBussinessObjectName().concat("V1API.java"))
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
