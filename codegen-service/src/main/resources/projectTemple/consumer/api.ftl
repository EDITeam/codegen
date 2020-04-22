package com.avatech.dahupt.${projectName}.consumer.v1;

import com.avatech.dahupt.${projectName?lower_case}.feignclient.v1.${domainModel.modelName}V1Client;
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
@RequestMapping("/${projectName?lower_case}/v1/*")
public class ${domainModel.modelName}V1API {

    private final Logger logger = LoggerFactory.getLogger(${domainModel.modelName}V1API.class);

    @Autowired
    private ${domainModel.modelName}V1Client ${domainModel.modelName?uncap_first}V1Client;


    @GetMapping("${domainModel.modelName?lower_case}")
    public @ResponseBody List<${domainModel.modelName}> get${domainModel.modelName}(){
        return ${domainModel.modelName?uncap_first}V1Client.get${domainModel.modelName}();
    }

    @PostMapping("${domainModel.modelName?lower_case}")
    public @ResponseBody Result add${domainModel.modelName}(@RequestBody ${domainModel.modelName} ${domainModel.modelName?uncap_first}){
        return ${domainModel.modelName?uncap_first}V1Client.add${domainModel.modelName}(${domainModel.modelName?uncap_first});
    }

    @PutMapping("${domainModel.modelName?lower_case}/{id}")
    public @ResponseBody Result update${domainModel.modelName}(@RequestBody ${domainModel.modelName} ${domainModel.modelName?uncap_first},@PathVariable(value="id",required = true) String id){
        return ${domainModel.modelName?uncap_first}V1Client.update${domainModel.modelName}(${domainModel.modelName?uncap_first},id);
    }

    @DeleteMapping("${domainModel.modelName?lower_case}/{id}")
    public @ResponseBody Result delete${domainModel.modelName}(@PathVariable(value="id",required = true) Long id){
        return ${domainModel.modelName?uncap_first}V1Client.delete${domainModel.modelName}(id);
    }
}