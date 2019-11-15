<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.avatech.dahupt.${projectName}.repository.mapper.TransactionNoticeMapper">
    <resultMap id="ResultMap" type="com.avatech.edi.model.dto.TranscationResult">
        <result column="code" property="code" jdbcType="INTEGER" />
        <result column="message" property="message" jdbcType="VARCHAR" />
    </resultMap>

    <parameterMap type="map" id="paramMap">
        <parameter property="object_type" jdbcType="NVARCHAR" mode="IN"/>
        <parameter property="transaction_type" jdbcType="NVARCHAR" mode="IN"/>
        <parameter property="table_name" jdbcType="INTEGER" mode="IN"/>
        <parameter property="cols_val_tab_del" jdbcType="NVARCHAR" mode="IN"/>
    </parameterMap>

    <select id="callTransactionNotice" statementType="CALLABLE" parameterMap="paramMap" resultMap="ResultMap">
    ${r"{"}call AVA_SP_TransactionNotification(
            #${r"{"}object_code, jdbcType = NVARCHAR, mode = IN${r"}"},
            #${r"{"}transaction_type, jdbcType = NCHAR, mode = IN${r"}"},
            #${r"{"}table_name, jdbcType = NVARCHAR, mode = IN${r"}"},
            #${r"{"}cols_val_tab_del, jdbcType = BIGINT, mode = IN${r"}"}
                )${r"}"}
    </select>


</mapper>