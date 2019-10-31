package com.avatech.edi.codegen.service;

import com.avatech.edi.codegen.model.bo.DomainModel;

import java.util.List;

public interface IDataStructureFileService {

    /**
     * 读取数据结构文件 获取领域模型
     * @param filePath 数据结构路径
     * @return
     */
    List<DomainModel> readerDataStructureFile(String filePath);


}
