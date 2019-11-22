package com.avatech.dahupt.${projectName?lower_case}.feignclient.v1;

import com.avatech.dahupt.${projectName?lower_case}.model.bo.${domainModel.modelName?lower_case}.${domainModel.modelName};
import com.avatech.edi.common.exception.BaseException;
import com.avatech.edi.model.dto.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient(value = "${serviceName}")
public interface ${domainModel.modelName?upper_abc}V1Client {

    @GetMapping("${domainModel.modelName?lower_case}")
    public @ResponseBody List<${domainModel.modelName}> get${domainModel.modelName}();

    @PostMapping("${domainModel.modelName?lower_case}")
    public @ResponseBody Result add${domainModel.modelName}(@RequestBody ${domainModel.modelName} ${domainModel.modelName?uncap_first});

    @PutMapping("${domainModel.modelName?lower_case}/{id}")
    public @ResponseBody Result update${domainModel.modelName}(@RequestBody ${domainModel.modelName} ${domainModel.modelName?uncap_first},@PathVariable(value="id",required = true) Long id);

    @DeleteMapping("${domainModel.modelName?lower_case}/}{id}")
    public @ResponseBody Result delete${domainModel.modelName}(@PathVariable(value="id",required = true) Long id);
}