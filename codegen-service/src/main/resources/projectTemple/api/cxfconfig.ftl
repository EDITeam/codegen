package com.avatech.dahupt.${projectName}.api.v1.config;

<#list domainModels as domainModel>
import com.avatech.dahupt.${projectName}.api.v1.I${domainModel.modelName}API;
</#list>
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/
@Configuration
public class CxfConfig {

    @Autowired
    private Bus bus;

<#list domainModels as domainModel>
    @Bean
    public EndpointImpl publish${domainModel.modelName}Service(I${domainModel.modelName}API ${domainModel.modelName}API) {
        EndpointImpl endpoint = new EndpointImpl(bus, ${domainModel.modelName}API);
        endpoint.publish("/${domainModel.modelName?lower_case}service");
        return endpoint;
    }
</#list>
}
