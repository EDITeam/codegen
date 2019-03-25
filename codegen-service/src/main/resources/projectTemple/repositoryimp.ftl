/**
 * PLEASE KEEP THIS INFOMATION
 * CREATE BY AVATECH EDI CODE TOOL
 * AT ${.now?string["yyyy-MM-dd"]}
 */
package ${mapperObject.packageName}.imp;

<#if mapperObject.mapperObjectItems?has_content>
    <#list mapperObject.mapperObjectItems as mapperItem>
import ${mapperItem.boPackageName};
    </#list>
</#if>
import com.avatech.edi.productionorder.mapper.${mapperObject.mapperObjName}Mapper;
import ${mapperObject.packageName}.${mapperObject.mapperObjName}Repository;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Component
public class ${mapperObject.mapperObjName}RepositoryImp implements ${mapperObject.mapperObjName}Repository{
<#if mapperObject.mapperObjectItems?has_content>
    @Autowired
    private ${mapperObject.mapperObjName}Mapper ${mapperObject.mapperObjName?uncap_first}Mapper;

    <#list mapperObject.mapperObjectItems as mapperItem>

    public void save${mapperItem.tableProperty?cap_first}(${mapperItem.tableProperty?cap_first} ${mapperItem.tableProperty?uncap_first}){
        ${mapperObject.mapperObjName?uncap_first}Mapper.insert${mapperItem.tableProperty?cap_first}(${mapperItem.tableProperty?uncap_first});

    }

    public List<${mapperItem.tableProperty?cap_first}> fetch${mapperItem.tableProperty?cap_first}s(){
        List<${mapperItem.tableProperty?cap_first}> ${mapperItem.tableProperty?uncap_first}s = new ArrayList();
        ${mapperItem.tableProperty?uncap_first}s = ${mapperObject.mapperObjName?uncap_first}Mapper.search${mapperItem.tableProperty?cap_first}s();
        return ${mapperItem.tableProperty?uncap_first}s;
    }
    </#list>
</#if>
}