package com.avatech.dahupt.${projectName}.provider.v1;

import com.avatech.dahupt.purchase.feignclient.v1.${projectName?cap_first}V1Client;
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
    private ${projectName?cap_first}V1Client ${projectName?uncap_first}V1Client;


    @GetMapping("${domainModel.modelName?lower_case}")
    public @ResponseBody List<${domainModel.modelName}> get${domainModel.modelName}(){
        return ${projectName?uncap_first}V1Client.get${projectName?cap_first}V1Client();
    }

    @PostMapping("${domainModel.modelName?lower_case}")
    public @ResponseBody Result add${domainModel.modelName}(@RequestBody ${domainModel.modelName} ${domainModel.modelName?uncap_first}){
        return ${projectName?uncap_first}V1Client.add${projectName?cap_first}V1Client();
    }

    @PutMapping("${domainModel.modelName?lower_case}/{id}")
    public @ResponseBody Result update${domainModel.modelName}(@RequestBody ${domainModel.modelName} ${domainModel.modelName?uncap_first},@PathVariable(value="id",required = true) Long id){
        return ${projectName?uncap_first}V1Client.update${projectName?cap_first}V1Client();
    }

    @DeleteMapping("${domainModel.modelName?lower_case}/{id}")
    public @ResponseBody Result delete${domainModel.modelName}(@PathVariable(value="id",required = true) Long id){
        return ${projectName?uncap_first}V1Client.delete${projectName?cap_first}V1Client();
    }
}