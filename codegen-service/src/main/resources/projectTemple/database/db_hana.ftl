/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/
<#if tables?has_content>
    <#list tables as tables>
    CREATE TABLE ${tables.tableName?lower_case}(
        <#if tables.tableLines?has_content>
            "id" BIGINT  COMMENT '主键',
            <#if tables.tableType == "bott_DocumentLines" || tables.tableType == "bott_MasterDataLines" || tables.tableType == "bott_SimpleDataLines">
            "line_id" INT NOT NULL COMMENT '行号',
            </#if>
            <#if tables.tableType == "bott_Document">
            "object_code" varchar(60) NOT NULL COMMENT '对象编码',
            "doc_date" date NOT NULL COMMENT '单据日期',
            </#if>
            <#if tables.tableType == "bott_MasterData" >
            "object_code" varchar(60) NOT NULL COMMENT '对象编码',
            "code" varchar(60) NOT NULL COMMENT '代码',
            "name" varchar(100) NOT NULL COMMENT '名称',
            </#if>
            <#if tables.tableType == "bott_Document" || tables.tableType == "bott_MasterData" || tables.tableType == "bott_SimpleData">
            "is_delete" char(1) default N'N' COMMENT '删除标志 Y:已删除，N：未删除',
            "create_date" timestamp NOT NULL COMMENT '创建时间',
            "creator" varchar(60) NOT NULL COMMENT '创建人',
            "modify_date" timestamp COMMENT '最后修改时间',
            "modifier" varchar(60) COMMENT '最后修改人',
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
        "id",
        <#if tables.tableType == "bott_DocumentLines" || tables.tableType == "bott_MasterDataLines" || tables.tableType == "bott_SimpleDataLines">
        "line_id",
        </#if>
        <#if tables.tableType == "bott_Document">
        "object_code",
        "doc_date",
        </#if>
        <#if tables.tableType == "bott_MasterData" >
        "object_code",
        "code",
        "name",
        </#if>
        <#if tables.tableType == "bott_Document" || tables.tableType == "bott_MasterData" || tables.tableType == "bott_SimpleData">
        "is_delete" ,
        "create_date",
        "creator",
        "modify_date",
        "modifier",
        </#if>
        <#if tables.tableLines?has_content>
            <#list tables.tableLines as tableLines>
        "${tableLines.fieldName}" <#if tableLines?has_next>,</#if>
            </#list>
        FROM ${tables.tableName};
        </#if>
    </#list>

</#if>
