package com.avatech.edi.condegen.data;

import com.avatech.edi.condegen.common.BaseException;

public class DataType {
    public static String getDataType(String dataType) {
       if (dataType ==null){
           throw new  BaseException(dataType,"无效的数据类型");
       }
        switch (dataType) {
            case "db_Numeric":
                return "INTEGER";
//               mapperXml的jdbcType改为VARCHAR，NVARCHAR获取sqlserver会数据转换错误
            case "db_Alpha":
                return "VARCHAR";
            case "db_Date":
                return "DATE";
            case "db_Float":
                return "DECIMAL";
            case "db_Memo":
                return "NCLOB";
            default:
                throw new  BaseException(dataType,"无效的数据类型");
        }

    }

}
