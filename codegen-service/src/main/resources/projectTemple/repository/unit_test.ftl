package ${mapperObject.packageName};

<#if mapperObject.mapperObjectItems?has_content>
    <#list mapperObject.mapperObjectItems as mapperItem>
import ${mapperItem.boPackageName};
    </#list>
</#if>
import ${mapperObject.packageName}.${mapperObject.mapperObjName}Repository;
import com.avatech.edi.common.data.SnowflakeIdWorker;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.avatech.edi.common.data.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.UUID;

/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ${mapperObject.mapperObjName}RepositoryImpTest {

    @Autowired
    private ${mapperObject.mapperObjName}Repository ${mapperObject.mapperObjName?uncap_first}Repository;

    SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(0,0);

    private Long id;

    private Long getId(){
        if(id == null || id == 0){
            Long id = snowflakeIdWorker.nextId();
            this.id = id;
            return id;
        }else {
            return id;
        }
    }

    private ${mapperObject.mapperObjName} get${mapperObject.mapperObjName}(){
        ${mapperObject.mapperObjName} ${mapperObject.mapperObjName?uncap_first} = new ${mapperObject.mapperObjName}();
        ${mapperObject.mapperObjName?uncap_first}.setId(getId());
        <#if modelObject.tableList?has_content>
            <#list modelObject.tableList as table>
                <#if table.tableProperty == modelObject.modelName && table.businessObjectMaps?has_content>
                    <#list table.businessObjectMaps as tableMap>
        for (int i = 0;i<2;i++) {
            ${tableMap.childTableProName?cap_first} ${tableMap.childTableProName?uncap_first} = new ${tableMap.childTableProName?cap_first}();
            ${tableMap.childTableProName?uncap_first}.setId(getId());
                        <#list modelObject.businessObjectMaps as boMap>
                            <#if boMap.tableName == tableMap.childTableName>
            for (${boMap.childTableProName?cap_first} ${boMap.childTableProName?uncap_first} : ${tableMap.childTableProName?uncap_first}.get${boMap.childTableProName?cap_first}s()){
                ${boMap.childTableProName?cap_first} ${boMap.childTableProName?uncap_first} = new ${boMap.childTableProName?cap_first}();
                ${boMap.childTableProName?uncap_first}.setId(id);
                ${tableMap.childTableProName?uncap_first}.get${boMap.childTableProName?cap_first}s().addAll(${boMap.childTableProName?uncap_first});
            }
                            </#if>
                        </#list>
            ${mapperObject.mapperObjName?uncap_first}.get${tableMap.childTableProName?cap_first}s().add(${tableMap.childTableProName?uncap_first});
        }
                    </#list>
                </#if>
            </#list>
        </#if>
        return  ${mapperObject.mapperObjName?uncap_first};
    }

    @Test
    public void save${mapperObject.mapperObjName}() throws Exception {
        ${mapperObject.mapperObjName} ${mapperObject.mapperObjName?uncap_first} = get${mapperObject.mapperObjName}();
        int rowNumber = ${mapperObject.mapperObjName?uncap_first}Repository.save${mapperObject.mapperObjName}(${mapperObject.mapperObjName?uncap_first});
        Assert.assertEquals(1,rowNumber);
    }

    @Test
    public void fetch${mapperObject.mapperObjName}s() throws Exception {
    }

    @Test
    public void update${mapperObject.mapperObjName}() throws Exception {
        if(id == null){
            save${mapperObject.mapperObjName}();
        }
        ${mapperObject.mapperObjName} ${mapperObject.mapperObjName?uncap_first} = new ${mapperObject.mapperObjName}();
        ${mapperObject.mapperObjName?uncap_first}.setId(getId());
        int rowNumber = ${mapperObject.mapperObjName?uncap_first}Repository.update${mapperObject.mapperObjName}(${mapperObject.mapperObjName?uncap_first});
        Assert.assertEquals(1,rowNumber);
    }

    @Test
    public void delete${mapperObject.mapperObjName}() throws Exception {
        if(id == null){
            save${mapperObject.mapperObjName}();
        }
        ${mapperObject.mapperObjName} ${mapperObject.mapperObjName?uncap_first} = new ${mapperObject.mapperObjName}();
        ${mapperObject.mapperObjName?uncap_first}.setId(getId());
        int rowNumber = ${mapperObject.mapperObjName?uncap_first}Repository.delete${mapperObject.mapperObjName}(${mapperObject.mapperObjName?uncap_first});
        Assert.assertEquals(1,rowNumber);
    }

}