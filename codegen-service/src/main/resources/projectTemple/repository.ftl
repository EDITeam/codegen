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

public interface ${mapperObject.mapperObjName}Repository{
<#if mapperObject.mapperObjectItems?has_content>
    <#list mapperObject.mapperObjectItems as mapperItem>

    void save${mapperItem.tableProperty?cap_first}(${mapperItem.tableProperty?cap_first} ${mapperItem.tableProperty});

    List<${mapperItem.tableProperty?cap_first}> fetch${mapperItem.tableProperty?cap_first}s();
    </#list>
</#if>
}