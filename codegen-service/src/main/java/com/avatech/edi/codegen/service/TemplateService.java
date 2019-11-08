package com.avatech.edi.codegen.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;

/**
 * @author Fancy
 * @date 2019/10/31
 */
@Component
public class TemplateService {
    private static final Logger logger = LoggerFactory.getLogger(TemplateService.class);

    public void createTmpleFile(HashMap map, String desFilePath,String templateFile, String templateCode){
        Configuration configuration = new Configuration(Configuration.getVersion());
        try{
            configuration.setDirectoryForTemplateLoading(new File(this.getClass().getClassLoader().getResource(String.format("projectTemple/%s",templateFile)).getPath()));
            // 第五步：设置config的默认字符集。一般是utf-8
            configuration.setDefaultEncoding("utf-8");
            // 第六步：从config对象中获得模板对象。需要制定一个模板文件的名字。
            Template template = configuration.getTemplate(templateCode);
            // 第八步：创建一个Writer对象，指定生成的文件保存的路径及文件名。
            Writer out = new FileWriter(new File(desFilePath));
            logger.info("template file created path :{}",desFilePath);
            // 第九步：调用模板对象的process方法生成静态文件。需要两个参数数据集和writer对象。
            template.process(map, out);
            // 第十步：关闭writer对象。
            out.flush();
            out.close();
        }catch (Exception e){
            logger.error("create template file error:",e);
        }
    }
}
