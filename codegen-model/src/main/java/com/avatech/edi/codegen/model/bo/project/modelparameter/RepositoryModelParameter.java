package com.avatech.edi.codegen.model.bo.project.modelparameter;

import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.condegen.data.ModelEnum;

/**
 * @author Fancy
 * @date 2019/10/31
 */
public class RepositoryModelParameter extends BaseModelParameter {

    public RepositoryModelParameter(ProjectStructure projectStructure) {
        super(projectStructure, ModelEnum.REPOSITORY);
    }
}
