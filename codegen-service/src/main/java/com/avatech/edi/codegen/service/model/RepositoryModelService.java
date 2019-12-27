package com.avatech.edi.codegen.service.model;

import com.avatech.edi.codegen.data.DataBaseType;
import com.avatech.edi.codegen.exception.BusinessServiceException;
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
import org.thymeleaf.util.StringUtils;

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
                createMapperResource(mapperObject,modelParameter.getProjectStructure().getDataBaseType());
                mapperObject.setPackageName(modelParameter.getModelBasePakage().concat(".").concat("mapper"));
                createMapper(mapperObject);
                mapperObject.setFilePath(modelParameter.getSourcesBasePath());
                mapperObject.setPackageName(modelParameter.getModelBasePakage());
                createRepository(domainModel, mapperObject);
            }

            createTransactionMapper(modelParameter);

            // create resources
            String resourceFile = modelParameter.getRootPath()
                    .concat(File.separator)
                    .concat(ModelConstant.MODEL_RESOURCES_BASE_PATH.replace(".",File.separator));
            new File(resourceFile).mkdir();

        } catch (IOException e) {
            logger.error("创建资源文件异常:",e);
        }
    }

    private void createTransactionMapper(BaseModelParameter modelParameter) {
        String filePath = modelParameter.getSourcesBasePath().concat(File.separator).concat("mapper");
        HashMap root = new HashMap();
        root.put("projectName",modelParameter.getProjectNamePrefix());
        templateService.createTmpleFile(root
                ,filePath+"/TransactionNoticeMapper.java"
                ,"repository"
                ,"transaction_mapper.ftl");
        templateService.createTmpleFile(root
                ,filePath+"/TransactionNoticeMapper.xml"
                ,"repository"
                ,"transaction_xml.ftl");
    }

    @Override
    public void createTestsFile(List<DomainModel> domainModels, BaseModelParameter modelParameter) {
        try {
            super.createTestsFile(domainModels,modelParameter);
            HashMap root = new HashMap();
            root.put("projectName",modelParameter.getProjectNamePrefix());

            String filePath = modelParameter.getTestsBasePath();
            templateService.createTmpleFile(root
                    ,filePath+"/"+ StringUtils.capitalize(modelParameter.getProjectNamePrefix()) +"RepositoryApplication.java"
                    ,"repository"
                    ,"unit_application.ftl");

            MapperObject mapperObject;
            for (DomainModel domainModel : domainModels) {
                mapperObject = getMapperObject(domainModel, modelParameter);
                mapperObject.setMapperApplicationName(modelParameter.getProjectNamePrefix());
                mapperObject.setPackageName(modelParameter.getModelBasePakage().concat(".").concat("mapper"));
                mapperObject.setFilePath(modelParameter.getSourcesBasePath());
                mapperObject.setPackageName(modelParameter.getModelBasePakage());
                createRepository(domainModel, mapperObject);
                root = new HashMap();
                root.put("mapperObject", mapperObject);
                root.put("modelObject",domainModel);
                templateService.createTmpleFile(root
                        , modelParameter.getTestsBasePath() + "/" + StringUtils.capitalize(mapperObject.getMapperObjName()) + "RepositoryImpTest.java"
                        ,"repository"
                        , "unit_test.ftl");
            }
            templateService.createTmpleFile(root
                    , modelParameter.getSourcesBasePath()
                            .concat(File.separator)
                            .concat("AbastractTransactionService.java")
                    ,"repository"
                    , "AbastractTransactionService.ftl");
            // create resources
            String resourceFile = modelParameter.getRootPath()
                    .concat(File.separator)
                    .concat(ModelConstant.MODEL_TESTS_RESOURCES_BASE_PATH.replace(".",File.separator));
            new File(resourceFile).mkdir();

            root.put("projectInfo",modelParameter.getProjectStructure());
            templateService.createTmpleFile(root
                    ,resourceFile.concat(File.separator).concat("application.yml")
                    ,"repository"
                    ,"application_resource.ftl");

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

    private void createMapperResource(MapperObject mapperObject, DataBaseType dataBaseType){
        // TODO 创建文件夹
        String mapperFilePath = mapperObject.getFilePath();
        File file = new File(mapperFilePath);
        file.mkdirs();

        // TODO 创建mapper类
        HashMap root = new HashMap();

        if(dataBaseType.equals(DataBaseType.MYSQL)){
            root.put("quotation","`");
        }else{
            root.put("quotation",'"');
        }
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
    private void createRepository(DomainModel domainModel,MapperObject mapperObject) {
        try {
            // TODO 创建文件夹
            String mapperFilePath = mapperObject.getFilePath();
            File file = new File(mapperFilePath);
            file.mkdirs();

            file = new File(mapperFilePath+"/imp");
            file.mkdirs();

            HashMap root = new HashMap();
            root.put("mapperObject", mapperObject);
            root.put("modelObject",domainModel);
            templateService.createTmpleFile(root
                    , mapperFilePath + "/" + mapperObject.getMapperObjName() + "Repository.java"
                    ,"repository"
                    , "repository.ftl");
            root.put("businessObjectType",getBusinessObjectType(domainModel));
            templateService.createTmpleFile(root
                    , mapperFilePath + "/imp/" + mapperObject.getMapperObjName()  + "RepositoryImp.java"
                    ,"repository"
                    , "repositoryimp.ftl");
        } catch (Exception e) {
            logger.error("create repository layer error:",e);
            throw new BusinessServiceException("20012", "mapper类型错误");
        }
    }

    private String getBusinessObjectType(DomainModel domainModel){
        if(domainModel.getBusinessObjectMaps()!= null &&
                domainModel.getBusinessObjectMaps().size() > 0){
            return domainModel.getBusinessObjectMaps().get(0).getObjectType();
        }else {
            return domainModel.getTableList().get(0).getTableType().getName();
        }
    }
}
