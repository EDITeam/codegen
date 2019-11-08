package com.avatech.edi.codegen.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.Writer;
import java.net.URL;
import java.util.HashMap;

/**
 * @author Fancy
 * @date 2019/10/31
 */
@Component
public class TemplateService {
    private static final Logger logger = LoggerFactory.getLogger(TemplateService.class);

    /**
     *
     * @param map 传递给模板变量的参数
     * @param desFilePath 生成文件的路径
     * @param templateFile 模板文件的父文件夹
     * @param templateCode 模板名称
     */
    public void createTmpleFile(HashMap map, String desFilePath,String templateFile, String templateCode){

        try{
            Configuration configuration = new Configuration(Configuration.getVersion());
            /**
             * 打成jar包后无法通过这种方式获取路径，因为最后获取的路径可能是这样：
             * codegen/codegen-starter/target/codegen.application.server.jar!/BOOT-INF/lib/codegen-service-0.0.1-SNAPSHOT.jar!/projectTemple/repository
             **/

            configuration.setClassLoaderForTemplateLoading(ClassLoader.getSystemClassLoader(),String.format("projectTemple/%s",templateFile));
            logger.info(ClassLoader.getSystemClassLoader().toString());
            //configuratio
            //configuration.setClassForTemplateLoading(ClassLoader.getSystemClassLoader(),String.format("projectTemple/%s",templateFile));
            //configuration.get
            //configuration.setDirectoryForTemplateLoading(new File(this.getClass().getResource(String.format("projectTemple/%s",templateFile)).getPath()));
            // 第五步：设置config的默认字符集。一般是utf-8
            configuration.setDefaultEncoding("utf-8");
            // 第六步：从config对象中获得模板对象。需要制定一个模板文件的名字。
            Template template = configuration.getTemplate(templateCode);

            //new Template()
            // 第八步：创建一个Writer对象，指定生成的文件保存的路径及文件名。
            Writer out = new FileWriter(new File(desFilePath));
            //logger.info("template file created path :{}",desFilePath);
            // 第九步：调用模板对象的process方法生成静态文件。需要两个参数数据集和writer对象。
            template.process(map, out);
            // 第十步：关闭writer对象。
            out.flush();
            out.close();
        }catch (Exception e){
           // logger.error("create template file error:",e);
        }
    }
}
