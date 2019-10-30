package com.avatech.edi.codegen.model.bo.project;

import java.io.File;

/**
 * @author Fancy
 * @date 2019/10/30
 */
public class BaseProjectParameter {

    public BaseProjectParameter(ProjectStructure projectStructure) {
        setRootPath(projectStructure.getProjectFilePath() + File.separator + projectStructure.getProjectName());
    }

    /**
     * 根目录
     */
    private String rootPath;

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }
}
