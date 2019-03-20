package ${mapperObject.packageName};

public interface ${table.mapperName}{

    void insert${table.tableProperty}(${table.tableProperty} ${table.tableProperty});

    void insert${childTableProName?cap_first}(${childTableProName?cap_first} ${childTableProName});

    List<${table.tableProperty}> search${table.tableProperty}();

    List<${childTableProName?cap_first}> search${childTableProName?cap_first}(Long docEntry);

    <#if mapperObject.mapperObjectItems?has_content>
        <#list mapperObject.mapperObjectItems as mapperItem>
        private List<${mapperItem.childTableProName}> ${childTable.childTableProName}s;
        </#list>
    </#if>
}