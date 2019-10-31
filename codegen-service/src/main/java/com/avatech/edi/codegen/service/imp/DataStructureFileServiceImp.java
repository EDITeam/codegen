package com.avatech.edi.codegen.service.imp;

import com.avatech.edi.codegen.model.bo.BusinessObjectMap;
import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.Table;
import com.avatech.edi.codegen.model.bo.TableLine;
import com.avatech.edi.codegen.service.IDataStructureFileService;
import com.avatech.edi.condegen.data.DataType;
import com.avatech.edi.condegen.exception.BusinessServiceException;
import org.apache.commons.io.IOUtils;
import org.dom4j.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
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
                StringWriter writer = new StringWriter();
                String xmlStr = IOUtils.toString(item.toURI(),"UTF-8");
                domainModels.add(getModel(xmlStr));
            } catch (IOException e) {
                throw new BusinessServiceException("2010",String.format("读取文件%s失败:%s",item,e.getCause()));
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }
        return domainModels;
    }

    /**
     * 解析数据结构文件
     * @param xmlStr
     * @return
     */
    private DomainModel getModel(String xmlStr) throws DocumentException {
        DomainModel domainModel = new DomainModel();
        BusinessObjectMap businessObjectMap;
        Document doc = DocumentHelper.parseText(xmlStr);
        doc.asXML().toString();
        Element element = doc.getRootElement();
        Attribute attribute = element.attribute("Name");
        domainModel.setModelName(attribute.getValue());
        List<Element> nodes = doc.selectNodes("//Table");
        for (Element element1 : nodes) {
            Table table = new Table();
            table.setTableName(element1.attributeValue("Name"));
            table.setTableDes(element1.attributeValue("Description"));
            table.setTableProperty(element1.attributeValue("PropertyName"));
            table.setTableType((1));
            domainModel.getTableList().add(table);

            List<TableLine> tableLineList = new ArrayList<>();
            List<Element> fieldNodes = element1.elements();
            for (Element field : fieldNodes) {
                TableLine tableLine = new TableLine();
                tableLine.setFieldName(field.attributeValue("Name"));
                String dataType = DataType.getDataType(field.attributeValue("DataType"));
                tableLine.setFieldType(dataType);
                tableLine.setProDataType(field.attributeValue("FixedDataType"));
                tableLine.setProDesc(field.attributeValue("Description"));
                tableLine.setTableName(element1.attributeValue("Name"));
                tableLine.setFieldSize(Integer.valueOf(field.attributeValue("EditSize")));
                tableLine.setKey(false);
                tableLine.setProName(field.attributeValue("PropertyName"));
                tableLine.setTableProName(element1.attributeValue("PropertyName"));
                tableLineList.add(tableLine);
            }
            table.setTableLines(tableLineList);
        }


        List<Element> nodes1 = doc.selectNodes("//BusinessObject");

        String childTableName;
        for (Element element1 : nodes1) {
            Element chid = element1.element("ChildTables");
            List<Element> childNodeList = chid.elements("ChildTable");
            for (Element childNode : childNodeList) {
                businessObjectMap = new BusinessObjectMap();
                businessObjectMap.setObjectCode(element1.attributeValue("Code"));
                businessObjectMap.setTableProName(element1.attributeValue("PropertyName"));
                businessObjectMap.setTableName(element1.attributeValue("TableName"));
                childTableName = childNode.attributeValue("TableName");
                businessObjectMap.setChildTableNames(childTableName);
                businessObjectMap.setChildTableProName(getChildTable(domainModel,childTableName).getTableProperty());
                domainModel.getBusinessObjectMaps().add(businessObjectMap);
            }
        }

        return domainModel;
    }

    private Table getChildTable(DomainModel model,String tableName){
        if(model == null || StringUtils.isEmpty(tableName)){
            return null;
        }
        for (Table table:model.getTableList()) {
            if(table.getTableName().equals(tableName)){
                return table;
            }
        }
        return null;
    }
}
