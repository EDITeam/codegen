package ${table.packageName};

import com.avatech.edi.model.bo.${parentClass};
import com.avatech.edi.common.data.EmYesOrNo;
import java.util.Date;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnore;
<#if table.tableType == "bott_MasterData" || table.tableType == "bott_Document">
import java.util.ArrayList;
import java.util.List;
</#if>

/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/
public class ${table.tableProperty} extends ${parentClass} implements I${table.tableProperty}{

<#if table.tableType == "bott_MasterData" || table.tableType == "bott_Document">

    private final String OBJECT_CODE = "";

    /**
    * 业务对象编码
    **/
    @JsonIgnore
    private String objectCode;

    /**
    * 是否删除
    **/
    @JsonIgnore
    private EmYesOrNo isDelete;
</#if>
<#list table.tableLines as tableLine>

    <#if tableLine.proDesc?has_content>
    /**
     * ${tableLine.proDesc}
     */
   </#if>
    private ${tableLine.proDataType} ${tableLine.proName?uncap_first};

</#list>

<#if table.businessObjectMaps?has_content>
    <#list table.businessObjectMaps as childTable>
    private List<${childTable.childTableProName}> ${childTable.childTableProName?uncap_first}s;
    </#list>
</#if>

<#list table.tableLines as tableLine>
     /**
     * 获取${tableLine.proDesc}
     */
    @Override
    public ${tableLine.proDataType} get${tableLine.proName?cap_first}() {
        return ${tableLine.proName?uncap_first};
    }

    /**
     * 设置${tableLine.proDesc}
     */
    @Override
    public void set${tableLine.proName?cap_first}(${tableLine.proDataType?cap_first} ${tableLine.proName?uncap_first}) {
        this.${tableLine.proName?uncap_first} = ${tableLine.proName?uncap_first};
    }
</#list>
<#if table.businessObjectMaps?has_content>
    <#list table.businessObjectMaps as childTable>

    @Override
    public List<${childTable.childTableProName?cap_first}> get${childTable.childTableProName?cap_first}s() {
        if(${childTable.childTableProName?uncap_first}s == null){
            ${childTable.childTableProName?uncap_first}s = new ArrayList<>();
        }
        return ${childTable.childTableProName?uncap_first}s;
    }

    @Override
    public void set${childTable.childTableProName?cap_first}s(List<${childTable.childTableProName?cap_first}> ${childTable.childTableProName?uncap_first}s) {
        this.${childTable.childTableProName?uncap_first}s = ${childTable.childTableProName?uncap_first}s;
    }
    </#list>
</#if>


<#if table.tableType == "bott_MasterData" || table.tableType == "bott_Document">
    @Override
    public String getObjectCode() {
        return objectCode;
    }

    @Override
    public EmYesOrNo getIsDelete() {
        return isDelete;
    }

    @Override
    public void setIsDelete(EmYesOrNo isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public void initial() {
        this.objectCode = OBJECT_CODE;
        setIsDelete(EmYesOrNo.NO);
    }

    @Override
    public void check() {

    }
</#if>
}
