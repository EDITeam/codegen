package ${mapperObject.packageName}.service;

<#if mapperObject.mapperObjectItems?has_content>
    <#list mapperObject.mapperObjectItems as mapperItem>
import ${mapperItem.boPackageName};
    </#list>
</#if>
import ${mapperObject.packageName}.model.bo.${mapperObject.mapperObjName?lower_case}.${mapperObject.mapperObjName};
import ${mapperObject.packageName}.repository.${mapperObject.mapperObjName}Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import com.avatech.edi.common.exception.BaseException;
import org.springframework.transaction.annotation.Transactional;

/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/

@Service
public class ${mapperObject.mapperObjName}Service {

    @Autowired
    private ${mapperObject.mapperObjName}Repository ${mapperObject.mapperObjName?uncap_first}Repository;

    public String save(${mapperObject.mapperObjName} ${mapperObject.mapperObjName?uncap_first}) {
<#if businessObjectType == "bott_MasterData" || businessObjectType == "bott_Document">
        ${mapperObject.mapperObjName?uncap_first}.check();
</#if>
        String id;
        if(${mapperObject.mapperObjName?uncap_first}.getId() == null || ${mapperObject.mapperObjName?uncap_first}.getId() == 0){
            id = UUID.randomUUID();
            ${mapperObject.mapperObjName?uncap_first}.setId(id);
        }else{
            id = ${mapperObject.mapperObjName?uncap_first}.getId();
        }
        ${mapperObject.mapperObjName?uncap_first}Repository.save${mapperObject.mapperObjName}(${mapperObject.mapperObjName?uncap_first});
        return id;
    }

    public void update(${mapperObject.mapperObjName} ${mapperObject.mapperObjName?uncap_first}) {
        ${mapperObject.mapperObjName?uncap_first}Repository.update${mapperObject.mapperObjName?cap_first}(${mapperObject.mapperObjName?uncap_first});
    }

    public void delete(${mapperObject.mapperObjName} ${mapperObject.mapperObjName?uncap_first}) {
        ${mapperObject.mapperObjName?uncap_first}Repository.delete${mapperObject.mapperObjName}(${mapperObject.mapperObjName?uncap_first});
    }
}