package com.avatech.edi.codegen.service.imp.project.repository;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.codegen.model.bo.Table;
import com.avatech.edi.codegen.model.bo.mapper.MapperObject;
import com.avatech.edi.codegen.model.bo.mapper.MapperObjectItem;
import com.avatech.edi.codegen.service.project.IProjectService;
import com.avatech.edi.codegen.service.imp.project.CommonService;
import com.avatech.edi.codegen.service.imp.project.mapper.MapperResourceService;
import com.avatech.edi.codegen.service.imp.project.mapper.MapperService;
import com.avatech.edi.condegen.data.ProjectData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.List;

@Service
public class RepositoryProjectService implements IProjectService {

    @Autowired
    private MapperResourceService mapperResourceService;

    @Autowired
    private MapperService mapperService;

    @Autowired
    private CommonService commonService;
    /**
     * 创建仓储模块
     * @param domainModels
     */
    @Override
    public void createProject(List<DomainModel> domainModels, ProjectStructure projectInitial) {
        MapperObject mapperObject;
        for (DomainModel domainModel : domainModels) {
            mapperObject = getMapperObject(domainModel, projectInitial);
            mapperObject.setMapperApplicationName(projectInitial.getProjectName());
            mapperResourceService.createMapperResource(mapperObject);
            mapperObject.setPackageName(String.format("com.avatech.edi.%s.mapper",projectInitial.getProjectName()));
            mapperService.createMapperProject(mapperObject);
            mapperObject.setFilePath(projectInitial.getProjectFilePath() + "/" + String.format(ProjectData.SINGLE_BASE_REPOSITORY_PROJECT_URL,projectInitial.getProjectName(), projectInitial.getProjectName()));
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

            file = new File(mapperFilePath+"/imp");
            file.mkdirs();

            HashMap root = new HashMap();
            root.put("mapperObject", mapperObject);
            commonService.createTmpleCode(root, mapperFilePath + "/" + mapperObject.getMapperObjName() + "Repository.java", "repository.ftl");
            commonService.createTmpleCode(root, mapperFilePath + "/imp/" + mapperObject.getMapperObjName()  + "RepositoryImp.java", "repositoryimp.ftl");

        } catch (Exception e) {
            //throw new BusinessServiceException("20012", "mapper类型错误");
        }
    }

    /**
     * 获取mapperObject信息
     * @return
     */
    private MapperObject getMapperObject(DomainModel domainModel,ProjectStructure projectInitial){
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


}
