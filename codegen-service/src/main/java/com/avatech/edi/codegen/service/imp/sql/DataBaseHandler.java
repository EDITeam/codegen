package com.avatech.edi.codegen.service.imp.sql;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import com.avatech.edi.condegen.data.DataBaseType;

import java.util.List;

public interface DataBaseHandler {

    DataBaseType getDBType();

    void createDBSqlScript(List<DomainModel> domainModels, ProjectStructure projectInitial);
}
