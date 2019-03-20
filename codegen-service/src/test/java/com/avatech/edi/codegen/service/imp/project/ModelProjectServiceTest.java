package com.avatech.edi.codegen.service.imp.project;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.ProjectInitial;
import com.avatech.edi.codegen.model.bo.Table;
import com.avatech.edi.codegen.model.bo.TableLine;
import com.avatech.edi.condegen.data.Dictionary;
import com.avatech.edi.condegen.data.ProjectData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ModelProjectServiceTest {

    @Test
    public void createModelProjectTest(){
        ProjectInitial projectInitial = new ProjectInitial();
        projectInitial.setProjectName("ava");
        projectInitial.setDataBaseType(Dictionary.DATABASETypes_MSSQL);
        projectInitial.setOrmType(Dictionary.ORMTypes_JPA);
        projectInitial.setProjectType(Dictionary.Single_Model);
        projectInitial.setDataFilePath("/Users/fanxing/Documents/dev/datastruct");
        projectInitial.setProjectFilePath("/Users/fanxing/Documents/dev/");
        projectInitial.setSerializaFormat(Dictionary.SerializaTypes_JSON);

        List<DomainModel> domainModelList = new ArrayList<>();
        DomainModel domainModel = new DomainModel();
        domainModel.setModelName("SalesReturn");

        Table table = new Table();
        table.setTableName("AVA_SM_ORDR");
        table.setTableProperty("SalesReturn");
        TableLine tableLine = new TableLine();
        tableLine.setProName("DocEntry");
        tableLine.setProDataType("Integer");
        tableLine.setFieldName("DocEntry");
        tableLine.setProDataType("Int");
        table.getTableLines().add(tableLine);
        domainModel.getTableList().add(table);

        table.setTableName("AVA_SM_ORDR");
        table.setTableProperty("SalesReturn");
        tableLine.setProName("DocEntry");
        tableLine.setProDataType("Integer");
        tableLine.setFieldName("DocEntry");
        tableLine.setProDataType("Int");
        table.getTableLines().add(tableLine);
        domainModel.getTableList().add(table);

        domainModelList.add(domainModel);

        ModelProjectService modelProjectService = new ModelProjectService();
        modelProjectService.createProject(domainModelList,projectInitial);



    }

}