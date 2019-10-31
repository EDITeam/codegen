package com.avatech.edi.codegen.model.bo.project;

import java.io.File;

/**
 * @author Fancy
 * @date 2019/10/30
 */
public class BaseProjectParameter {

    public BaseProjectParameter(ProjectStructure projectStructure) {
        init(projectStructure);
    }

    /**
     * 根目录
     */
    private String rootPath;

    private String projectName;

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    private void init(ProjectStructure projectStructure){
        setRootPath(projectStructure.getProjectFilePath() + File.separator + projectStructure.getProjectName().toLowerCase());
        setProjectName(projectStructure.getProjectName().toLowerCase().concat(getProjectNameSuffix(projectStructure)));
    }

    private String getProjectNameSuffix(ProjectStructure projectStructure) {
        switch (projectStructure.getProjectType()) {
            case DAHUB_APPLICATION:
                return "_application";
            default:
                return "_service";
        }
    }

    public String getProjectNamePrefix() {
        return this.getProjectName().split("_")[0];
    }
}
