package com.avatech.edi.codegen.controller;

import com.avatech.edi.codegen.common.ZipUtils;
import com.avatech.edi.codegen.data.DataBaseType;
import com.avatech.edi.codegen.data.FileSettings;
import com.avatech.edi.codegen.data.ServiceProtocolType;
import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.codegen.data.ProjectType;
import com.avatech.edi.codegen.service.IDataStructureFileService;
import com.avatech.edi.codegen.service.project.IProjectService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author Fancy
 * @date 2019/11/1
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    private IDataStructureFileService dataStructureFileService;

    @Autowired
    @Qualifier("projectFacotryService")
    private IProjectService projectService;


    @ModelAttribute("allTypes")
    public List<ProjectType> populateTypes() {
        return Arrays.asList(ProjectType.ALL);
    }

    @ModelAttribute("allProtocol")
    public List<ServiceProtocolType> populateProtocol() {
        return Arrays.asList(ServiceProtocolType.ALL);
    }

    @ModelAttribute("allDataBase")
    public List<DataBaseType> populateDataBase() {
        return Arrays.asList(DataBaseType.ALL);
    }

    @RequestMapping(method = {RequestMethod.GET})
    public String editProjectStructure(ModelMap map ) {
        map.put("project", new ProjectStructure());
        return "create_project";

    }

    @RequestMapping(method = RequestMethod.POST)
    public String createProject(ModelMap map
            , ProjectStructure projectStructure
            ,HttpServletRequest request
            , HttpServletResponse response){
        //
        if(StringUtils.isEmpty(projectStructure.getProjectName())){
            map.put("message","项目名称为空");
        }else if(StringUtils.isEmpty(projectStructure.getDataFilePath())){
            map.put("message","未上传数据结构文件");
        }else {
            // 项目标识
            String projectId = projectStructure.getDataFilePath();

            //设置数据结构路径
            String filePath = FileSettings.DATASTRUCTURE_FILE_PATH  + "/" + projectStructure.getDataFilePath();
            projectStructure.setDataFilePath(filePath);

            //设置项目生成后存放路径
            String projectFilePath = FileSettings.PROJECT_FILE_PATH + "/" + projectId;
            projectStructure.setProjectFilePath(projectFilePath);

            try{
                List<DomainModel> domainModels = dataStructureFileService.readerDataStructureFile(projectStructure.getDataFilePath());
                projectService.createProject(domainModels, projectStructure);

                String projectFullFilePath = projectFilePath + "/" + projectStructure.getProjectName();

                // 压缩项目文件夹
                FileOutputStream fos1 = new FileOutputStream(new File(projectFullFilePath + ".zip"));
                ZipUtils.toZip(projectFullFilePath, fos1, true);

                // 下载项目代码
                downLoadFile(request,response,projectFullFilePath + ".zip");

            }catch (Exception e){
                map.put("message",e.getMessage());
                logger.error("create project error:",e);
            }
        }
        map.put("project", projectStructure);
        return "create_project";
    }

    private void downLoadFile(HttpServletRequest request, HttpServletResponse response,String fileFullPath) {
        response.setCharacterEncoding(request.getCharacterEncoding());
        response.setContentType("application/octet-stream");
        FileInputStream fis = null;
        try {
            File file = new File(fileFullPath);

            fis = new FileInputStream(file);
            response.setHeader("Content-Disposition", "attachment; filename="+file.getName());
            IOUtils.copy(fis,response.getOutputStream());
            response.flushBuffer();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
