package com.avatech.dahupt.${projectName?lower_case}.consumer.v1;

import com.avatech.dahupt.${projectName?lower_case}.consumer.${projectName?cap_first}ConsumerApplication;
import com.avatech.dahupt.${projectName?lower_case}.feignclient.v1.${domainModel.modelName}V1Client;
import com.avatech.dahupt.${projectName?lower_case}.model.bo.${domainModel.modelName?lower_case}.${domainModel.modelName};
import com.avatech.edi.model.dto.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ${projectName?cap_first}ConsumerApplication.class)
@AutoConfigureMockMvc
public class ${domainModel.modelName}V1ConsumerTest {


    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ${domainModel.modelName}V1Client ${domainModel.modelName?uncap_first}V1Client;

    private ${domainModel.modelName} get${domainModel.modelName}(){
        ${domainModel.modelName} ${domainModel.modelName?uncap_first} = new ${domainModel.modelName}();
        ${domainModel.modelName?uncap_first}.setId(123L);

        return ${domainModel.modelName?uncap_first};
    }

    @Test
    public void fetch${domainModel.modelName}() throws Exception {
        List<${domainModel.modelName}> ${domainModel.modelName?uncap_first}s = new ArrayList<>();
        ${domainModel.modelName?uncap_first}s.add(get${domainModel.modelName}());

        Mockito.when(${domainModel.modelName?uncap_first}V1Client.get${domainModel.modelName}()).thenReturn(${domainModel.modelName?uncap_first}s);

        MvcResult mvcResult = mockMvc.perform(get("/v1/${domainModel.modelName?lower_case}"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void add${domainModel.modelName}() throws Exception {
        Result result = new Result();
        Mockito.when(${domainModel.modelName?uncap_first}V1Client.add${domainModel.modelName}(Mockito.any(${domainModel.modelName}.class))).thenReturn(result.ok());
        ObjectMapper mapper = new ObjectMapper();
        String ${domainModel.modelName?uncap_first}JsonStr =  mapper.writeValueAsString(get${domainModel.modelName}());
        MvcResult mvcResult = mockMvc.perform(post("/v1/${domainModel.modelName?lower_case}")
                .contentType("application/json")
                .content(${domainModel.modelName?uncap_first}JsonStr))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("0"))
                .andReturn();
    }

    @Test
    public void update${domainModel.modelName}() throws Exception {
        Result result = new Result();
        Mockito.when(${domainModel.modelName?uncap_first}V1Client.update${domainModel.modelName}(Mockito.any(${domainModel.modelName}.class),Mockito.any())).thenReturn(result.ok());
        ObjectMapper mapper = new ObjectMapper();
        String ${domainModel.modelName?uncap_first}JsonStr =  mapper.writeValueAsString(get${domainModel.modelName}());
        MvcResult mvcResult = mockMvc.perform(put("/v1/${domainModel.modelName?lower_case}/"+1)
                .contentType("application/json")
                .content(${domainModel.modelName?uncap_first}JsonStr))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("0"))
                .andReturn();
    }

    @Test
    public void delete${domainModel.modelName}() throws Exception {
        Result result = new Result();
        Mockito.when(${domainModel.modelName?uncap_first}V1Client.delete${domainModel.modelName}(Mockito.any())).thenReturn(result.ok());
        ObjectMapper mapper = new ObjectMapper();
        String ${domainModel.modelName?uncap_first}JsonStr =  mapper.writeValueAsString(get${domainModel.modelName}());
        MvcResult mvcResult = mockMvc.perform(delete("/v1/${domainModel.modelName?lower_case}/"+1)
                .contentType("application/json")
                .content(${domainModel.modelName?uncap_first}JsonStr))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("0"))
                .andReturn();
    }

}