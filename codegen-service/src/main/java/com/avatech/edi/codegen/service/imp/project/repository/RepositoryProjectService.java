package com.avatech.edi.codegen.service.imp.project.repository;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.ProjectInitial;
import com.avatech.edi.codegen.model.bo.Table;
import com.avatech.edi.codegen.model.bo.mapperBO.MapperObject;
import com.avatech.edi.codegen.model.bo.mapperBO.MapperObjectItem;
import com.avatech.edi.codegen.service.IProjectService;
import com.avatech.edi.codegen.service.config.BusinessServiceException;
import com.avatech.edi.codegen.service.imp.project.mapper.MapperResourceService;
import com.avatech.edi.codegen.service.imp.project.mapper.MapperService;
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
public class RepositoryProjectService implements IProjectService {

    @Autowired
    private MapperResourceService mapperResourceService;

    @Autowired
    private MapperService mapperService;

    /**
     * 创建仓储模块
     * @param domainModels
     */
    @Override
    public void createProject(List<DomainModel> domainModels, ProjectInitial projectInitial) {
        mapperService = new MapperService();
        mapperResourceService = new MapperResourceService();
        MapperObject mapperObject;
        for (DomainModel domainModel : domainModels) {
            mapperObject = getMapperObject(domainModel, projectInitial);
            mapperResourceService.createMapperResource(mapperObject);
            mapperService.createMapperProject(mapperObject);
            mapperObject.setFilePath( projectInitial.getProjectFilePath() + String.format(ProjectData.SINGLE_BASE_REPOSITORY_PROJECT_URL,projectInitial.getProjectName(), projectInitial.getProjectName()));
            mapperObject.setPackageName(String.format("com.avatech.edi.%s.repository",projectInitial.getProjectName()));
            this.createRepository(mapperObject);
        }
    }

    /**
     * 创建仓库层
     */
    private void createRepository(MapperObject mapperObject) {
        try {
            // TODO 创建文件夹
            String mapperFilePath = mapperObject.getFilePath();
            File file = new File(mapperFilePath);
            file.mkdirs();

            // TODO 创建mapper类
            HashMap root = new HashMap();
            root.put("mapperObject", mapperObject);
            createTmpleCode(root, mapperFilePath + "/" + mapperObject.getMapperObjName() + "Repository.java", "repository.ftl");
            createTmpleCode(root, mapperFilePath + "/" + mapperObject.getMapperObjName() + "RepositoryImp.java", "repositoryimp.ftl");

        } catch (Exception e) {
            throw new BusinessServiceException("20012", "mapper类型错误");
        }
    }

    /**
     * 获取mapperObject信息
     * @return
     */
    private MapperObject getMapperObject(DomainModel domainModel,ProjectInitial projectInitial){
        MapperObject mapperObject = new MapperObject();
        mapperObject.setFilePath( projectInitial.getProjectFilePath() +"/" + String.format(ProjectData.SINGLE_BASE_MAPPER_PROJECT_URL,projectInitial.getProjectName(), projectInitial.getProjectName()));
        mapperObject.setPackageName(String.format("com.avatech.edi.%s.mapper",projectInitial.getProjectName()));
        mapperObject.setMapperObjName(domainModel.getModelName());

        for (Table table:domainModel.getTableList()) {
            table.setPackageName(String.format("com.avatech.edi.%s.model.bo.%s.%s",projectInitial.getProjectName(),domainModel.getModelName().toLowerCase(),table.getTableProperty()));
            mapperObject.getMapperObjectItems().add(MapperObjectItem.createMapperObjectItem(table,projectInitial));
        }
        return mapperObject;
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
