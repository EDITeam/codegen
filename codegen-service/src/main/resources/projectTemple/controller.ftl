package com.avatech.edi.${businessObject.applicationName}.contorller;

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


@RestController
@RequestMapping("v1/*")
public class ${businessObject.bussinessObjectName}Controller {

    private final Logger logger = LoggerFactory.getLogger(${businessObject.bussinessObjectName}Controller.class);

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
        return null;
    }


}