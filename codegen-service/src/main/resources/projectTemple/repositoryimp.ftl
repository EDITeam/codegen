package ${mapperObject.packageName}.imp;

<#if mapperObject.mapperObjectItems?has_content>
    <#list mapperObject.mapperObjectItems as mapperItem>
import ${mapperItem.boPackageName};
    </#list>
</#if>
import ${mapperObject.packageName}. ${mapperObject.mapperObjName}Repository
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ${mapperObject.mapperObjName}RepositoryImp implements ${mapperObject.mapperObjName}Repository{
<#if mapperObject.mapperObjectItems?has_content>
    <#list mapperObject.mapperObjectItems as mapperItem>

        private ${mapperObject.packageName}Mapper ${mapperObject.packageName}?Mapper;

        public void save${mapperItem.tableProperty?cap_first}(${mapperItem.tableProperty?cap_first} ${mapperItem.tableProperty}){

        }

        publict List<${mapperItem.tableProperty?cap_first}> fetch${mapperItem.tableProperty?cap_first}s(){

        }
    </#list>
</#if>
}