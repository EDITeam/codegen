package com.avatech.dahupt.${projectName}.api.v1;

import com.avatech.dahupt.${projectName}.service.${domainModel.modelName}Service;
import com.avatech.dahupt.${projectName}.repository.${domainModel.modelName}Repository;
import com.avatech.dahupt.${projectName}.model.bo.${domainModel.modelName?lower_case}.${domainModel.modelName};
import com.avatech.edi.common.exception.BaseException;
import com.avatech.edi.model.dto.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/
@RestController
@RequestMapping("/v1/${projectName?lower_case}/*")
public class ${domainModel.modelName}V1API {

    private final Logger logger = LoggerFactory.getLogger(${domainModel.modelName}V1API.class);

    @Autowired
    private ${domainModel.modelName}Service ${domainModel.modelName?uncap_first}Service;

    @Autowired
    private ${domainModel.modelName}Repository ${domainModel.modelName?uncap_first}Repository;

    @GetMapping("${domainModel.modelName?lower_case}")
    public @ResponseBody List<${domainModel.modelName}> get${domainModel.modelName}(){
        return ${domainModel.modelName?uncap_first}Repository.fetch${domainModel.modelName}s();
    }

    @PostMapping("${domainModel.modelName?lower_case}")
    public @ResponseBody Result add${domainModel.modelName}(@RequestBody ${domainModel.modelName} ${domainModel.modelName?uncap_first}){
        String id = ${domainModel.modelName?uncap_first}Service.save(${domainModel.modelName?uncap_first});
        return (new Result()).ok(id);
    }

    @PutMapping("${domainModel.modelName?lower_case}/{id}")
    public @ResponseBody Result update${domainModel.modelName}(@RequestBody ${domainModel.modelName} ${domainModel.modelName?uncap_first},@PathVariable(value="id") Long id){
        ${domainModel.modelName?uncap_first}.setId(id);
        ${domainModel.modelName?uncap_first}Service.update(${domainModel.modelName?uncap_first});
        return (new Result()).ok();
    }

    @DeleteMapping("${domainModel.modelName?lower_case}/{id}")
    public @ResponseBody Result delete${domainModel.modelName}(@PathVariable(value="id") Long id){
        ${domainModel.modelName} ${domainModel.modelName?uncap_first} = new ${domainModel.modelName}();
        ${domainModel.modelName?uncap_first}.setId(id);
        ${domainModel.modelName?uncap_first}Service.delete(${domainModel.modelName?uncap_first});
        return (new Result()).ok();
    }
}