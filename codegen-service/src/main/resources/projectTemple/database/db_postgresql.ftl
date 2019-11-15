/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/
<#if tables?has_content>
    <#list tables as tables>
    CREATE TABLE ${tables.tableName}(
        <#if tables.tableLines?has_content>
                "Id" bigint,
            <#if tables.tableType == "bott_Document" || tables.tableType == "bott_MasterData">
                 "IsDelete" char(1) default N'N',
                 "ObjectCode" varchar(60),
            </#if>
            <#list tables.tableLines as tableLines>
                <#if tableLines.fieldType == "NVARCHAR" ||tableLines.fieldType == "VARCHAR"||tableLines.fieldType == "NCHAR" ||tableLines.fieldType == "CHAR">
                "${tableLines.fieldName}" ${tableLines.fieldType}(${tableLines.fieldSize}) <#if tableLines?has_next>,</#if>
                <#elseif tableLines.fieldType == "DECIMAL" || tableLines.fieldType == "DOUBLE">
                "${tableLines.fieldName}" ${tableLines.fieldType}(19,2) <#if tableLines?has_next>,</#if>
                <#else >
                "${tableLines.fieldName}" ${tableLines.fieldType} <#if tableLines?has_next>,</#if>
                </#if>
            </#list>
        </#if>
    );
    CREATE VIEW ${tables.viewName} AS SELECT
        <#if tables.tableLines?has_content>
            "Id" ,
            <#if tables.tableType == "bott_Document" || tables.tableType == "bott_MasterData">
            "IsDelete" ,
            "ObjectCode" ,
            </#if>
            <#list tables.tableLines as tableLines>
            "${tableLines.fieldName}" <#if tableLines?has_next>,</#if>
            </#list>
        FROM ${tables.tableName};
        </#if>
    </#list>

</#if>
