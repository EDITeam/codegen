package com.avatech.edi.codegen.model.bo;

public class ProjectInitial {

    /**
     * 项目名称
     */
    private String projectName;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 项目类型 单模块、多模块
     */
    private Integer projectType;

    public Integer getProjectType(){
        return projectType;
    }

    public void setProjectType(Integer projectType){
        this.projectType = projectType;
    }

    /**
     * 服务协议
     */
    private Integer serviceProtocol;

    public Integer getServiceProtocol() {
        return serviceProtocol;
    }

    public void setServiceProtocol(Integer serviceProtocol) {
        this.serviceProtocol = serviceProtocol;
    }

    /**
     * 序列化格式
     */
    private Integer serializaFormat;

    public Integer getSerializaFormat() {
        return serializaFormat;
    }

    public void setSerializaFormat(Integer serializaFormat) {
        this.serializaFormat = serializaFormat;
    }

    /**
     * 数据库类型
     */
    private Integer dataBaseType;

    public Integer getDataBaseType() {
        return dataBaseType;
    }

    public void setDataBaseType(Integer dataBaseType) {
        this.dataBaseType = dataBaseType;
    }

    /**
     * ORM框架
     */
    private Integer ormType;

    public Integer getOrmType() {
        return ormType;
    }

    public void setOrmType(Integer ormType) {
        this.ormType = ormType;
    }

    /**
     * 数据结构文件路径
     */
    private String dataFilePath;

    public String getDataFilePath() {
        return dataFilePath;
    }

    public void setDataFilePath(String dataFilePath) {
        this.dataFilePath = dataFilePath;
    }

    /**
     * 项目路径
     */
    private String projectFilePath;

    public String getProjectFilePath() {
        return projectFilePath;
    }

    public void setProjectFilePath(String projectFilePath) {
        this.projectFilePath = projectFilePath;
    }

    @Override
    public String toString() {
        return "{" +
                "\"projectName\":\"" + projectName + '\"' +
                ",\"projectType\":\"" + projectType +'\"'+
                ",\"serviceProtocol\":\"" + serviceProtocol +'\"'+
                ",\"serializaFormat\":\"" + serializaFormat +'\"'+
                ",\"dataBaseType\":\"" + dataBaseType +'\"'+
                ",\"ormType\":\"" + ormType +'\"'+
                ",\"dataFilePath\":\"" + dataFilePath + '\"' +
                ",\"projectFilePath\":\"" + projectFilePath + '\"' +
                '}';
    }


}
