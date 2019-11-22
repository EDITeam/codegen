package com.avatech.edi.codegen.model.bo.project.modelparameter;

import com.avatech.edi.codegen.data.ModelEnum;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;

/**
 * @author Fancy
 * @date 2019/11/22
 */
public class ConsumerModelParameter extends BaseModelParameter {
    public ConsumerModelParameter(ProjectStructure projectStructure) {
        super(projectStructure, ModelEnum.CONSUMER);
    }
}
