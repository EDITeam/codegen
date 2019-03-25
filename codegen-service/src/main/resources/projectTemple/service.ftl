package ${mapperObject.packageName}.service;

<#if mapperObject.mapperObjectItems?has_content>
    <#list mapperObject.mapperObjectItems as mapperItem>
import ${mapperItem.boPackageName};
    </#list>
</#if>
import ${mapperObject.packageName}.repository.${mapperObject.mapperObjName}Repository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ${mapperObject.mapperObjName}Service{
<#if mapperObject.mapperObjectItems?has_content>

</#if>
}