package com.avatech.dahub.${businessObject.applicationName}.api;

import ${businessObject.bussinessObjectServicePackageName};
import ${businessObject.bussinessObjectRepositoryPackageName};
<#if businessObject.bussinessObjectModelPackageName?has_content>
 <#list businessObject.bussinessObjectModelPackageName as modelName>
import ${modelName};
 </#list>
</#if>
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
public class ${businessObject.bussinessObjectName}V1API {

    private final Logger logger = LoggerFactory.getLogger(${businessObject.bussinessObjectName}V1API.class);

    @Autowired
    private ${businessObject.bussinessObjectName}Service ${businessObject.bussinessObjectName?uncap_first}Service;

    @Autowired
    private ${businessObject.bussinessObjectName}Repository ${businessObject.bussinessObjectName?uncap_first}Repository;


    @GetMapping("${businessObject.bussinessObjectName?lower_case}")
    public ${businessObject.bussinessObjectName} get${businessObject.bussinessObjectName}(){
        return  null;
    }


    @PostMapping("${businessObject.bussinessObjectName?lower_case}")
    public @ResponseBody Result add${businessObject.bussinessObjectName}(@RequestBody ${businessObject.bussinessObjectName} ${businessObject.bussinessObjectName?uncap_first}){
        try{
            ${businessObject.bussinessObjectName?uncap_first}Repository.save${businessObject.bussinessObjectName}(${businessObject.bussinessObjectName?uncap_first});
            return Result.ok();
        }catch(BaseException e){
            return Result.error(e.getCode,e.getMessage);
        }catch(Exception e){
            return Result.error("1","inner error");
        }
    }

    @PutMapping("${businessObject.bussinessObjectName?lower_case}")
    public @ResponseBody Result update${businessObject.bussinessObjectName}(@RequestBody ${businessObject.bussinessObjectName} ${businessObject.bussinessObjectName?uncap_first}){
        try{
            ${businessObject.bussinessObjectName?uncap_first}Repository.update${businessObject.bussinessObjectName}(${businessObject.bussinessObjectName?uncap_first});
            return Result.ok();
        }catch(BaseException e){
            return Result.error(e.getCode,e.getMessage);
        }catch(Exception e){
            return Result.error("1","inner error");
        }
    }


    @DeleteMapping("${businessObject.bussinessObjectName?lower_case}")
    public @ResponseBody Result update${businessObject.bussinessObjectName}(@RequestBody ${businessObject.bussinessObjectName} ${businessObject.bussinessObjectName?uncap_first}){
        try{
            ${businessObject.bussinessObjectName?uncap_first}Repository.delete${businessObject.bussinessObjectName}(${businessObject.bussinessObjectName?uncap_first});
            return Result.ok();
        }catch(BaseException e){
            return Result.error(e.getCode,e.getMessage);
        }catch(Exception e){
            return Result.error("1","inner error");
        }
    }
}