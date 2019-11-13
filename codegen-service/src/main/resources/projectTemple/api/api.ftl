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


/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/
@RestController
@RequestMapping("v1/*")
public class ${domainModel.modelName}V1API {

    private final Logger logger = LoggerFactory.getLogger(${domainModel.modelName}V1API.class);

    @Autowired
    private ${domainModel.modelName}Service ${domainModel.modelName}Service;

    @Autowired
    private ${domainModel.modelName}Repository ${domainModel.modelName}Repository;


    @GetMapping("${domainModel.modelName}")
    public ${domainModel.modelName} get${domainModel.modelName}(){
        return  null;
    }


    @PostMapping("${domainModel.modelName}")
    public @ResponseBody Result add${domainModel.modelName}(@RequestBody ${domainModel.modelName} ${domainModel.modelName?uncap_first}){
        try{
            ${domainModel.modelName}Repository.save${domainModel.modelName}(${domainModel.modelName?uncap_first});
            return (new Result()).ok();
        }catch(BaseException e){
            return (new Result()).error(e.getCode(),e.getMessage());
        }catch(Exception e){
            return (new Result()).error("1","inner error");
        }
    }

    @PutMapping("${domainModel.modelName}")
    public @ResponseBody Result update${domainModel.modelName}(@RequestBody ${domainModel.modelName} ${domainModel.modelName?uncap_first}){
        try{
            ${domainModel.modelName}Repository.update${domainModel.modelName}(${domainModel.modelName?uncap_first});
            return (new Result()).ok();
        }catch(BaseException e){
            return (new Result()).error(e.getCode(),e.getMessage());
        }catch(Exception e){
            return (new Result()).error("1","inner error");
        }
    }


    @DeleteMapping("${domainModel.modelName}")
    public @ResponseBody Result delete${domainModel.modelName}(@RequestBody ${domainModel.modelName} ${domainModel.modelName?uncap_first}){
        try{
            ${domainModel.modelName}Repository.delete${domainModel.modelName}(${domainModel.modelName?uncap_first});
            return (new Result()).ok();
        }catch(BaseException e){
            return (new Result()).error(e.getCode(),e.getMessage());
        }catch(Exception e){
            return (new Result()).error("1","inner error");
        }
    }
}