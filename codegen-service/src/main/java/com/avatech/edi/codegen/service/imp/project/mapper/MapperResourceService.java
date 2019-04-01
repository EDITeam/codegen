package com.avatech.edi.codegen.service.imp.project.mapper;

import com.avatech.edi.codegen.model.bo.mapperBO.MapperObject;
import com.avatech.edi.codegen.service.config.BusinessServiceException;
import com.avatech.edi.codegen.service.imp.project.CommonService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;

/**
 * Mapper资源服务
 */
@Service
public class MapperResourceService {

    @Autowired
    private CommonService commonService;

    /**
     * 创建mapper资源文件
     */
    public void createMapperResource(MapperObject mapperObject){
        try{
            // TODO 创建文件夹
            String mapperFilePath = mapperObject.getFilePath();
            File file = new File(mapperFilePath);
            file.mkdirs();

            // TODO 创建mapper类
            HashMap root = new HashMap();
            mapperObject.setPackageName(mapperObject.getPackageName() + "."+mapperObject.getMapperObjName()+"Mapper");
            root.put("mapperObject",mapperObject);
            commonService.createTmpleCode(root,mapperFilePath+"/"+mapperObject.getMapperObjName()+"Mapper.xml","mapperxml.ftl");
        }catch (Exception e){
            throw new BusinessServiceException("20012","mapper类型错误");
        }
    }
}
