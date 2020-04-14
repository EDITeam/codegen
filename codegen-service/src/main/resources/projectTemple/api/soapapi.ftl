package com.avatech.dahupt.${projectName}.api.v1;

import com.avatech.dahupt.${projectName}.model.bo.${domainModel.modelName?lower_case}.${domainModel.modelName};
import com.avatech.edi.model.dto.Result;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/
@WebService(name = "${domainModel.modelName?uncap_first}service")
public interface I${domainModel.modelName}API {

    /**
    *
    * @param ${domainModel.modelName?uncap_first}
    * @return
    */
    @WebMethod(operationName = "fetch${domainModel.modelName}")
    Result fetch${domainModel.modelName}();

    /**
    *
    * @param ${domainModel.modelName?uncap_first}
    * @return
    */
    @WebMethod(operationName = "save${domainModel.modelName}")
    Result add${domainModel.modelName}(@WebParam(name = "${domainModel.modelName?uncap_first}") ${domainModel.modelName} ${domainModel.modelName?uncap_first});

    /**
    *
    * @param ${domainModel.modelName?uncap_first}
    * @return
    */
    @WebMethod(operationName = "update${domainModel.modelName}")
    Result update${domainModel.modelName}(@WebParam(name = "${domainModel.modelName?uncap_first}") ${domainModel.modelName} ${domainModel.modelName?uncap_first});

    /**
    *
    * @param id
    * @return
    */
    @WebMethod(operationName = "delete${domainModel.modelName}")
    Result delete${domainModel.modelName}(Long id);



}
