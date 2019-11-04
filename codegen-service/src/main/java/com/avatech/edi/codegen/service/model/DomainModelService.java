package com.avatech.edi.codegen.service.model;

import com.avatech.edi.codegen.model.bo.BusinessObjectMap;
import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.Table;
import com.avatech.edi.codegen.model.bo.project.modelparameter.BaseModelParameter;
import com.avatech.edi.codegen.service.TemplateService;
import com.avatech.edi.codegen.common.StringUtils;
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
public class DomainModelService  extends AbstractModelService {

    private static final Logger logger = LoggerFactory.getLogger(DomainModelService.class);

    @Autowired
    private TemplateService templateService;

    public DomainModelService() {
        super("model_pom.ftl");
    }

    @Override
    public void createSourcesFile(List<DomainModel> domainModels, BaseModelParameter modelParameter) {
        try {
            super.createSourcesFile(domainModels,modelParameter);
            String boPackage;

            // TODO 创建类文件
            String boFilePath = modelParameter.getSourcesBasePath()
                    .concat(File.separator)
                    .concat("bo");
            File file = new File(boFilePath);
            file.mkdirs();
            HashMap root;
            for (DomainModel domain : domainModels) {
                if (!StringUtils.isEmpty(domain.getModelName())) {
                    boPackage = boFilePath + "/" + domain.getModelName().toLowerCase();
                    new File(boPackage).mkdirs();
                    // TODO 获取BO模板
                    for (Table table : domain.getTableList()) {
                        table.setPackageName(String.format(ModelConstant.MODEL_BASE_PACKAGE.concat(".").concat("bo").concat(".")+ domain.getModelName().toLowerCase(), modelParameter.getProjectNamePrefix()));
                        root = new HashMap();
                        root.put("table",getTableMap(table,domain.getBusinessObjectMaps()));
                        templateService.createTmpleFile(root
                                ,boPackage+"/"+table.getTableProperty()+".java"
                                ,"domain"
                                ,"model.ftl");
                    }
                }
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
            logger.error("创建测试文件异常:",e);
        }
    }



    private Table getTableMap(Table table, List<BusinessObjectMap> businessObjectMaps){
        if(businessObjectMaps == null || businessObjectMaps.size() ==0){
            return table;
        }
        for (BusinessObjectMap businessObjectMap:businessObjectMaps){
            if(businessObjectMap.getTableName().toUpperCase().equals(table.getTableName().toUpperCase())){
                table.getBusinessObjectMaps().add(businessObjectMap);
            }
        }
        return table;
    }
}
