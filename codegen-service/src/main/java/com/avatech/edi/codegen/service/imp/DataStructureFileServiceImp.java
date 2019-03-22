package com.avatech.edi.codegen.service.imp;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.service.IDataStructureFileService;
import com.avatech.edi.codegen.service.config.BusinessServiceException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.apache.commons.io.IOUtils;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据结构文件解析
 */
@Service
public class DataStructureFileServiceImp implements IDataStructureFileService {

    @Override
    public List<DomainModel> readerDataStructureFile(String filePath) {
        if (StringUtils.isEmpty(filePath)) {
            throw new BusinessServiceException("2004", "文件路径为空");
        }
        File file = new File(filePath);
        if (!file.exists()) {
            throw new BusinessServiceException("2005", "无效的数据结构文件路径");
        }
        File[] dataFiles = file.listFiles();
        List<DomainModel> domainModels = new ArrayList<>();

        for (File item : dataFiles) {
            try {
                String xmlStr = IOUtils.toString(new URL(filePath), "UTF-8");
                domainModels.add(getModel(xmlStr));
            } catch (IOException e) {
                throw new BusinessServiceException("2010",String.format("读取文件%s失败:%s",item,e.getCause()));
            }
        }
        return domainModels;
    }

    /**
     * 解析数据结构文件
     * @param xmlStr
     * @return
     */
    private DomainModel getModel(String xmlStr){
        DomainModel domainModel = new DomainModel();

        return domainModel;
    }
}
