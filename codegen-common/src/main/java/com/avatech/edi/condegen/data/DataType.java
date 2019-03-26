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
            case "db_Alpha":
                return "NVARCHAR";
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
