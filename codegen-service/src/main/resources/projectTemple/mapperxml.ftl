<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${mapperObject.packageName}">

    <#if mapperObject.mapperObjectItems?has_content>
        <#list mapperObject.mapperObjectItems as mapperItem>
         <resultMap id="${mapperItem.tableProperty}Map" type="${mapperItem.boPackageName}">
            <#if mapperItem.tableLines?has_content>
                <#list mapperItem.tableLines as mapperItemLine>
                    <result column="${mapperItemLine.fieldName}" property="${mapperItemLine.proName}" jdbcType="${mapperItemLine.fieldType}"/>
                </#list>
            </#if>
         </resultMap>
        </#list>
    </#if>

     <#if mapperObject.mapperObjectItems?has_content>
         <#list mapperObject.mapperObjectItems as mapperItem>

         <insert id="insert${mapperItem.tableProperty?cap_first}" parameterType="${mapperItem.boPackageName}">
             INSERT INTO "${mapperItem.tableName}" (
              <#if mapperItem.tableLines?has_content>
                  <#list mapperItem.tableLines as mapperItemLine>
                     ,"${mapperItemLine.fieldName}"
                  </#list>
              </#if>
             values(
              <#if mapperItem.tableLines?has_content>
                  <#list mapperItem.tableLines as mapperItemLine>
                      #${mapperItemLine.proName}
                  </#list>
              </#if>
             )
         </insert>

         <select id="search${mapperItem.tableProperty?cap_first}" resultMap="${mapperItem.tableProperty}Map">
             SELECT  1
              <#if mapperItem.tableLines?has_content>
                  <#list mapperItem.tableLines as mapperItemLine>
                     ,T0."${mapperItemLine.fieldName}"
                  </#list>
              </#if>
             from "${mapperItem.tableName}" T0
         </select>
         </#list>
     </#if>

</mapper>