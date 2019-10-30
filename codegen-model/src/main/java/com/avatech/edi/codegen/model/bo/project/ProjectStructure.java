package com.avatech.edi.codegen.model.bo.projectbo;

import com.avatech.edi.condegen.data.DataBaseType;
import com.avatech.edi.condegen.data.ProjectType;

/**
 * 项目结构
 */
public class ProjectStructure {

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目类型 单模块、多模块
     */
    private ProjectType projectType;

    /**
     * 服务协议
     */
    private Integer serviceProtocol;

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






}
