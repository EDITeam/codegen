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
import com.avatech.edi.common.exception.BaseException;
import org.springframework.transaction.annotation.Transactional;

/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/

@Service
public class ${mapperObject.mapperObjName}Service extends AbastractTransactionService<${mapperObject.mapperObjName}> {

    @Autowired
    private ${mapperObject.mapperObjName}Repository ${mapperObject.mapperObjName?uncap_first}Repository;

    SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(0,0);

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Long save(${mapperObject.mapperObjName} ${mapperObject.mapperObjName?uncap_first}) {
        Long id;
        if(${mapperObject.mapperObjName?uncap_first}.getId() == null || ${mapperObject.mapperObjName?uncap_first}.getId() == 0){
            id = snowflakeIdWorker.nextId();
            ${mapperObject.mapperObjName?uncap_first}.setId(id);
        }else{
            id = ${mapperObject.mapperObjName?uncap_first}.getId();
        }
        ${mapperObject.mapperObjName?uncap_first}Repository.save${mapperObject.mapperObjName}(${mapperObject.mapperObjName?uncap_first});
        if (true) {
            super.save(${mapperObject.mapperObjName?uncap_first});
        }
        return id;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(${mapperObject.mapperObjName} ${mapperObject.mapperObjName?uncap_first}) {
        ${mapperObject.mapperObjName?uncap_first}Repository.update${mapperObject.mapperObjName?cap_first}(${mapperObject.mapperObjName?uncap_first});
        if (true) {
            super.update(${mapperObject.mapperObjName?uncap_first});
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(${mapperObject.mapperObjName} ${mapperObject.mapperObjName?uncap_first}) {
        ${mapperObject.mapperObjName?uncap_first}Repository.delete${mapperObject.mapperObjName}(${mapperObject.mapperObjName?uncap_first});
        if (true) {
            super.delete(${mapperObject.mapperObjName?uncap_first});
        }
    }
}