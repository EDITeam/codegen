package com.avatech.dahupt.demo.api.v1.impl;

import com.avatech.dahupt.demo.api.v1.I${domainModel.modelName}API;
import com.avatech.dahupt.${projectName}.service.${domainModel.modelName}Service;
import com.avatech.dahupt.${projectName}.repository.${domainModel.modelName}Repository;
import com.avatech.dahupt.${projectName}.model.bo.${domainModel.modelName?lower_case}.${domainModel.modelName};
import com.avatech.edi.model.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/
@Component
public class ${domainModel.modelName}APIImpl implements I${domainModel.modelName}API{

    @Autowired
    private ${domainModel.modelName}Service ${domainModel.modelName?uncap_first}Service;

    @Autowired
    private ${domainModel.modelName}Repository ${domainModel.modelName?uncap_first}Repository;

    @Override
    public Result fetch${domainModel.modelName}(){
        List<${domainModel.modelName}> ${domainModel.modelName?uncap_first} = ${domainModel.modelName?uncap_first}Repository.fetch${domainModel.modelName}s();
        return new Result().ok(${domainModel.modelName?uncap_first});
    }

    @Override
    public Result add${domainModel.modelName}(${domainModel.modelName} ${domainModel.modelName?uncap_first}) {
        String id = ${domainModel.modelName?uncap_first}Service.save(${domainModel.modelName?uncap_first});
        return (new Result()).ok(id);
    }

    @Override
    public Result update${domainModel.modelName}(${domainModel.modelName} ${domainModel.modelName?uncap_first}){
        ${domainModel.modelName?uncap_first}Service.update(${domainModel.modelName?uncap_first});
        return (new Result()).ok();
    }

    @Override
    public Result delete${domainModel.modelName}(String id){
        ${domainModel.modelName} ${domainModel.modelName?uncap_first} = new ${domainModel.modelName}();
        ${domainModel.modelName?uncap_first}.setId(id);
        ${domainModel.modelName?uncap_first}Service.delete(${domainModel.modelName?uncap_first});
        return (new Result()).ok();
    }
}
