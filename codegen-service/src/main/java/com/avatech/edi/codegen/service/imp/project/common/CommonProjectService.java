package com.avatech.edi.codegen.service.imp.project.common;

import com.avatech.edi.codegen.model.bo.BusinessObject;
import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.ProjectInitial;
import com.avatech.edi.codegen.service.IProjectService;
import com.avatech.edi.codegen.service.config.BusinessServiceException;
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
public class CommonProjectService implements IProjectService {

     /**
     * 创建公共模块
     * @param domainModels
     */
    @Override
    public void createProject(List<DomainModel> domainModels, ProjectInitial projectInitial) {
        // TODO 创建文件夹


        // TODO 创建POM文件


        // TODO 创建类文件
        createApplication(projectInitial);

    }

    private void createApplication(ProjectInitial projectInitial){
        String controllerFilePath = projectInitial.getProjectFilePath() + "/" + String.format(ProjectData.APPLICATION_URL,projectInitial.getProjectName(), projectInitial.getProjectName());
        String resourceFilePath = String.format("%s/%s.application/src/main/resources",projectInitial.getProjectFilePath(),projectInitial.getProjectName());
        File file = new File(controllerFilePath);
        file.mkdirs();
        file = new File(resourceFilePath);
        file.mkdirs();
        HashMap map = new HashMap();
        map.put("projectInitial",projectInitial);
        map.put("applicationname","EDI");
        createTmpleCode(map, controllerFilePath +"/" + projectInitial.getProjectName().toUpperCase()+ "Application.java","application.ftl");
        createTmpleCode(map,resourceFilePath +"/application.yml","resourceforapplication.ftl");
        //createTmpleCode(map,resourceFilePath +"/logback-spring.xml","resourceforlog.ftl");
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
