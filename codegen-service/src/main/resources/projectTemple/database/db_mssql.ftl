/**
 * PLEASE KEEP THIS INFOMATION
 * CREATE BY AVATECH EDI CODE TOOL
 * AT ${.now?string["yyyy-MM-dd"]}
 */
<#if tables?has_content>
    <#list tables as tables>
CREATE TABLE ${tables.tableName?lower_case}(
    <#if tables.tableLines?has_content>
    "id" bigint,
    <#if tables.tableType == "bott_Document" || tables.tableType == "bott_MasterData">
    "object_code" varchar(60) NOT NULL COMMENT '对象编码',
    </#if>
    <#if tables.tableType == "bott_Document" || tables.tableType == "bott_MasterData" || tables.tableType == "bott_SimpleData">
    "is_delete" char(1) default N'N',
    "create_date" date NOT NULL ,
    "creator" varchar(60) NOT NULL,
    "modify_date" date,
    "modifier" varchar(60) ,
    </#if>
        <#list tables.tableLines as tableLines>
            <#if tableLines.fieldType == "NVARCHAR" ||tableLines.fieldType == "VARCHAR"||tableLines.fieldType == "NCHAR" ||tableLines.fieldType == "CHAR">
    "${tableLines.fieldName}" ${tableLines.fieldType}(${tableLines.fieldSize}) <#rt>
            <#elseif tableLines.fieldType == "DECIMAL" || tableLines.fieldType == "DOUBLE">
    "${tableLines.fieldName}" ${tableLines.fieldType}(19,2) <#rt>
            <#else >
    "${tableLines.fieldName}" ${tableLines.fieldType} <#rt>
            </#if>
            <#if tableLines.required >
    NOT NULL <#t>
            </#if>
    COMMENT '${tableLines.proDesc}',<#lt>
        </#list>
        <#if tables.tableType == "bott_Document" || tables.tableType == "bott_MasterData" || tables.tableType == "bott_SimpleData">
    PRIMARY KEY ("id")
        </#if>
    </#if>
);
CREATE VIEW ${tables.viewName?lower_case} AS SELECT
<#if tables.tableLines?has_content>
    "id" ,
    <#if tables.tableType == "bott_Document" || tables.tableType == "bott_MasterData">
    "object_code",
    </#if>
    <#if tables.tableType == "bott_Document" || tables.tableType == "bott_MasterData" || tables.tableType == "bott_SimpleData">
    "is_delete" ,
    "create_date",
    "creator",
    "modify_date",
    "modifier",
     </#if>
    <#list tables.tableLines as tableLines>
    "${tableLines.fieldName}" <#if tableLines?has_next>,</#if>
    </#list>
    FROM ${tables.tableName};
</#if>
</#list>

</#if>
