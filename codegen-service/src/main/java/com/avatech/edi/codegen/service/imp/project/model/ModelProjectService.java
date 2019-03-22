package com.avatech.edi.codegen.service.imp.project.model;

import com.avatech.edi.codegen.model.bo.BusinessObjectMap;
import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.ProjectInitial;
import com.avatech.edi.codegen.model.bo.Table;
import com.avatech.edi.codegen.service.IProjectService;
import com.avatech.edi.codegen.service.config.BusinessServiceException;
import com.avatech.edi.codegen.service.imp.project.CommonService;
import com.avatech.edi.condegen.common.StringUtils;
import com.avatech.edi.condegen.data.Dictionary;
import com.avatech.edi.condegen.data.ProjectData;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;


@Service
public class ModelProjectService implements IProjectService {

    @Autowired
    private CommonService commonService;

    /**
     * 创建BO项目
     * @param domainModels
     */
    @Override
    public void createProject(List<DomainModel> domainModels, ProjectInitial projectInitial) {
        try {
            if(projectInitial.getProjectType() == null){
                throw new BusinessServiceException("2001", "配置错误：无效的项目类型");
            }
            if (projectInitial.getProjectType().equals(Dictionary.Single_Model)) {
                // 单模块创建文件夹
                createSingleProject(domainModels,projectInitial);

            } else if (projectInitial.getProjectType().equals(Dictionary.Multiple_Model)) {
                // 创建模块
                // TODO 创建POM文件
                createMutileProject(domainModels,projectInitial);

            } else {
                throw new BusinessServiceException("2001", "配置错误：无效的项目类型");
            }
        } catch (Exception e) {
            throw new BusinessServiceException("2001", "创建Model项目失败");
        }

    }


    /**
     * 创建但模块项目
     * @param domainModels
     * @param projectInitial
     */
    private void createSingleProject(List<DomainModel> domainModels, ProjectInitial projectInitial) {
        try {
            // TODO 创建文件夹
            String boPackage;
            // 如果文件夹路径不存在，则新建文件夹
            String modelProjectFilePath = projectInitial.getProjectFilePath() + "/" + String.format(ProjectData.SINGLE_BASE_MODEL_PROJECT_URL
                    , projectInitial.getProjectName()
                    , projectInitial.getProjectName());
            File file = new File(modelProjectFilePath);
            file.mkdirs();

            // TODO 创建POM文件


            // TODO 创建类文件
            String boFilePath = modelProjectFilePath + String.format("/bo", projectInitial.getProjectName());
            file = new File(boFilePath);
            file.mkdirs();
            HashMap root;
            for (DomainModel domain : domainModels) {
                if (!StringUtils.isEmpty(domain.getModelName())) {
                    boPackage = boFilePath + "/" + domain.getModelName().toLowerCase();
                    new File(boPackage).mkdirs();
                    // TODO 获取BO模板
                    for (Table table : domain.getTableList()) {
                        table.setPackageName(String.format("com.avatech.edi.%s.model.bo." + table.getTableProperty(), projectInitial.getProjectName()));
                        root = new HashMap();
                        root.put("table",getTableMap(table,domain.getBusinessObjectMaps()));
                        //commonService.createTmpleCode(root,boPackage+"/"+table.getTableProperty()+".java","projectTemple");
                        createTmpleCode(root,boPackage+"/"+table.getTableProperty()+".java","projectTemple");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessServiceException("2001", "创建Model模块失败");
        }
    }



    /**
     * 创建多模块项目
     * @param domainModels
     * @param projectInitial
     */
    private void createMutileProject(List<DomainModel> domainModels, ProjectInitial projectInitial) {
        try {
            // TODO 创建文件夹
            // 如果文件夹路径不存在，则新建文件夹
            String modelProjectFilePath = projectInitial.getProjectFilePath() + "/" + String.format(ProjectData.SINGLE_BASE_MODEL_PROJECT_URL
                    , projectInitial.getProjectName()
                    , projectInitial.getProjectName());
            File file = new File(modelProjectFilePath);
            file.mkdirs();

            // TODO 创建POM文件


            // TODO 创建类文件
            String boFilePath = modelProjectFilePath + String.format("/src/java/com/avatech/cn/%s/model/bo", projectInitial.getProjectName());
            file = new File(boFilePath);
            file.mkdirs();
            for (DomainModel domain : domainModels) {
                if (!StringUtils.isEmpty(domain.getModelName())) {
                    new File(boFilePath + "/" + domain.getModelName().toLowerCase()).mkdirs();
                }
                // TODO 获取BO模板


                for (Table table : domain.getTableList()) {
                    table.setPackageName(String.format("com/avatech/edi/%s/model/bo/" + table.getTableProperty(), projectInitial.getProjectName()));

                }
            }

        } catch (Exception e) {
            throw new BusinessServiceException("2001", "创建Model项目失败");
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

    private void createTmpleCode(HashMap map,String desFilePath,String templeCode){
        Configuration configuration = new Configuration(Configuration.getVersion());
        try{
            configuration.setDirectoryForTemplateLoading(new File(this.getClass().getClassLoader().getResource(templeCode).getPath()));
            // 第五步：设置config的默认字符集。一般是utf-8
            configuration.setDefaultEncoding("utf-8");
            // 第六步：从config对象中获得模板对象。需要制定一个模板文件的名字。
            Template template = configuration.getTemplate("model.ftl");
            // 第八步：创建一个Writer对象，指定生成的文件保存的路径及文件名。
            Writer out = new FileWriter(new File(desFilePath));
            // 第九步：调用模板对象的process方法生成静态文件。需要两个参数数据集和writer对象。
            template.process(map, out);
            // 第十步：关闭writer对象。
            out.flush();
            out.close();
        }catch (Exception e){
            throw new BusinessServiceException("2002",e.getMessage());
        }
    }
}
