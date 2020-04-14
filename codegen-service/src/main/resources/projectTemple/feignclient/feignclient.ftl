package com.avatech.dahupt.${projectName?lower_case}.feignclient.v1;

import com.avatech.dahupt.${projectName?lower_case}.model.bo.${domainModel.modelName?lower_case}.${domainModel.modelName};
import com.avatech.edi.common.exception.BaseException;
import com.avatech.edi.model.dto.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient(value = "${serviceName}")
public interface ${domainModel.modelName?cap_first}V1Client {

    @GetMapping("/${projectName?lower_case}/v1/${domainModel.modelName?lower_case}")
    List<${domainModel.modelName}> get${domainModel.modelName}();

    @PostMapping("/${projectName?lower_case}/v1/${domainModel.modelName?lower_case}")
    Result add${domainModel.modelName}(@RequestBody ${domainModel.modelName} ${domainModel.modelName?uncap_first});

    @PutMapping("/${projectName?lower_case}/v1/${domainModel.modelName?lower_case}/{id}")
    Result update${domainModel.modelName}(@RequestBody ${domainModel.modelName} ${domainModel.modelName?uncap_first},@PathVariable(value="id") Long id);

    @DeleteMapping("/${projectName?lower_case}/v1/${domainModel.modelName?lower_case}/{id}")
    Result delete${domainModel.modelName}(@PathVariable(value="id") Long id);
}
