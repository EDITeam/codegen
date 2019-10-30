package com.avatech.edi.codegen.service.imp.project.repository;

import com.avatech.edi.codegen.model.bo.*;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.condegen.data.DataBaseType;
import com.avatech.edi.condegen.data.Dictionary;
import com.avatech.edi.condegen.data.ProjectType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RepositoryProjectServiceTest {

    @Test
    public void createProject() {
        ProjectStructure projectInitial = new ProjectStructure();
        projectInitial.setProjectName("ava");
        projectInitial.setDataBaseType(DataBaseType.HANA);
        //projectInitial.setOrmType(Dictionary.ORMTypes_JPA);
        projectInitial.setProjectType(ProjectType.SBO_PROJECT);
        projectInitial.setDataFilePath("/Users/fanxing/Documents/dev/datastruct");
        projectInitial.setProjectFilePath("D:\\EDI");
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
        tableLine.setFieldType("Long");
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
        tableLine.setFieldType("Long");
        table.getTableLines().add(tableLine);
        tableLine = new TableLine();
        tableLine.setProName("LineNum");
        tableLine.setProDataType("Integer");
        tableLine.setFieldName("LineNum");
        tableLine.setProDesc("行号");
        tableLine.setFieldType("Integer");
        table.getTableLines().add(tableLine);
        domainModel.getTableList().add(table);

        BusinessObjectMap businessObjectMap = new BusinessObjectMap();
        businessObjectMap.setTableName("AVA_SM_ORDR");
        businessObjectMap.setChildTableNames("AVA_SM_RDR1");
        businessObjectMap.setTableProName("SalesOrder");
        businessObjectMap.setChildTableProName("SalesOrderItem");
        domainModel.getBusinessObjectMaps().add(businessObjectMap);

        domainModelList.add(domainModel);
        //RepositoryProjectService repositoryProjectService = new RepositoryProjectService();
       // repositoryProjectService.createProject(domainModelList,projectInitial);
    }
}