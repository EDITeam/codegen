<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${mapperObject.packageName}">

    <#if mapperObject.mapperObjectItems?has_content>
        <#list mapperObject.mapperObjectItems as mapperItem>
         <resultMap id="${mapperItem.tableProperty}Map" type="${mapperItem.boPackageName}">
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

         <insert id="insert${mapperItem.tableProperty?cap_first}" parameterType="${mapperItem.boPackageName}">
             INSERT INTO ${quotation}${mapperItem.tableName}${quotation} (
              <#if mapperItem.tableLines?has_content>
              ${quotation}Id${quotation},
                 <#if mapperItem.tableType == "bott_Document" ||  mapperItem.tableType == "bott_MasterData">
                 ${quotation}ObjectCode${quotation},
                 ${quotation}IsDelete${quotation},
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
              <#if mapperItem.tableLines?has_content>
                  <#list mapperItem.tableLines as mapperItemLine>
                     T0.${quotation}${mapperItemLine.fieldName}${quotation}<#if mapperItemLine?has_next>,</#if>
                  </#list>
              </#if>
             from ${quotation}${mapperItem.tableName}${quotation} T0
         </select>

         <update id="update${mapperItem.tableProperty?cap_first}" parameterType="${mapperItem.boPackageName}">
             UPDATE ${quotation}${mapperItem.tableName}${quotation} set
             <#if mapperItem.tableLines?has_content>
                 <#list mapperItem.tableLines as mapperItemLine>
                 ${quotation}${mapperItemLine.fieldName}${quotation} =  #${r"{"}${mapperItemLine.proName?uncap_first}${r"}"} <#if mapperItemLine?has_next>,</#if>
                 </#list>
             </#if>
            WHERE ${quotation}Id${quotation} = #${r"{"}Id${r"}"};
         </update>

         <#if mapperItem.tableType == "bott_Document" ||  mapperItem.tableType == "bott_MasterData">
         <update id="delete${mapperItem.tableProperty?cap_first}" parameterType="${mapperItem.boPackageName}">
             UPDATE ${quotation}${mapperItem.tableName}${quotation} set
         ${quotation}IsDelete${quotation} = 'Y'
             WHERE ${quotation}Id${quotation} = #${r"{"}Id${r"}"};
         </update>
        </#if>
         </#list>
     </#if>

</mapper>