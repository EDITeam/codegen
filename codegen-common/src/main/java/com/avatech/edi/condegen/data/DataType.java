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
                return "INT";
            case "db_Alpha":
                return "STRING";
            case "db_Date":
                return "DATE";
            case "db_Float":
                return "DECIMAL";
            case "db_Memo":
                return "Memo";
            default:
                throw new  BaseException(dataType,"无效的数据类型");
        }

    }

}
