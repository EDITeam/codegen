<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${table.tableProperty}">

    <resultMap id="BuyerInformation" type="com.avatech.edi.bluestar.model.bo.account.BuyerInformation">
        <#list table.tableLines as tableLine>
        <result column="${tableLine.proName}" property="${tableLine.proName}" jdbcType="${tableLine.proDataType}"/>
        </#list>
    </resultMap>

    <#if table.businessObjectMaps?has_content>
        <#list table.businessObjectMaps as childTable>
    private List<${childTable.childTableProName}> ${childTable.childTableProName}s;

        </#list>
    </#if>
    <resultMap id="AccountPostItemMap" type="com.avatech.edi.bluestar.model.bo.account.AccountPostItem">
        <result column="payAmountNum" property="payAmountNum" jdbcType="VARCHAR"/>
        <result column="lineName" property="lineName" jdbcType="VARCHAR"/>
        <result column="arriveDate" property="arriveDate" jdbcType="VARCHAR"/>
        <result column="amount" property="amount" jdbcType="VARCHAR"/>
        <result column="extend1" property="extend1" jdbcType="VARCHAR"/>
        <result column="extend2" property="extend2" jdbcType="VARCHAR"/>
        <result column="extend3" property="extend3" jdbcType="VARCHAR"/>
        <result column="extend4" property="extend4" jdbcType="VARCHAR"/>
        <result column="extend5" property="extend5" jdbcType="VARCHAR"/>
    </resultMap>

    <select id="searchBuyerInformation" resultMap="BuyerInformation" parameterType="Map">
        select T1."buyerSapCode", T1."sellerSapCode",T1."operationType",T1."payAmountNum",T1."extend1",
        T1."extend2",T1."extend3",T1."extend4",T1."extend5"
        from AVA_VIEW_EC_ORCT T1 where T1."buyerSapCode" = #{buyerSapCode} and T1."payAmountNum" = #{payAmountNum}
    </select>

    <select id="searchBuyerItemInformation" resultMap="AccountPostItemMap" parameterType="Map">
        select T2."lineName",T2."arriveDate",T2."amount",T2."payAmountNum",T2."extend1",T2."extend2",T2."extend3",
        T2."extend4",T2."extend5"
        from AVA_VIEW_EC_RCT1 T2 where T2."payAmountNum" = #{payAmountNum} and T2."buyerSapCode" = #{buyerSapCode}
    </select>
</mapper>