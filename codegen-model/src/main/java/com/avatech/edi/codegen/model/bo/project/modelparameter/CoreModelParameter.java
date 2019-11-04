package com.avatech.edi.codegen.model.bo.project.modelparameter;

import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.codegen.data.ModelEnum;

/**
 * @author Fancy
 * @date 2019/10/30
 */
public class CoreModelParameter extends BaseModelParameter {

    public CoreModelParameter(ProjectStructure projectStructure) {
        super(projectStructure, ModelEnum.CORE);
    }
}
