package com.avatech.edi.codegen.model.bo.project.modelparameter;

import com.avatech.edi.codegen.data.ModelEnum;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;

/**
 * @author Fancy
 * @date 2019/11/22
 */
public class ProviderModelParameter extends BaseModelParameter{
    public ProviderModelParameter(ProjectStructure projectStructure) {
        super(projectStructure, ModelEnum.PROVIDER);
    }
}
