package com.avatech.edi.codegen.service.imp.project.service;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.ProjectInitial;
import com.avatech.edi.codegen.model.bo.Table;
import com.avatech.edi.codegen.model.bo.mapperBO.MapperObject;
import com.avatech.edi.codegen.model.bo.mapperBO.MapperObjectItem;
import com.avatech.edi.codegen.service.IProjectService;
import com.avatech.edi.codegen.service.config.BusinessServiceException;
import com.avatech.edi.codegen.service.imp.project.mapper.MapperResourceService;
import com.avatech.edi.codegen.service.imp.project.mapper.MapperService;
import com.avatech.edi.condegen.data.Dictionary;
import com.avatech.edi.condegen.data.ProjectData;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;

@Service
public class ServiceProjectService implements IProjectService {



    /**
     * 创建服务模块
     * @param domainModels
     */
    @Override
    public void createProject(List<DomainModel> domainModels, ProjectInitial projectInitial) {
        // TODO 创建文件夹
        String serviceFilePath;
        if (projectInitial.getProjectType().equals(Dictionary.Single_Model)) {
            serviceFilePath = projectInitial.getProjectFilePath() + "/" + String.format(ProjectData.SINGLE_BASE_SERVICE_PROJECT_URL, projectInitial.getProjectName(), projectInitial.getProjectName());
        } else {
            serviceFilePath = projectInitial.getProjectFilePath() + "/" + String.format(ProjectData.MULTIPLE_BASE_SERVICE_PROJECT_URL, projectInitial.getProjectName(), projectInitial.getProjectName());
        }
        File file = new File(serviceFilePath);
        file.mkdirs();

        MapperObject mapperObject;
        HashMap root = new HashMap();
        for (DomainModel domainModel : domainModels) {
            mapperObject = new MapperObject();
            mapperObject.setFilePath(serviceFilePath);
            mapperObject.setMapperObjName(domainModel.getModelName());
            mapperObject.setPackageName(String.format("com.avatech.edi.%s", projectInitial.getProjectName()));
            root.put("mapperObject", mapperObject);
            createTmpleCode(root, serviceFilePath + "/" + mapperObject.getMapperObjName() + "Service.java", "service.ftl");
        }
    }

    private void createTmpleCode(HashMap map, String desFilePath, String templeCode){
        Configuration configuration = new Configuration(Configuration.getVersion());
        try{
            configuration.setDirectoryForTemplateLoading(new File(this.getClass().getClassLoader().getResource("projectTemple").getPath()));
            // 第五步：设置config的默认字符集。一般是utf-8
            configuration.setDefaultEncoding("utf-8");
            // 第六步：从config对象中获得模板对象。需要制定一个模板文件的名字。
            Template template = configuration.getTemplate(templeCode);
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
