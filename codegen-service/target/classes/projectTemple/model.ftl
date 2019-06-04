/**
 * PLEASE KEEP THIS INFOMATION
 * CREATE BY AVATECH EDI CODE TOOL
 * AT ${.now?string["yyyy-MM-dd"]}
 */
package ${table.packageName};
<#if table.businessObjectMaps?has_content>
import java.util.ArrayList;
import java.util.List;
</#if>
import com.fasterxml.jackson.annotation.JsonProperty;

public class ${table.tableProperty}{

<#list table.tableLines as tableLine>

    <#if tableLine.proDesc?has_content>
    /**
     * ${tableLine.proDesc}
     */
   </#if>
    @JsonProperty(value = "${tableLine.proName}")
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
    public ${tableLine.proDataType} get${tableLine.proName?cap_first}() {
        return ${tableLine.proName?uncap_first};
    }

    /**
     * 设置${tableLine.proDesc}
     */
    public void set${tableLine.proName?cap_first}(${tableLine.proDataType?cap_first} ${tableLine.proName?uncap_first}) {
        this.${tableLine.proName?uncap_first} = ${tableLine.proName?uncap_first};
    }
</#list>
<#if table.businessObjectMaps?has_content>
    <#list table.businessObjectMaps as childTable>

    public List<${childTable.childTableProName}> get${childTable.childTableProName?uncap_first}s() {
        if(${childTable.childTableProName?uncap_first}s == null){
            ${childTable.childTableProName?uncap_first}s = new ArrayList<>();
        }
        return ${childTable.childTableProName?uncap_first}s;
    }

    public void set${childTable.childTableProName?cap_first}s(List<${childTable.childTableProName?cap_first}> ${childTable.childTableProName?uncap_first}s) {
        this.${childTable.childTableProName?uncap_first}s = ${childTable.childTableProName?uncap_first}s;
    }
    </#list>
</#if>
}
