package ${table.packageName};

public interface ${table.tableProperty}Mapper{

    void insert${table.tableProperty}(${table.tableProperty} ${table.tableProperty});

    void insert${childTableProName?cap_first}(${childTableProName?cap_first} ${childTableProName});

    List<${table.tableProperty}> search${table.tableProperty}();

    List<${childTableProName?cap_first}> search${childTableProName?cap_first}(Long docEntry);
}