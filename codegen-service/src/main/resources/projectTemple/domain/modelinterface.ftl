
package ${table.packageName};

import com.avatech.edi.model.bo.I${parentClass};
<#if table.tableType == "bott_MasterData" || table.tableType == "bott_Document">
import java.util.ArrayList;
import java.util.List;
</#if>
import java.math.BigDecimal;
import java.util.Date;

/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/
public interface I${table.tableProperty} extends I${parentClass}{

<#list table.tableLines as tableLine>
    /**
    * 获取${tableLine.proDesc}
    */
    ${tableLine.proDataType} get${tableLine.proName?cap_first}();

    /**
    * 设置${tableLine.proDesc}
    */
    void set${tableLine.proName?cap_first}(${tableLine.proDataType?cap_first} ${tableLine.proName?uncap_first});

</#list>
<#if table.businessObjectMaps?has_content>
    <#list table.businessObjectMaps as childTable>

    List<${childTable.childTableProName}> get${childTable.childTableProName?cap_first}s();

    void set${childTable.childTableProName?cap_first}s(List<${childTable.childTableProName?cap_first}> ${childTable.childTableProName?uncap_first}s);
    </#list>
</#if>
}