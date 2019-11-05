package com.avatech.edi.codegen.model.bo.project.modelparameter;

import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.codegen.data.ModelEnum;

/**
 * @author Fancy
 * @date 2019/10/30
 * API模块相关参数
 */
public class APIModelParameter extends BaseModelParameter {

    public APIModelParameter(ProjectStructure projectStructure) {
        super(projectStructure,ModelEnum.API);
    }

}
