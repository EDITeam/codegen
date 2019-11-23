package com.avatech.edi.codegen.model.bo.project;

import com.avatech.edi.codegen.data.DataBaseType;
import com.avatech.edi.codegen.data.ModelEnum;
import com.avatech.edi.codegen.data.ProjectType;
import com.avatech.edi.codegen.data.ServiceProtocolType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目结构
 */
public class ProjectStructure {

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目类型
     */
    private ProjectType projectType;

    /**
     * 服务协议
     */
    private ServiceProtocolType serviceProtocol;

    /**
     * 序列化格式
     */
    private Integer serializaFormat;

    /**
     * 数据库类型
     */
    private DataBaseType dataBaseType;

    /**
     * 数据结构文件路径
     */
    private String dataFilePath;

    /**
     * 项目存放路径
     */
    private String projectFilePath;

    @JsonIgnore
    private List<String> modelNames;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    public ServiceProtocolType getServiceProtocol() {
        return serviceProtocol;
    }

    public void setServiceProtocol(ServiceProtocolType serviceProtocol) {
        this.serviceProtocol = serviceProtocol;
    }

    public Integer getSerializaFormat() {
        return serializaFormat;
    }

    public void setSerializaFormat(Integer serializaFormat) {
        this.serializaFormat = serializaFormat;
    }

    public DataBaseType getDataBaseType() {
        return dataBaseType;
    }

    public void setDataBaseType(DataBaseType dataBaseType) {
        this.dataBaseType = dataBaseType;
    }

    public String getDataFilePath() {
        return dataFilePath;
    }

    public void setDataFilePath(String dataFilePath) {
        this.dataFilePath = dataFilePath;
    }

    public String getProjectFilePath() {
        return projectFilePath;
    }

    public void setProjectFilePath(String projectFilePath) {
        this.projectFilePath = projectFilePath;
    }

    public List<String> getModelNames() {
        if(modelNames == null){
            modelNames = new ArrayList<>();
        }
        return modelNames;
    }

    public void setModelNames(List<String> modelNames) {
        this.modelNames = modelNames;
    }

    public String getServiceName(){
        if(this.projectType.equals(ProjectType.DAHUPT_APPLICATION)){
            return "application";
        }else {
            return "service";
        }
    }
}
