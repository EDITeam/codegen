<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${mapperObject.packageName}">

<#if mapperObject.mapperObjectItems?has_content>
    <#list mapperObject.mapperObjectItems as mapperItem>
    <resultMap id="${mapperItem.tableProperty}Map" type="${mapperItem.boPackageName}">
        <result column="id" property="id" jdbcType="BIGINT"/>
            <#if mapperItem.tableLines?has_content>
                <#list mapperItem.tableLines as mapperItemLine>
        <result column="${mapperItemLine.fieldName}" property="${mapperItemLine.proName?uncap_first}" jdbcType="${mapperItemLine.fieldType}"/>
                </#list>
            </#if>
    </resultMap>
    </#list>
</#if>

<#if mapperObject.mapperObjectItems?has_content>

    <#list mapperObject.mapperObjectItems as mapperItem>
    <sql id="${mapperItem.tableProperty?cap_first}Columns">
        T0.${quotation}id${quotation},
        <#if mapperItem.tableLines?has_content>
            <#if mapperItem.tableType == "bott_Document" ||  mapperItem.tableType == "bott_MasterData">
        T0.${quotation}object_code${quotation},
            </#if>
            <#list mapperItem.tableLines as mapperItemLine>
        T0.${quotation}${mapperItemLine.fieldName}${quotation}<#if mapperItemLine?has_next>,</#if>
            </#list>
        </#if>
    </sql>
    </#list>

    <#list mapperObject.mapperObjectItems as mapperItem>
    <insert id="insert${mapperItem.tableProperty?cap_first}" parameterType="${mapperItem.boPackageName}">
        INSERT INTO ${quotation}${mapperItem.tableName}${quotation} (
        <#if mapperItem.tableLines?has_content>
        ${quotation}id${quotation},
            <#if mapperItem.tableType == "bott_Document" ||  mapperItem.tableType == "bott_MasterData">
            ${quotation}object_code${quotation},
            </#if>
            <#if mapperItem.tableType == "bott_Document" ||  mapperItem.tableType == "bott_MasterData" ||mapperItem.tableType == "bott_SimpleData">
            ${quotation}create_date${quotation},
            ${quotation}creator${quotation},
            ${quotation}modifier${quotation},
            ${quotation}modify_date${quotation},
            ${quotation}is_delete${quotation},
            </#if>
            <#list mapperItem.tableLines as mapperItemLine>
            ${quotation}${mapperItemLine.fieldName}${quotation}<#if mapperItemLine?has_next>,</#if>
            </#list>
        </#if>)
        values(
        <#if mapperItem.tableLines?has_content>
                #${r"{"}id${r"}"},
            <#if mapperItem.tableType == "bott_Document" ||  mapperItem.tableType == "bott_MasterData">
                #${r"{"}objectCode${r"}"},
            </#if>
            <#if mapperItem.tableType == "bott_Document" ||  mapperItem.tableType == "bott_MasterData" ||mapperItem.tableType == "bott_SimpleData">
                #${r"{"}createDate${r"}"},
                #${r"{"}creator${r"}"},
                #${r"{"}modifier${r"}"},
                #${r"{"}modifyDate${r"}"},
                #${r"{"}isDelete.key${r"}"},
            </#if>
            <#list mapperItem.tableLines as mapperItemLine>
                #${r"{"}${mapperItemLine.proName?uncap_first}${r"}"}<#if mapperItemLine?has_next>,</#if>
            </#list>
        </#if>
        )
    </insert>

    <select id="search${mapperItem.tableProperty?cap_first}s" resultMap="${mapperItem.tableProperty}Map">
        SELECT
        <include refid="${mapperItem.tableProperty?cap_first}Columns"/>
        FROM ${quotation}${mapperItem.tableName}${quotation} T0
        <#if mapperItem.tableType == "bott_DocumentLines" ||  mapperItem.tableType == "bott_MasterDataLines" || mapperItem.tableType == "bott_SimpleDataLines">
        WHERE T0.${quotation}id${quotation} = #${r"{"}id${r"}"}
        </#if>
    </select>

    <select id="search${mapperItem.tableProperty?cap_first}sByView" resultMap="${mapperItem.tableProperty}Map">
        SELECT  T0.${quotation}id${quotation},
        <include refid="${mapperItem.tableProperty?cap_first}Columns"/>
        from ${quotation}${mapperItem.viewName}${quotation} T0
    </select>

    <update id="update${mapperItem.tableProperty?cap_first}" parameterType="${mapperItem.boPackageName}">
        UPDATE ${quotation}${mapperItem.tableName}${quotation}
            <set>
        <#if mapperItem.tableLines?has_content>
            <#list mapperItem.tableLines as mapperItemLine>
            <if test="${mapperItemLine.proName?uncap_first} != null">
            ${quotation}${mapperItemLine.fieldName}${quotation} =  #${r"{"}${mapperItemLine.proName?uncap_first}${r"}"},
            </if>
            </#list>
            <#if mapperItem.tableType == "bott_Document" ||  mapperItem.tableType == "bott_MasterData" || mapperItem.tableType == "bott_SimpleData">
            ${quotation}modifier${quotation} = #${r"{"}modifier${r"}"},
            ${quotation}modify_date${quotation} = #${r"{"}modifyDate${r"}"}
            </#if>
        </#if>
            </set>
        WHERE ${quotation}id${quotation} = #${r"{"}id${r"}"};
    </update>

        <#if mapperItem.tableType == "bott_Document" ||  mapperItem.tableType == "bott_MasterData" || mapperItem.tableType == "bott_SimpleData">
    <delete id="delete${mapperItem.tableProperty?cap_first}" parameterType="${mapperItem.boPackageName}">
        UPDATE ${quotation}${mapperItem.tableName}${quotation} set
        ${quotation}is_delete${quotation} = 'Y'
        WHERE ${quotation}id${quotation} = #${r"{"}id${r"}"};
    </delete>
        </#if>
    </#list>
</#if>

</mapper>