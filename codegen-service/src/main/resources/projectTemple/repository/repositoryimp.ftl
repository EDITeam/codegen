package ${mapperObject.packageName}.imp;

<#if mapperObject.mapperObjectItems?has_content>
    <#list mapperObject.mapperObjectItems as mapperItem>
import ${mapperItem.boPackageName};
    </#list>
</#if>
import com.avatech.dahupt.${mapperObject.mapperApplicationName?lower_case}.repository.mapper.${mapperObject.mapperObjName}Mapper;
import ${mapperObject.packageName}.${mapperObject.mapperObjName}Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/

@Component
public class ${mapperObject.mapperObjName}RepositoryImp implements ${mapperObject.mapperObjName}Repository{
<#if mapperObject.mapperObjectItems?has_content>

    private final Logger logger = LoggerFactory.getLogger(${mapperObject.mapperObjName}RepositoryImp.class);

    @Autowired
    private ${mapperObject.mapperObjName}Mapper ${mapperObject.mapperObjName?uncap_first}Mapper;

    @Override
    public void save${modelObject.modelName?cap_first}(${modelObject.modelName?cap_first} ${modelObject.modelName?uncap_first}){
        try{
            ${mapperObject.mapperObjName?uncap_first}Mapper.insert${modelObject.modelName?cap_first}(${modelObject.modelName?uncap_first});
            <#if modelObject.tableList?has_content>
                <#list modelObject.tableList as table>
                    <#if table.tableProperty == modelObject.modelName && table.businessObjectMaps?has_content>
                        <#list table.businessObjectMaps as tableMap>
            for (${tableMap.childTableProName?cap_first} ${tableMap.childTableProName?uncap_first} : ${modelObject.modelName?uncap_first}.get${tableMap.childTableProName?cap_first}s()) {
                ${mapperObject.mapperObjName?uncap_first}Mapper.insert${tableMap.childTableProName?cap_first}(${tableMap.childTableProName?uncap_first});
                <#list modelObject.businessObjectMaps as boMap>
                    <#if boMap.tableName == tableMap.childTableName>
                for (${boMap.childTableProName?cap_first} ${boMap.childTableProName?uncap_first} : ${tableMap.childTableProName?uncap_first}.get${boMap.childTableProName?cap_first}s()){
                ${mapperObject.mapperObjName?uncap_first}Mapper.insert${boMap.childTableProName?cap_first}(${boMap.childTableProName?uncap_first});
                }
                    </#if>
                </#list>
            }
                        </#list>
                    </#if>
                </#list>
            </#if>
        }catch(Exception e){
            throw new DBException("5001",e.getMessage());
        }
    }

    @Override
    public List<${modelObject.modelName?cap_first}> fetch${modelObject.modelName?cap_first}s(){
        try{
            List<${modelObject.modelName?cap_first}> ${modelObject.modelName?uncap_first}s = new ArrayList();
            ${modelObject.modelName?uncap_first}s = ${mapperObject.mapperObjName?uncap_first}Mapper.search${modelObject.modelName?cap_first}s();
            <#if modelObject.tableList?has_content && modelObject.tableList?size gt 1>
            for(${modelObject.modelName?cap_first} ${modelObject.modelName?uncap_first}:${modelObject.modelName?uncap_first}s){
                <#list modelObject.tableList as table>
                <#if table.tableProperty == modelObject.modelName && table.businessObjectMaps?has_content>
                    <#list table.businessObjectMaps as tableMap>
                List<${tableMap.childTableProName?cap_first}> ${tableMap.childTableProName?uncap_first}s = ${mapperObject.mapperObjName?uncap_first}Mapper.search${tableMap.childTableProName?cap_first}s();
                     <#--查找孙子表-->
                        <#list modelObject.businessObjectMaps as boMap>
                            <#if boMap.tableName == tableMap.childTableName>
                for (${tableMap.childTableProName?cap_first} ${tableMap.childTableProName?uncap_first} : ${tableMap.childTableProName?cap_first}s){
                    List<${boMap.childTableProName?cap_first}>  ${boMap.childTableProName?uncap_first}s = ${mapperObject.mapperObjName?uncap_first}Mapper.search${boMap.childTableProName?cap_first}s();
                    ${tableMap.childTableProName?uncap_first}.get${boMap.childTableProName?cap_first}s.addAll(${boMap.childTableProName?uncap_first}s);
                }
                            </#if>
                        </#list>
                ${modelObject.modelName?uncap_first}.get${tableMap.childTableProName?cap_first}s.addAll(${tableMap.childTableProName?uncap_first}s);
                    </#list>
                </#if>
                </#list>
            }
            </#if>
            return ${modelObject.modelName?uncap_first}s;
        }catch(Exception e){
            throw new DBException("5001",e.getMessage());
        }
    }

    @Override
    public void update${modelObject.modelName?cap_first}(${modelObject.modelName?cap_first} ${modelObject.modelName?uncap_first}){
        try{
            ${mapperObject.mapperObjName?uncap_first}Mapper.update${modelObject.modelName?cap_first}(${modelObject.modelName?uncap_first});
        <#--找子表-->
            <#if modelObject.tableList?has_content>
                <#list modelObject.tableList as table>
                    <#if table.tableProperty == modelObject.modelName && table.businessObjectMaps?has_content>
                        <#list table.businessObjectMaps as tableMap>
            for (${tableMap.childTableProName?cap_first} ${tableMap.childTableProName?uncap_first} : ${modelObject.modelName?uncap_first}.get${tableMap.childTableProName?cap_first}s()) {
                ${mapperObject.mapperObjName?uncap_first}Mapper.update${tableMap.childTableProName?cap_first}(${tableMap.childTableProName?uncap_first});
                        <#--查找孙子表， 如果子表还有子表，继续循环-->
                            <#list modelObject.businessObjectMaps as boMap>
                                <#if boMap.tableName == tableMap.childTableName>
                for (${boMap.childTableProName?cap_first} ${boMap.childTableProName?uncap_first} : ${tableMap.childTableProName?uncap_first}.get${boMap.childTableProName?cap_first}s()){
                    ${mapperObject.mapperObjName?uncap_first}Mapper.update${boMap.childTableProName?cap_first}(${boMap.childTableProName?uncap_first});
                }
                                </#if>
                            </#list>
            }
                        </#list>
                    </#if>
                </#list>
            </#if>
        }catch(Exception e){
            throw new DBException("5001",e.getMessage());
        }
    }

    @Override
    public void delete${modelObject.modelName?cap_first}(${modelObject.modelName?cap_first} ${modelObject.modelName?uncap_first}){
        try{
            ${mapperObject.mapperObjName?uncap_first}Mapper.delete${modelObject.modelName?cap_first}(${modelObject.modelName?uncap_first});
        }catch(Exception e){
            throw new DBException("5001",e.getMessage());
        }
    }
    </#if>
}