package com.avatech.dahupt.purchase.service;

import com.avatech.dahupt.purchase.model.bo.purchaserequest.PurchaseRequest;
import com.avatech.dahupt.purchase.model.bo.purchaserequest.PurchaseRequestLine;
import com.avatech.dahupt.purchase.service.PurchaseRequestService;
import com.avatech.edi.common.data.SnowflakeIdWorker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import java.util.Date;

import static org.junit.Assert.*;

/**
* @author Fancy
* @date 2019/12/2
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class PurchaseRequestServiceTest {

    @Autowired
    private PurchaseRequestService purchaseRequestService;

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

    //服务类保存方法 未抛出异常即是保存成功
    //如果需要测试异常，采用以下方式
    /* example
    @Test(expected = DBException.class)
        publicvoid saveDBException() {
        BO bo = getBO();
        service.save(bo);
    }
    */

    @Test
    public void save() throws Exception {
        PurchaseRequest purchaseRequest = getPurchaseRequest();
        purchaseRequestService.save(purchaseRequest);
    }

    @Test
    public void update() throws Exception {
        PurchaseRequest purchaseRequest = getPurchaseRequest();
        SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(0,0);
        purchaseRequest.setId(snowflakeIdWorker.nextId());
        purchaseRequestService.save(purchaseRequest);

        //update
        purchaseRequest.setPurpose("test");
        purchaseRequestService.update(purchaseRequest);
    }

    @Test
    public void delete() {
        PurchaseRequest purchaseRequest = getPurchaseRequest();
        SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(0,0);
        purchaseRequest.setId(snowflakeIdWorker.nextId());
        purchaseRequestService.save(purchaseRequest);
        purchaseRequestService.delete(purchaseRequest);
    }

}