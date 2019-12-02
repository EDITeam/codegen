package ${mapperObject.packageName};

<#if mapperObject.mapperObjectItems?has_content>
    <#list mapperObject.mapperObjectItems as mapperItem>
import ${mapperItem.boPackageName};
    </#list>
</#if>
import java.util.List;

/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/
public interface ${mapperObject.mapperObjName}Repository{


<#if mapperObject.mapperObjectItems?has_content>

    /**
    * 保存
    **/
    Long save${modelObject.modelName?cap_first}(${modelObject.modelName?cap_first} ${modelObject.modelName?uncap_first});

    /**
    * 查询
    **/
    List<${modelObject.modelName?cap_first}> fetch${modelObject.modelName?cap_first}s();

    /**
    * 更新
    **/
    int update${modelObject.modelName?cap_first}(${modelObject.modelName?cap_first} ${modelObject.modelName?uncap_first});

    /**
    * 删除
    **/
    int delete${modelObject.modelName?cap_first}(${modelObject.modelName?cap_first} ${modelObject.modelName?uncap_first});
</#if>
}