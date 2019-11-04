package com.avatech.edi.codegen.model.bo.project.modelparameter;

import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.codegen.data.ModelEnum;

/**
 * @author Fancy
 * @date 2019/10/30
 */
public class ServiceModelParameter  extends BaseModelParameter {

    public ServiceModelParameter(ProjectStructure projectStructure) {
        super(projectStructure, ModelEnum.SERVICE);
    }
}
