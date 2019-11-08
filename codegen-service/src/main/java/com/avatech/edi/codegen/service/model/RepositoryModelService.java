package com.avatech.edi.codegen.service.model;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.Table;
import com.avatech.edi.codegen.model.bo.mapper.MapperObject;
import com.avatech.edi.codegen.model.bo.mapper.MapperObjectItem;
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
 * @date 2019/10/31
 */
@Component
public class RepositoryModelService extends AbstractModelService{

    private static final Logger logger = LoggerFactory.getLogger(RepositoryModelService.class);

    @Autowired
    private TemplateService templateService;

    public RepositoryModelService() {
        super("repository_pom.ftl");
    }


    @Override
    public void createSourcesFile(List<DomainModel> domainModels, BaseModelParameter modelParameter) {
        try {
            super.createSourcesFile(domainModels,modelParameter);

            MapperObject mapperObject;

            for (DomainModel domainModel : domainModels) {
                mapperObject = getMapperObject(domainModel, modelParameter);
                mapperObject.setMapperApplicationName(modelParameter.getProjectNamePrefix());
                createMapperResource(mapperObject);
                mapperObject.setPackageName(modelParameter.getModelBasePakage().concat(".").concat("mapper"));
                createMapper(mapperObject);
                mapperObject.setFilePath(modelParameter.getSourcesBasePath());
                mapperObject.setPackageName(modelParameter.getModelBasePakage());
                createRepository(mapperObject);
            }



            // repository

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

    private void createMapper(MapperObject mapperObject){
        // mapper
        String mapperFilePath = mapperObject.getFilePath();
        File file = new File(mapperFilePath);
        file.mkdirs();

        // TODO 创建mapper类
        HashMap root = new HashMap();
        root.put("mapperObject",mapperObject);
        templateService.createTmpleFile(root
                ,mapperFilePath+"/"+mapperObject.getMapperObjName()+"Mapper.java"
                ,"repository"
                ,"mapperwithview.ftl");
    }

    private void createMapperResource(MapperObject mapperObject){
        // TODO 创建文件夹
        String mapperFilePath = mapperObject.getFilePath();
        File file = new File(mapperFilePath);
        file.mkdirs();

        // TODO 创建mapper类
        HashMap root = new HashMap();
        mapperObject.setPackageName(mapperObject.getPackageName() + "."+mapperObject.getMapperObjName()+"Mapper");
        root.put("mapperObject",mapperObject);
        templateService.createTmpleFile(root
                ,mapperFilePath+"/"+mapperObject.getMapperObjName()+"Mapper.xml"
                ,"repository"
                ,"mapperxmlwithview.ftl");

    }

    /**
     * 获取mapperObject信息
     * @return
     */
    private MapperObject getMapperObject(DomainModel domainModel,BaseModelParameter modelParameter){
        MapperObject mapperObject = new MapperObject();
        mapperObject.setFilePath( modelParameter.getSourcesBasePath().concat(File.separator).concat("mapper"));
        mapperObject.setPackageName(modelParameter.getModelBasePakage().concat(".").concat("mapper"));
        mapperObject.setMapperObjName(domainModel.getModelName());

        for (Table table:domainModel.getTableList()) {
            table.setPackageName(String.format(ModelConstant.MODEL_BASE_PACKAGE.concat(".").concat("bo.%s.%s")
                    ,modelParameter.getProjectNamePrefix()
                    ,domainModel.getModelName().toLowerCase()
                    ,table.getTableProperty()));
            mapperObject.getMapperObjectItems().add(MapperObjectItem.createMapperObjectItem(table,modelParameter));
        }
        return mapperObject;
    }

    /**
     * 创建仓库层
     */
    private void createRepository(MapperObject mapperObject) {
        try {
            // TODO 创建文件夹
            String mapperFilePath = mapperObject.getFilePath();
            File file = new File(mapperFilePath);
            file.mkdirs();

            file = new File(mapperFilePath+"/imp");
            file.mkdirs();

            HashMap root = new HashMap();
            root.put("mapperObject", mapperObject);
            templateService.createTmpleFile(root
                    , mapperFilePath + "/" + mapperObject.getMapperObjName() + "Repository.java"
                    ,"repository"
                    , "repository.ftl");
            templateService.createTmpleFile(root
                    , mapperFilePath + "/imp/" + mapperObject.getMapperObjName()  + "RepositoryImp.java"
                    ,"repository"
                    , "repositoryimp.ftl");

        } catch (Exception e) {
            //throw new BusinessServiceException("20012", "mapper类型错误");
        }
    }

}
