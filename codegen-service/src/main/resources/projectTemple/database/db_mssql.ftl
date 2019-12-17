/**
 * PLEASE KEEP THIS INFOMATION
 * CREATE BY AVATECH EDI CODE TOOL
 * AT ${.now?string["yyyy-MM-dd"]}
 */
<#if tables?has_content>
    <#list tables as tables>
CREATE TABLE ${tables.tableName}(
    <#if tables.tableLines?has_content>
    "id" bigint,
    <#if tables.tableType == "bott_Document" || tables.tableType == "bott_MasterData" || tables.tableType == "bott_SimpleData">
    "is_delete" char(1) default N'N',
    "object_code" varchar(60),
    "create_date" timestamp,
    "creator" varchar(60),
    "modify_date" timestamp,
    "modifier" varchar(60),
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
    "id" ,
    <#if tables.tableType == "bott_Document" || tables.tableType == "bott_MasterData" || tables.tableType == "bott_SimpleData">
    "is_delete" ,
    "object_code",
    "create_date" timestamp,
    "creator" varchar(60),
    "modify_date" timestamp,
    "modifier" varchar(60),
     </#if>
    <#list tables.tableLines as tableLines>
    "${tableLines.fieldName}" <#if tableLines?has_next>,</#if>
    </#list>
    FROM ${tables.tableName};
</#if>
</#list>

</#if>
