/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/
package ${mapperObject.packageName};


<#if mapperObject.mapperObjectItems?has_content>
    <#list mapperObject.mapperObjectItems as mapperItem>
import ${mapperItem.boPackageName};
    </#list>
</#if>
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface ${mapperObject.mapperObjName}Mapper{
<#if mapperObject.mapperObjectItems?has_content>
    <#list mapperObject.mapperObjectItems as mapperItem>
    int insert${mapperItem.tableProperty?cap_first}(${mapperItem.tableProperty?cap_first} ${mapperItem.tableProperty?uncap_first});
        <#if mapperItem.tableType == "bott_Document" ||  mapperItem.tableType == "bott_MasterData" || mapperItem.tableType == "bott_SimpleData">
    List<${mapperItem.tableProperty?cap_first}> search${mapperItem.tableProperty?cap_first}s();

    List<${mapperItem.tableProperty?cap_first}> search${mapperItem.tableProperty?cap_first}sByView();
        <#else>
    List<${mapperItem.tableProperty?cap_first}> search${mapperItem.tableProperty?cap_first}s(Long id);

    List<${mapperItem.tableProperty?cap_first}> search${mapperItem.tableProperty?cap_first}sByView(Long id);
        </#if>

    int update${mapperItem.tableProperty?cap_first}(${mapperItem.tableProperty?cap_first} ${mapperItem.tableProperty?uncap_first});

    <#if mapperItem.tableType == "bott_Document" ||  mapperItem.tableType == "bott_MasterData" || mapperItem.tableType == "bott_SimpleData">
    int delete${mapperItem.tableProperty?cap_first}(${mapperItem.tableProperty?cap_first} ${mapperItem.tableProperty?uncap_first});
    </#if>
    </#list>
</#if>
}