package com.avatech.edi.codegen.service.model;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.modelparameter.BaseModelParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Fancy
 * @date 2019/10/30
 */
@Component
public class CoreModelService  extends AbstractModelService  {

    @Override
    public void createModelFile(List<DomainModel> domainModels, BaseModelParameter modelParameter) {

    }

    @Override
    public void createPOM(BaseModelParameter modelParameter) {

    }
}
