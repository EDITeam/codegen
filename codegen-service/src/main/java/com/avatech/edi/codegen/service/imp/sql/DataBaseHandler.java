package com.avatech.edi.codegen.service.imp.sql;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.ProjectInitial;

import java.util.List;

public interface DataBaseHandler {

    public void createDBSqlScript(List<DomainModel> domainModels, ProjectInitial projectInitial);
}
