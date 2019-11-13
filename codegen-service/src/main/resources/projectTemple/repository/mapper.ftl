package ${mapperObject.packageName};


<#if mapperObject.mapperObjectItems?has_content>
    <#list mapperObject.mapperObjectItems as mapperItem>
import ${mapperItem.boPackageName};
    </#list>
</#if>
import org.springframework.stereotype.Component;
import java.util.List;

/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/
@Component
public interface ${mapperObject.mapperObjName}Mapper{
<#if mapperObject.mapperObjectItems?has_content>
    <#list mapperObject.mapperObjectItems as mapperItem>

    void insert${mapperItem.tableProperty?cap_first}(${mapperItem.tableProperty?cap_first} ${mapperItem.tableProperty?uncap_first});

    List<${mapperItem.tableProperty?cap_first}> search${mapperItem.tableProperty?cap_first}s();

    void update${mapperItem.tableProperty?cap_first}(${mapperItem.tableProperty?cap_first} ${mapperItem.tableProperty?uncap_first});

    void delete${mapperItem.tableProperty?cap_first}(${mapperItem.tableProperty?cap_first} ${mapperItem.tableProperty?uncap_first});
    </#list>
</#if>
}