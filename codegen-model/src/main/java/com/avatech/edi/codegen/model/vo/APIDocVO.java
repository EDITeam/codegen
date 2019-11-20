package com.avatech.edi.codegen.model.vo;

import com.avatech.edi.codegen.model.bo.DomainModel;
import com.avatech.edi.codegen.model.bo.Table;
import com.avatech.edi.codegen.model.bo.TableLine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fancy
 * @date 2019/11/20
 * 接口文档View对象
 */
public class APIDocVO {


    public static APIDocVO createAPIDocVO(DomainModel domainModel,String projectName){
        APIDocVO  apiDocVO = new APIDocVO();
        apiDocVO.modelName = domainModel.getModelName();

        apiDocVO.setInquiryUrl("http://IP:PORT/"+projectName.toLowerCase()+"/v1/"+domainModel.getModelName().toLowerCase());
        apiDocVO.setSavingUrl("http://IP:PORT/"+projectName.toLowerCase()+"/v1/"+domainModel.getModelName().toLowerCase());
        apiDocVO.setModificationUrl("http://IP:PORT/"+projectName.toLowerCase()+"/v1/"+domainModel.getModelName().toLowerCase());
        apiDocVO.setDeletionUrl("http://IP:PORT/"+projectName.toLowerCase()+"/v1/"+domainModel.getModelName().toLowerCase());

        for (Table table:domainModel.getTableList()) {
            if(!table.getTableType().equals("bott_MasterDataLine") &&
                    !table.getTableType().equals("bott_DocumentLine") ){
                apiDocVO.modelDesc = table.getTableDes();
            }
            for (TableLine line:table.getTableLines()){
                ParameterVO parameterVO = new ParameterVO();
                parameterVO.setParameterName(line.getJsonProperty());
                parameterVO.setIsRequired(line.isRequired()?"必选":"可选");
                parameterVO.setParameterType(line.getProDataType());
                parameterVO.setParameterDescription(line.getProDesc().replace(" ","").replace("&",""));
                apiDocVO.getInquiryReturnParams().add(parameterVO);
                apiDocVO.getSavingParams().add(parameterVO);
                apiDocVO.getModificationParams().add(parameterVO);
            }
        }

        ParameterVO parameterVO = new ParameterVO();
        parameterVO.setParameterName("id");
        parameterVO.setParameterType("Long");
        parameterVO.setParameterDescription("单据流水号");
        apiDocVO.getInquiryReturnParams().add(parameterVO);

        apiDocVO.setInquiryReturn("");
        apiDocVO.setModificationRequestJson("");
        apiDocVO.setSavingRequestJson("");


        return apiDocVO;
    }

    private static String getParamJson(List<ParameterVO> parameterVOS,boolean isArray){
        StringBuilder stringBuilder = new StringBuilder();
        if(isArray) {
            stringBuilder.append("[");
        }
        for (ParameterVO parameterVO :parameterVOS) {
            stringBuilder.append("\"")
                    .append(parameterVO.getParameterName())
                    .append("\":\"")
            .append(getPropertyValue(parameterVO.getParameterType()))
            .append("\"");

        }

        if(isArray) {
            stringBuilder.append("]");
        }
        return stringBuilder.toString();
    }

    private static Object getPropertyValue(String type){
        switch (type.toLowerCase()){
            case "string":return "";
            case "date":return "2020-01-01";
            case "int":
            case "integer":return 21;
            case "long":return 123456;
            case "bigdecimal":return 1.23;
            default:return "";
        }
    }


    /**
     * 模型名称
     */
    private String modelName;

    /**
     * 模型描述
     */
    private String modelDesc;

    /**
     * 查询url
     */
    private String inquiryUrl;

    /**
     * 查询请求参数
     */
    private List<ParameterVO> inquiryParams;

    /**
     * 查询返回结果示例
     */
    private String inquiryReturn;

    /**
     * 查询返回参数
     */
    private List<ParameterVO> inquiryReturnParams;


    /**
     * 保存url
     */
    private String savingUrl;

    /**
     * 保存请求参数
     */
    private List<ParameterVO> savingParams;

    /**
     * 保存请求示例
     */
    private String savingRequestJson;

    /**
     * 修改url
     */
    private String modificationUrl;

    /**
     * 修改接口参数
     */
    private List<ParameterVO> modificationParams;

    /**
     * 修改请求示例
     */
    private String modificationRequestJson;

    /**
     * 删除url
     */
    private String deletionUrl;

    /**
     * 删除接口参数
     */
    private List<ParameterVO> deletionParams;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelDesc() {
        return modelDesc;
    }

    public void setModelDesc(String modelDesc) {
        this.modelDesc = modelDesc;
    }

    public String getInquiryUrl() {
        return inquiryUrl;
    }

    public void setInquiryUrl(String inquiryUrl) {
        this.inquiryUrl = inquiryUrl;
    }

    public List<ParameterVO> getInquiryParams() {
        if(inquiryParams == null){
            inquiryParams = new ArrayList<>();
        }
        return inquiryParams;
    }

    public void setInquiryParams(List<ParameterVO> inquiryParams) {
        this.inquiryParams = inquiryParams;
    }

    public String getInquiryReturn() {
        return inquiryReturn;
    }

    public void setInquiryReturn(String inquiryReturn) {
        this.inquiryReturn = inquiryReturn;
    }

    public List<ParameterVO> getInquiryReturnParams() {
        if(inquiryReturnParams ==null){
            inquiryReturnParams = new ArrayList<>();
        }
        return inquiryReturnParams;
    }

    public void setInquiryReturnParams(List<ParameterVO> inquiryReturnParams) {
        this.inquiryReturnParams = inquiryReturnParams;
    }

    public String getSavingUrl() {
        return savingUrl;
    }

    public void setSavingUrl(String savingUrl) {
        this.savingUrl = savingUrl;
    }

    public List<ParameterVO> getSavingParams() {
        if(savingParams == null){
            savingParams = new ArrayList<>();
        }
        return savingParams;
    }

    public void setSavingParams(List<ParameterVO> savingParams) {
        this.savingParams = savingParams;
    }

    public String getSavingRequestJson() {
        return savingRequestJson;
    }

    public void setSavingRequestJson(String savingRequestJson) {
        this.savingRequestJson = savingRequestJson;
    }

    public String getModificationUrl() {
        return modificationUrl;
    }

    public void setModificationUrl(String modificationUrl) {
        this.modificationUrl = modificationUrl;
    }

    public List<ParameterVO> getModificationParams() {
        if(modificationParams == null){
            modificationParams = new ArrayList<>();
        }
        return modificationParams;
    }

    public void setModificationParams(List<ParameterVO> modificationParams) {
        this.modificationParams = modificationParams;
    }

    public String getModificationRequestJson() {
        return modificationRequestJson;
    }

    public void setModificationRequestJson(String modificationRequestJson) {
        this.modificationRequestJson = modificationRequestJson;
    }

    public String getDeletionUrl() {
        return deletionUrl;
    }

    public void setDeletionUrl(String deletionUrl) {
        this.deletionUrl = deletionUrl;
    }

    public List<ParameterVO> getDeletionParams() {
        if(deletionParams == null){
            deletionParams = new ArrayList<>();
        }
        return deletionParams;
    }

    public void setDeletionParams(List<ParameterVO> deletionParams) {
        this.deletionParams = deletionParams;
    }
}
