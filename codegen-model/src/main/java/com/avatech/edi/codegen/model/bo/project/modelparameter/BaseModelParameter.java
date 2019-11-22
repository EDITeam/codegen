package com.avatech.edi.codegen.model.bo.project.modelparameter;

import com.avatech.edi.codegen.model.bo.project.BaseProjectParameter;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.codegen.data.ModelConstant;
import com.avatech.edi.codegen.data.ModelEnum;
import com.avatech.edi.codegen.exception.BusinessServiceException;

import java.io.File;

/**
 * @author Fancy
 * @date 2019/10/30
 */
public class BaseModelParameter extends BaseProjectParameter {

    public BaseModelParameter(ProjectStructure projectStructure, ModelEnum modelEnum){
        super(projectStructure);
        init(projectStructure,modelEnum);

    }

    /**
     * 模块名称
     */
    private String modelName;

    /**
     * 模块基础包
     * com.avatech.dahub.${appname}.${modelname}
     */
    private String modelBasePakage;

    /**
     * 模块sources基础路径
     *
     */
    private String sourcesBasePath;

    /**
     * 模块tests基础路径
     *
     */
    private String testsBasePath;


    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelBasePakage() {
        return modelBasePakage;
    }

    public void setModelBasePakage(String modelPakage) {
        this.modelBasePakage = modelPakage;
    }

    public String getSourcesBasePath() {
        return sourcesBasePath;
    }

    public void setSourcesBasePath(String sourcesBasePath) {
        this.sourcesBasePath = sourcesBasePath;
    }

    public String getTestsBasePath() {
        return testsBasePath;
    }

    public void setTestsBasePath(String testsBasePath) {
        this.testsBasePath = testsBasePath;
    }

    private void init(ProjectStructure projectStructure, ModelEnum modelEnum) {

        String modelName = String.format(getModelName(modelEnum), getProjectName().toLowerCase());
        setModelName(modelName);

        String modelPath = projectStructure.getProjectFilePath()
                + File.separator
                + this.getProjectName().toLowerCase()
                + File.separator
                + this.modelName;
        // 设置模块路径
        setRootPath(modelPath);

        String modelBasePakage = String.format(getModelPackage(modelEnum), projectStructure.getProjectName().toLowerCase());
        String souceBasePath = getRootPath()
                + File.separator
                + ModelConstant.MODEL_SOURCES_BASE_PATH
                + File.separator + modelBasePakage;
        String testsBasePath = getRootPath()
                + File.separator
                + ModelConstant.MODEL_TESTS_BASE_PATH
                + File.separator
                + modelBasePakage;


        // 设置基础包名称
        setModelBasePakage(modelBasePakage);

        // 设置文件路径
        setSourcesBasePath(souceBasePath.replace('.',File.separatorChar));
        setTestsBasePath(testsBasePath.replace('.',File.separatorChar));

    }

    private String getModelName(ModelEnum modelEnum){
        switch (modelEnum) {
            case CORE:
                return ModelConstant.CORE_MODEL_NAME;
            case MODEL:
                return ModelConstant.DOMAIN_MODEL_NAME;
            case SERVICE:
                return ModelConstant.SERVICE_MODEL_NAME;
            case CLIENT:
                return ModelConstant.FEIGNCLIENT_MODEL_NAME;
            case STARTER:
                return ModelConstant.STARTER_MODEL_NAME;
            case API:
                return ModelConstant.API_MODEL_NAME;
            case REPOSITORY:
                return ModelConstant.REPOSITORY_MODEL_NAME;
            case PROVIDER:
                return ModelConstant.PROVIDER_MODEL_NAME;
            case CONSUMER:
                return ModelConstant.CONSUMER_MODEL_NAME;
            default:
                throw new BusinessServiceException("1", "not exists model name");
        }
    }

    private String getModelPackage(ModelEnum modelEnum){
        switch (modelEnum) {
            case CORE:
                return ModelConstant.CORE_BASE_PACKAGE;
            case MODEL:
                return ModelConstant.MODEL_BASE_PACKAGE;
            case SERVICE:
                return ModelConstant.SERVICE_BASE_PACKAGE;
            case CLIENT:
                return ModelConstant.FEIGNCLIENT_BASE_PACKAGE;
            case STARTER:
                return ModelConstant.STARTER_BASE_PACKAGE;
            case API:
                return ModelConstant.API_BASE_PACKAGE;
            case REPOSITORY:
                return ModelConstant.REPOSITORY_BASE_PACKAGE;
            case PROVIDER:
                return ModelConstant.PROVIDER_BASE_PACKAGE;
            case CONSUMER:
                return ModelConstant.CONSUMER_BASE_PACKAGE;
            default:
                throw new BusinessServiceException("1", "not exists model name");
        }
    }
}
