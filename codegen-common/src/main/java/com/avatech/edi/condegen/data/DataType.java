package com.avatech.edi.condegen.data;

import com.avatech.edi.condegen.common.BaseException;

public class DataType {
    public static String getDataType(String dataType) {

        switch (dataType) {
            case "bott_Document":
                return "JDBC";
            case "db_Numeric":
                return "Integer";
            case "db_Alpha":
                return "String";
            default:
                throw new  BaseException(dataType,"无效的数据类型");
        }

    }

}
