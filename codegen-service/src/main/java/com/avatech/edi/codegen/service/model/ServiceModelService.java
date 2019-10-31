package com.avatech.edi.codegen.service.model;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.mapper.MapperObject;
import com.avatech.edi.codegen.model.bo.project.modelparameter.BaseModelParameter;
import com.avatech.edi.codegen.service.TemplateService;
import com.avatech.edi.condegen.data.Dictionary;
import com.avatech.edi.condegen.data.ModelConstant;
import com.avatech.edi.condegen.data.ProjectData;
import net.bytebuddy.asm.Advice;
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
 * @date 2019/10/31
 */
@Component
public class ServiceModelService extends AbstractModelService{

    private static final Logger logger = LoggerFactory.getLogger(ServiceModelService.class);

    @Autowired
    private TemplateService templateService;

    public ServiceModelService() {
        super("service_pom.ftl");
    }

    @Override
    public void createSourcesFile(List<DomainModel> domainModels, BaseModelParameter modelParameter) {
        try {
            super.createSourcesFile(domainModels,modelParameter);

            MapperObject mapperObject;
            HashMap root = new HashMap();
            for (DomainModel domainModel : domainModels) {
                mapperObject = new MapperObject();
                mapperObject.setFilePath(modelParameter.getSourcesBasePath());
                mapperObject.setMapperObjName(domainModel.getModelName());
                mapperObject.setPackageName(String.format(ModelConstant.SERVICE_BASE_PACKAGE,modelParameter.getModelName()));
                root.put("mapperObject", mapperObject);
                templateService.createTmpleFile(root
                        , modelParameter.getSourcesBasePath()
                                .concat(File.separator)
                                .concat(mapperObject.getMapperObjName().concat("Service.java"))
                        ,"service"
                        , "service.ftl");
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
