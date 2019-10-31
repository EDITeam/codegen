package com.avatech.edi.codegen.model.bo.project.modelparameter;

import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.condegen.data.ModelEnum;

import java.io.File;

/**
 * @author Fancy
 * @date 2019/10/30
 */
public class ClientModelParameter  extends BaseModelParameter {

    public ClientModelParameter(ProjectStructure projectStructure) {
        super(projectStructure, ModelEnum.CLIENT);
    }
}
