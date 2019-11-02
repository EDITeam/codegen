package com.avatech.edi.codegen.controller;

import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.condegen.data.ProjectType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Fancy
 * @date 2019/11/1
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
    public String createProject(ModelMap map, ProjectStructure project){
        //单个数据
        ProjectStructure projectStructure = new ProjectStructure();
        ProjectType[] projectTypes = ProjectType.values();
        //ProjectType.DAHUB_APPLICATION.getKey()
        for (ProjectType item:projectTypes) {
            item.getKey();
        }
        //projectStructure.setProjectType(ProjectType.SBO_PROJECT);
        map.put("projecttype",projectTypes);
        map.put("project", projectStructure);
        return "create_project";
    }

    /**
     * 创建项目
     */
    public void createProject(){

    }

}
