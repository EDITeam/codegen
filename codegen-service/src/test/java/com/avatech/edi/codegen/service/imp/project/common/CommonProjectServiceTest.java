package com.avatech.edi.codegen.service.imp.project.common;

import com.avatech.edi.codegen.model.bo.*;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.condegen.data.DataBaseType;
import com.avatech.edi.condegen.data.Dictionary;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CommonProjectServiceTest {

    @Test
    public void createProject() {
        ProjectStructure projectInitial = new ProjectStructure();
        projectInitial.setProjectName("ava");
        projectInitial.setDataBaseType(DataBaseType.HANA);
        //projectInitial.setOrmType(Dictionary.ORMTypes_JPA);
        //projectInitial.setProjectType(Dictionary.Single_Model);
        projectInitial.setDataFilePath("/Users/fanxing/Documents/dev/datastruct");
        projectInitial.setProjectFilePath("/Users/fanxing/Documents/dev/");
        projectInitial.setSerializaFormat(Dictionary.SerializaTypes_JSON);
        List<DomainModel> domainModelList = new ArrayList<>();
        DomainModel domainModel = new DomainModel();
        domainModel.setModelName("SalesOrder");

        Table table = new Table();
        table.setTableName("AVA_SM_ORDR");
        table.setTableProperty("SalesOrder");
        TableLine tableLine = new TableLine();
        tableLine.setProName("DocEntry");
        tableLine.setProDataType("Long");
        tableLine.setProDesc("单据号");
        tableLine.setFieldName("DocEntry");
        tableLine.setProDataType("Long");
        table.getTableLines().add(tableLine);
        domainModel.getTableList().add(table);

        table = new Table();
        table.setTableName("AVA_SM_RDR1");
        table.setTableProperty("SalesOrderItem");
        tableLine = new TableLine();
        tableLine.setProName("DocEntry");
        tableLine.setProDataType("Long");
        tableLine.setProDesc("单据号");
        tableLine.setFieldName("DocEntry");
        tableLine.setProDataType("Long");
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
        //CommonProjectService service = new CommonProjectService();
        //service.createProject(domainModelList, projectInitial);
    }
}