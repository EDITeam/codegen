package ${mapperObject.packageName}.service;

<#if mapperObject.mapperObjectItems?has_content>
    <#list mapperObject.mapperObjectItems as mapperItem>
    import ${mapperItem.boPackageName};
    </#list>
</#if>
import ${mapperObject.packageName}.model.bo.${mapperObject.mapperObjName?lower_case}.${mapperObject.mapperObjName};
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.swing.*;
import java.util.Date;
import static org.junit.Assert.*;


/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ${mapperObject.mapperObjName}ServiceTest {

    @Autowired
    private ${mapperObject.mapperObjName}Service ${mapperObject.mapperObjName?uncap_first}Service;

    private ${mapperObject.mapperObjName} get${mapperObject.mapperObjName}(){
        ${mapperObject.mapperObjName} ${mapperObject.mapperObjName?uncap_first} = new ${mapperObject.mapperObjName}();
        ${mapperObject.mapperObjName?uncap_first}.setId(UUID.randomUUID());
        return ${mapperObject.mapperObjName?uncap_first};
    }

    //服务类保存方法 未抛出异常即是保存成功
    //如果需要测试异常，采用以下方式
    /* example
    @Test(expected = DBException.class)
        publicvoid saveDBException() {
        BO bo = getBO();
        service.save(bo);
    }
    */

    @Test
    public void save() throws Exception {
        ${mapperObject.mapperObjName} ${mapperObject.mapperObjName?uncap_first} = get${mapperObject.mapperObjName}();
        ${mapperObject.mapperObjName?uncap_first}Service.save(${mapperObject.mapperObjName?uncap_first});
    }

    @Test
    public void update() throws Exception {
        ${mapperObject.mapperObjName} ${mapperObject.mapperObjName?uncap_first} = get${mapperObject.mapperObjName}();

        ${mapperObject.mapperObjName?uncap_first}.setId(UUID.randomUUID());
        ${mapperObject.mapperObjName?uncap_first}Service.save(${mapperObject.mapperObjName?uncap_first});

        //update
        //${mapperObject.mapperObjName?uncap_first}.setPurpose("test");
        ${mapperObject.mapperObjName?uncap_first}Service.update(${mapperObject.mapperObjName?uncap_first});
    }

    @Test
    public void delete() {
        ${mapperObject.mapperObjName} ${mapperObject.mapperObjName?uncap_first} = get${mapperObject.mapperObjName}();

        ${mapperObject.mapperObjName?uncap_first}.setId(UUID.randomUUID());
        ${mapperObject.mapperObjName?uncap_first}Service.save(${mapperObject.mapperObjName?uncap_first});
        ${mapperObject.mapperObjName?uncap_first}Service.delete(${mapperObject.mapperObjName?uncap_first});
    }

}