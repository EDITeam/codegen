package com.avatech.edi.codegen.service.project;

import com.avatech.edi.codegen.data.ModelEnum;
import com.avatech.edi.codegen.data.ServiceProtocolType;
import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.codegen.model.bo.project.modelparameter.*;
import com.avatech.edi.codegen.model.vo.APIDocVO;
import com.avatech.edi.codegen.service.TemplateService;
import com.avatech.edi.codegen.service.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.List;

/**
 * @author Fancy
 * @date 2019/10/30
 */
@Service
@Qualifier("projectFacotryService")
public class ProjectFactoryService implements IProjectService{

    @Autowired
    private SBOProjectBuilder sboProjectBuilder;

    @Autowired
    private SimpleProjectBuilder simpleProjectBuilder;

    @Autowired
    private DahubApplicationProjectBuilder dahubApplicationProjectBuilder;

    @Autowired
    private DahubServiceProjectBuilder dahubServiceProjectBuilder;


    @Autowired
    private CoreModelService coreModelService;

    @Autowired
    private DomainModelService domainModelService;


    @Autowired
    private ServiceModelService serviceModelService;

    @Autowired
    private RepositoryModelService repositoryModelService;

    @Autowired
    private TemplateService templateService;


    private void createProjectPOM(ProjectStructure projectStructure) {
        String pomFullFilePath = projectStructure.getProjectFilePath()
                .concat(File.separator)
                .concat(projectStructure.getProjectName())
                .concat(File.separator);
        File file = new File(pomFullFilePath);
        file.mkdirs();
        HashMap map = new HashMap();
        map.put("projectInfo", projectStructure);
        templateService.createTmpleFile(map,pomFullFilePath.concat("pom.xml"),"pom","project_pom.ftl");

    }

    private void createBaseFile(List<DomainModel> domainModels, ProjectStructure projectStructure){
        BaseModelParameter modelParameter = new CoreModelParameter(projectStructure);
        coreModelService.createPOM(modelParameter);
        coreModelService.createSourcesFile(domainModels,modelParameter);
        coreModelService.createTestsFile(domainModels,modelParameter);
        projectStructure.getModelNames().add(modelParameter.getModelName());


        modelParameter = new DomainModelParameter(projectStructure);
        modelParameter.setProjectStructure(projectStructure);
        domainModelService.createPOM(modelParameter);
        domainModelService.createSourcesFile(domainModels,modelParameter);
        domainModelService.createTestsFile(domainModels,modelParameter);
        domainModelService.createSqlResourcesFile(domainModels,modelParameter);
        projectStructure.getModelNames().add(modelParameter.getModelName());

        modelParameter = new ServiceModelParameter(projectStructure);
        serviceModelService.createPOM(modelParameter);
        serviceModelService.createSourcesFile(domainModels,modelParameter);
        serviceModelService.createTestsFile(domainModels,modelParameter);
        projectStructure.getModelNames().add(modelParameter.getModelName());



        modelParameter = new RepositoryModelParameter(projectStructure);
        repositoryModelService.createPOM(modelParameter);
        repositoryModelService.createSourcesFile(domainModels,modelParameter);
        repositoryModelService.createTestsFile(domainModels,modelParameter);
        projectStructure.getModelNames().add(modelParameter.getModelName());


    }

    private void createAPIDoc(List<DomainModel> domainModels,BaseModelParameter modelParameter) {
        String filePath = modelParameter.getProjectStructure().getProjectFilePath()
                .concat(File.separator)
                .concat(modelParameter.getProjectName())
                .concat(File.separator)
                .concat("api_doc")
                .concat(File.separator);

         new File(filePath).mkdirs();

        for (DomainModel model:domainModels) {
            APIDocVO apiDocVO = APIDocVO.createAPIDocVO(model,modelParameter.getProjectNamePrefix());
            HashMap map = new HashMap();
            map.put("apiDocVO", apiDocVO);
            templateService.createTmpleFile(map,filePath.concat(model.getModelName()).concat(".api"),"apidoc","api_doc.ftl");
        }

        HashMap map = new HashMap();
        map.put("projectName", modelParameter.getProjectName());
        templateService.createTmpleFile(map,filePath.concat("showdoc_api").concat(".sh"),"shell","showdoc_shell.ftl");

    }

    @Override
    public void createProject(List<DomainModel> domainModels, ProjectStructure projectStructure) {
        createBaseFile(domainModels, projectStructure);

        switch (projectStructure.getProjectType()) {
            case DAHUPT_APPLICATION:
                dahubApplicationProjectBuilder.createProject(domainModels, projectStructure);break;
            case DAHUPT_SERVICE:
                dahubServiceProjectBuilder.createProject(domainModels, projectStructure);break;
            case SBO_PROJECT:
                sboProjectBuilder.createProject(domainModels, projectStructure);break;
            case SIMPLE_SERVICE:
                simpleProjectBuilder.createProject(domainModels, projectStructure);break;
        }

        BaseModelParameter modelParameter = new DomainModelParameter(projectStructure);

        //调整项目名称
        projectStructure.setProjectName(modelParameter.getProjectName());
        createProjectPOM(projectStructure);

        modelParameter.setProjectStructure(projectStructure);
        createAPIDoc(domainModels,modelParameter);
    }
}
