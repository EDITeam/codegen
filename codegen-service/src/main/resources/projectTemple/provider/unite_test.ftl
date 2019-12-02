package com.avatech.dahupt.purchase.provider.v1;

import com.avatech.dahupt.purchase.model.bo.purchaserequest.PurchaseRequest;
import com.avatech.dahupt.purchase.model.bo.purchaserequest.PurchaseRequestLine;
import com.avatech.dahupt.purchase.provider.PurchaseProviderApplication;
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
* @author Fancy
* @date 2019/11/29
*/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PurchaseProviderApplication.class)
@AutoConfigureMockMvc
public class PurchaseRequestV1APITest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PurchaseRequestV1API purchaseRequestV1API;


    private PurchaseRequest getPurchaseRequest(){
        PurchaseRequest purchaseRequest = new PurchaseRequest();
        purchaseRequest.setCompanyCode("EDF");
        purchaseRequest.setDocDate(new Date());
        purchaseRequest.setPurpose("Utest");
        for (int i = 0;i<2;i++) {
            PurchaseRequestLine purchaseRequestLine = new PurchaseRequestLine();
            purchaseRequestLine.setCompanyCode("EDF");
            purchaseRequestLine.setDepartmentCode("HR");
            purchaseRequestLine.setItemCode("A001");
            purchaseRequest.getPurchaseRequestLines().add(purchaseRequestLine);
        }
        return purchaseRequest;
    }




    @Test
    public void addPurchaseRequest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String purchaseRequestJsonStr =  mapper.writeValueAsString(getPurchaseRequest());
        MvcResult mvcResult = mockMvc.perform(post("/dahupt/purchase/v1/purchaserequest")
                .contentType("application/json")
                .content(purchaseRequestJsonStr))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("0"))
                .andReturn();
    }

    @Test
    public void fetchPurchaseRequest() throws Exception {

    }

    @Test
    public void updatePurchaseRequest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        PurchaseRequest purchaseRequest = getPurchaseRequest();
        String purchaseRequestJsonStr = mapper.writeValueAsString(purchaseRequest);
        // insert
        MvcResult mvcResult = mockMvc.perform(post("/dahupt/purchase/v1/purchaserequest")
                .contentType("application/json")
                .content(purchaseRequestJsonStr))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("0"))
                .andReturn();

        String str = mvcResult.getResponse().getContentAsString();
        Result<Long> result = mapper.readValue(str, new TypeReference<Result<Long>>() {});
        purchaseRequest.setPurpose("1");
        purchaseRequestJsonStr = mapper.writeValueAsString(purchaseRequest);

        // update
        mvcResult = mockMvc.perform(put("/dahupt/purchase/v1/purchaserequest/" + result.getData())
                .contentType("application/json")
                .content(purchaseRequestJsonStr))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("0"))
                .andReturn();
    }

    @Test
    public void deletePurchaseRequest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        PurchaseRequest purchaseRequest = getPurchaseRequest();
        String purchaseRequestJsonStr = mapper.writeValueAsString(purchaseRequest);
        // insert
        MvcResult mvcResult = mockMvc.perform(post("/dahupt/purchase/v1/purchaserequest")
            .contentType("application/json")
            .content(purchaseRequestJsonStr))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("0"))
            .andReturn();

        String str = mvcResult.getResponse().getContentAsString();
        Result<Long> result = mapper.readValue(str, new TypeReference<Result<Long>>() {});
        // delete
        mvcResult = mockMvc.perform(delete("/dahupt/purchase/v1/purchaserequest/"+result.getData()))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("0"))
                .andReturn();
    }
}