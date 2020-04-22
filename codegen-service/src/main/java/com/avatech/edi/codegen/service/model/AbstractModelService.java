package com.avatech.edi.codegen.service.model;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.modelparameter.BaseModelParameter;
import com.avatech.edi.codegen.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @author Fancy
 * @date 2019/10/30
 */
public abstract class AbstractModelService {

    @Autowired
    private TemplateService templateService;

    private String pomTemplateName;

    public AbstractModelService(String pomTemplateName){
        this.pomTemplateName = pomTemplateName;
    }

    /**
     * 创建POM文件
     */
    public void createPOM(BaseModelParameter modelParameter){
        String pomFullFilePath = modelParameter.getRootPath().concat(File.separator);
        File file = new File(pomFullFilePath);
        file.mkdirs();
        HashMap map = new HashMap();
        map.put("modelInfo", modelParameter);
        map.put("projectInfo",modelParameter.getProjectStructure());
        templateService.createTmpleFile(map,pomFullFilePath.concat("pom.xml"),"pom",pomTemplateName);
    }

    /**
     * 创建模块资源文件
     * @param domainModels
     * @param modelParameter
     */
    public void createSourcesFile(List<DomainModel> domainModels,BaseModelParameter modelParameter) throws IOException {
        //创建资源文件夹
        String sourcesFullFilePath = modelParameter.getSourcesBasePath();
        File file = new File(sourcesFullFilePath);
        file.mkdirs();
        file = new File(sourcesFullFilePath,".gitkeep");
        file.createNewFile();
    }


    /**
     * 创建模块测试文件
     * @param domainModels
     * @param modelParameter
     */
    public void createTestsFile(List<DomainModel> domainModels,BaseModelParameter modelParameter) throws IOException {
        String testsFullFilePath = modelParameter.getTestsBasePath();
        File file = new File(testsFullFilePath);
        file.mkdirs();
        file = new File(testsFullFilePath,".gitkeep");
        file.createNewFile();
    }


}
