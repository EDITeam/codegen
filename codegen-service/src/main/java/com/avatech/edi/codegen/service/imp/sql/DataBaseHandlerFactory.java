package com.avatech.edi.codegen.service.imp.sql;

import com.avatech.edi.condegen.data.DataBaseType;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DataBaseHandlerFactory implements ApplicationContextAware {

    private static Map<DataBaseType, DataBaseHandler> dataBaseHandlerMap;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, DataBaseHandler> map = applicationContext.getBeansOfType(DataBaseHandler.class);
        dataBaseHandlerMap = new HashMap<>();
        map.forEach((key, value) -> dataBaseHandlerMap.put(value.getDBType(), value));
    }

    public static <T extends DataBaseHandler> T getDataBaseHandler(DataBaseType code) {
        return (T)dataBaseHandlerMap.get(code);
    }

}
