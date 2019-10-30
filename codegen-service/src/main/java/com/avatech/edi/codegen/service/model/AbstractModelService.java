package com.avatech.edi.codegen.service.model;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.modelparameter.BaseModelParameter;

import java.util.List;

/**
 * @author Fancy
 * @date 2019/10/30
 */
public abstract class AbstractModelService {

    /**
     * 创建模块文件
     */
    public abstract void createModelFile(List<DomainModel> domainModels,BaseModelParameter modelParameter);

    /**
     * 创建POM文件
     */
    public abstract void createPOM(BaseModelParameter modelParameter);
}
