package com.avatech.edi.codegen.service.imp.project;

import com.avatech.edi.codegen.service.config.BusinessServiceException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;


@Component
public class CommonService {

    public void createTmpleCode(HashMap map,String desFilePath,String templeCode){
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
