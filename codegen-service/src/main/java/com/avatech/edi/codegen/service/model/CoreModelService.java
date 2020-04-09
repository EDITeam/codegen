package com.avatech.edi.codegen.service.model;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.modelparameter.BaseModelParameter;
import com.avatech.edi.codegen.service.TemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @author Fancy
 * @date 2019/10/30
 */
@Component
public class CoreModelService  extends AbstractModelService  {

    private static final Logger logger = LoggerFactory.getLogger(CoreModelService.class);

    @Autowired
    private TemplateService templateService;

    public CoreModelService() {
        super("core_pom.ftl");
    }

    @Override
    public void createSourcesFile(List<DomainModel> domainModels, BaseModelParameter modelParameter) {
        try {
            super.createSourcesFile(domainModels,modelParameter);
            HashMap map = new HashMap();
            map.put("projectName",modelParameter.getProjectNamePrefix());
            templateService.createTmpleFile(map
                    , modelParameter.getSourcesBasePath().concat(File.separator).concat("CustomExceptionHandler.java")
                    ,"core"
                    ,"customexceptionhandler.ftl");
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
