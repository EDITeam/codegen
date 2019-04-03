package com.avatech.edi.codegen.service.imp.sql;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.ProjectInitial;
import com.avatech.edi.condegen.data.DBType;

import java.util.List;

public interface DataBaseHandler {

    DBType getDBType();

    void createDBSqlScript(List<DomainModel> domainModels, ProjectInitial projectInitial);
}
