package com.avatech.edi.codegen.service.model;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.modelparameter.BaseModelParameter;
import com.avatech.edi.codegen.service.TemplateService;
import com.avatech.edi.codegen.data.ModelConstant;
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
public class StarterModelService extends AbstractModelService  {

    private static final Logger logger = LoggerFactory.getLogger(StarterModelService.class);

    @Autowired
    private TemplateService templateService;

    public StarterModelService() {
        super("starter_pom.ftl");
    }



    @Override
    public void createSourcesFile(List<DomainModel> domainModels, BaseModelParameter modelParameter) {
        try {
            super.createSourcesFile(domainModels,modelParameter);

            HashMap map = new HashMap();
            map.put("projectName",modelParameter.getProjectNamePrefix());
            map.put("applicationname","EDI");
            templateService.createTmpleFile(map
                    , modelParameter.getSourcesBasePath().concat(File.separator).concat("Application.java")
                    ,"starter"
                    ,"application_starter.ftl");
            String resourceFile = modelParameter.getRootPath()
                    .concat(File.separator)
                    .concat(ModelConstant.MODEL_RESOURCES_BASE_PATH.replace(".",File.separator));
            File file = new File(resourceFile);
            file.mkdir();
            templateService.createTmpleFile(map
                    ,resourceFile.concat(File.separator).concat("application.yml")
                    ,"starter"
                    ,"resource_application.ftl");
            templateService.createTmpleFile(map
                    ,resourceFile.concat(File.separator).concat("logback-spring.xml")
                    ,"starter"
                    ,"resource_log.ftl");


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
