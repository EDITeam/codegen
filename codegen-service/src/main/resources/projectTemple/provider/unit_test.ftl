package com.avatech.dahupt.${projectName}.provider.v1;

import com.avatech.dahupt.${projectName}.model.bo.${domainModel.modelName?lower_case}.${domainModel.modelName};
import com.avatech.dahupt.${projectName}.provider.${projectName?cap_first}ProviderApplication;
import com.avatech.edi.model.dto.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Date;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ${projectName?cap_first}ProviderApplication.class)
@AutoConfigureMockMvc
public class ${domainModel.modelName}V1APITest {

    @Autowired
    MockMvc mockMvc;

    private ${domainModel.modelName} get${domainModel.modelName}(){
        ${domainModel.modelName} ${domainModel.modelName?uncap_first} = new ${domainModel.modelName}();
        ${domainModel.modelName?uncap_first}.setId(1L);
        return ${domainModel.modelName?uncap_first};
    }

    @Test
    public void add${domainModel.modelName}() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String ${domainModel.modelName?uncap_first}JsonStr =  mapper.writeValueAsString(get${domainModel.modelName}());
        MvcResult mvcResult = mockMvc.perform(post("/${projectName?lower_case}/v1/${domainModel.modelName?lower_case}")
                .contentType("application/json")
                .content(${domainModel.modelName?uncap_first}JsonStr))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("0"))
                .andReturn();
    }

    @Test
    public void fetch${domainModel.modelName}() throws Exception {

    }

    @Test
    public void update${domainModel.modelName}() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ${domainModel.modelName} ${domainModel.modelName?uncap_first} = get${domainModel.modelName}();
        String ${domainModel.modelName?uncap_first}JsonStr = mapper.writeValueAsString(${domainModel.modelName?uncap_first});
        // insert
        MvcResult mvcResult = mockMvc.perform(post("/${projectName?lower_case}/v1/${domainModel.modelName?lower_case}")
                .contentType("application/json")
                .content(${domainModel.modelName?uncap_first}JsonStr))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("0"))
                .andReturn();

        String str = mvcResult.getResponse().getContentAsString();
        Result<Long> result = mapper.readValue(str, new TypeReference<Result<Long>>() {});
        ${domainModel.modelName?uncap_first}JsonStr = mapper.writeValueAsString(${domainModel.modelName?uncap_first});

        // update
        mvcResult = mockMvc.perform(put("/${projectName?lower_case}/v1/${domainModel.modelName?lower_case}/" + result.getData())
                .contentType("application/json")
                .content(${domainModel.modelName?uncap_first}JsonStr))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("0"))
                .andReturn();
    }

    @Test
    public void delete${domainModel.modelName}() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ${domainModel.modelName} ${domainModel.modelName?uncap_first} = get${domainModel.modelName}();
        String ${domainModel.modelName?uncap_first}JsonStr = mapper.writeValueAsString(${domainModel.modelName?uncap_first});
        // insert
        MvcResult mvcResult = mockMvc.perform(post("/${projectName?lower_case}/v1/${domainModel.modelName?lower_case}")
            .contentType("application/json")
            .content(${domainModel.modelName?uncap_first}JsonStr))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("0"))
            .andReturn();

        String str = mvcResult.getResponse().getContentAsString();
        Result<Long> result = mapper.readValue(str, new TypeReference<Result<Long>>() {});
        // delete
        mvcResult = mockMvc.perform(delete("/${projectName?lower_case}/v1/${domainModel.modelName?lower_case}/"+result.getData()))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("0"))
                .andReturn();
    }
}