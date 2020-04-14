package com.avatech.edi.codegen.service.imp.project.model;

import com.avatech.edi.codegen.model.bo.*;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.codegen.data.DataBaseType;
import com.avatech.edi.codegen.data.Dictionary;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ModelProjectServiceTest {


    @Test
    public void createModelProjectTest(){
        ProjectStructure projectInitial = new ProjectStructure();
        projectInitial.setProjectName("ava");
        projectInitial.setDataBaseType(DataBaseType.HANA);
      //  projectInitial.setProjectType(ProjectType.SBO_PROJECT);
        projectInitial.setDataFilePath("/Users/fanxing/Documents/ava-work/edi-microservice/datastruct");
        projectInitial.setProjectFilePath("/Users/fanxing/Documents/ava-work/edi-microservice/");
        projectInitial.setSerializaFormat(Dictionary.SerializaTypes_JSON);

        List<DomainModel> domainModelList = new ArrayList<>();
        DomainModel domainModel = new DomainModel();
        domainModel.setModelName("SalesOrder");

        Table table = new Table();
        table.setTableName("AVA_SM_ORDR");
        table.setTableProperty("SalesOrder");
        TableLine tableLine = new TableLine();
        tableLine.setProName("DocEntry");
        tableLine.setProDataType("String");
        tableLine.setProDesc("单据号");
        tableLine.setFieldName("DocEntry");
        tableLine.setProDataType("String");
        table.getTableLines().add(tableLine);
        domainModel.getTableList().add(table);

        table = new Table();
        table.setTableName("AVA_SM_RDR1");
        table.setTableProperty("SalesOrderItem");
        tableLine = new TableLine();
        tableLine.setProName("DocEntry");
        tableLine.setProDataType("String");
        tableLine.setProDesc("单据号");
        tableLine.setFieldName("DocEntry");
        tableLine.setProDataType("String");
        table.getTableLines().add(tableLine);
        tableLine = new TableLine();
        tableLine.setProName("LineNum");
        tableLine.setProDataType("Integer");
        tableLine.setFieldName("LineNum");
        tableLine.setProDesc("行号");
        tableLine.setProDataType("Int");
        table.getTableLines().add(tableLine);
        domainModel.getTableList().add(table);

        BusinessObjectMap businessObjectMap = new BusinessObjectMap();
        businessObjectMap.setTableName("AVA_SM_ORDR");
        businessObjectMap.setChildTableNames("AVA_SM_RDR1");
        businessObjectMap.setTableProName("SalesOrder");
        businessObjectMap.setChildTableProName("SalesOrderItem");
        domainModel.getBusinessObjectMaps().add(businessObjectMap);
        domainModelList.add(domainModel);

        //ModelProjectService modelProjectService = new ModelProjectService();
        //modelProjectService.createProject(domainModelList,projectInitial);

    }

}