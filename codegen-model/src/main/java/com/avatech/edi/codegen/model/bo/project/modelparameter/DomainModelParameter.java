package com.avatech.edi.codegen.model.bo.project.modelparameter;

import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.condegen.data.ModelEnum;

/**
 * @author Fancy
 * @date 2019/10/30
 */
public class DomainModelParameter extends BaseModelParameter {

    public DomainModelParameter(ProjectStructure projectStructure) {
        super(projectStructure, ModelEnum.MODEL);
    }
}
