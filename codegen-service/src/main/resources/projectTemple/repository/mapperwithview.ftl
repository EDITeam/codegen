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

    void insert${mapperItem.tableProperty?cap_first}(${mapperItem.tableProperty?cap_first} ${mapperItem.tableProperty});

    List<${mapperItem.tableProperty?cap_first}> search${mapperItem.tableProperty?cap_first}s();

    List<${mapperItem.tableProperty?cap_first}> search${mapperItem.tableProperty?cap_first}sByView();
    </#list>
</#if>
}