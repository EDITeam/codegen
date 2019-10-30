package com.avatech.edi.codegen.model.bo.project.modelparameter;

import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.condegen.data.ModelEnum;

/**
 * @author Fancy
 * @date 2019/10/30
 */
public class StarterModelParameter  extends BaseModelParameter {

    public StarterModelParameter(ProjectStructure projectStructure) {
        super(projectStructure, ModelEnum.STARTER);
    }
}
