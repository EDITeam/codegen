package com.avatech.edi.condegen.data;

import com.avatech.edi.condegen.common.BaseException;

public class DataType {
    public static String getDataType(String dataType) {
       if (dataType ==null){
           throw new  BaseException(dataType,"无效的数据类型");
       }
        switch (dataType) {
            case "bott_DocumentLines":
                return "JDBC";
            case "bott_Document":
                return "JDBC";
            case "db_Numeric":
                return "Integer";
            case "db_Alpha":
                return "String";
            case "db_Date":
                return "Date";
            case "db_Float":
                return "Decimal";
            case "db_Memo":
                return "Memo";
            default:
                throw new  BaseException(dataType,"无效的数据类型");
        }

    }

}
