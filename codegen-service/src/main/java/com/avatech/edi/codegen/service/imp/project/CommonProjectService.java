package com.avatech.edi.codegen.service.imp.project;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.ProjectInitial;
import com.avatech.edi.codegen.service.IProjectService;
import org.springframework.stereotype.Service;

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


    }

}
