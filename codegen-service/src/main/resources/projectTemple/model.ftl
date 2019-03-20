package ${table.packageName};

public class ${table.tableProperty}{

<#list table.tableLines as tableLine>

    <#if tableLine.proDesc?has_content>
    /**
     * ${tableLine.proDesc}
     */
   </#if>
    private ${tableLine.proDataType} ${tableLine.proName};

</#list>

<#if table.businessObjectMaps?has_content>
    <#list table.businessObjectMaps as childTable>
    private List<${childTable.childTableProName}> ${childTable.childTableProName}s;

    </#list>
</#if>

<#list table.tableLines as tableLine>
    public ${tableLine.proDataType} get${tableLine.proName?cap_first}() {
        return ${tableLine.proName};
    }

    public void set${tableLine.proName?cap_first}(${tableLine.proDataType} ${tableLine.proName}) {
        this.${tableLine.proName} = ${tableLine.proName};
    }

    <#if table.businessObjectMaps?has_content>
        <#list table.businessObjectMaps as childTable>
    public List<${childTable.childTableProName}> get${childTable.childTableProName?cap_first}s() {
        return ${childTable.childTableProName}s;
    }

    public void set${childTable.childTableProName?cap_first}s(List<${childTable.childTableProName}> ${childTable.childTableProName}s) {
        this.${childTable.childTableProName}s = ${childTable.childTableProName}s;
    }
        </#list>
    </#if>
</#list>
}
