package ${table.packageName};

public class ${table.tableProperty}{

<#list table.tableLines as tableLine>
    private ${tableLine.proDataType} ${tableLine.proName};

</#list>

<#if table.businessObject?has_content>
    <#list table.tableLines.childTableProNames as childTableProName>
    private List<${childTableProName}> ${childTableProName}s;

    </#list>
</#if>

<#list table.tableLines as tableLine>
    public ${tableLine.proDataType} get${tableLine.proName?cap_first}() {
        return ${tableLine.proName};
    }

    public void set${tableLine.proName?cap_first}(${tableLine.proDataType} ${tableLine.proName}) {
        this.${tableLine.proName} = ${tableLine.proName};
    }

    <#if table.businessObject?has_content>
        <#list table.tableLines.childTableProNames as childTableProName>
    public List<${childTableProName}> get${childTableProName?cap_first}() {
        return ${childTableProName}s;
    }

    public void set${childTableProName?cap_first}(List<${childTableProName}> ${childTableProName}s) {
        this.${childTableProName}s = ${childTableProName}s;
    }
        </#list>
    </#if>
</#list>
}
