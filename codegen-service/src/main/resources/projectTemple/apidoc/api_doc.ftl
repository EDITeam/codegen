
/**
*    这是自动化生成showdoc api文档的demo
*/
public class ${apiDocVO.modelName}Service{

    /**
    * showdoc
    * @catalog ${apiDocVO.modelDesc}
    * @title 查询${apiDocVO.modelDesc}
    * @description 用于查询${apiDocVO.modelDesc}的接口
    * @method get
    * @url ${apiDocVO.inquiryUrl}
    * @return ${apiDocVO.inquiryReturn}
<#list apiDocVO.inquiryReturnParams as param>
    * @return_param ${param.parameterName} ${param.parameterType} ${param.parameterDescription}
</#list>
    * @remark 返回结果即为查询结果，如果未查询到结果，返回结果为空。
    * @number 99
    */
    public void fetch(){
    //
    //
    //
    //
    //
    }

    /**
    * showdoc
    * @catalog ${apiDocVO.modelDesc}
    * @title 保存${apiDocVO.modelDesc}
    * @description ${apiDocVO.modelDesc}保存的接口
    * @method post
    * @url ${apiDocVO.savingUrl}
<#list apiDocVO.savingParams as param>
    * @param ${param.parameterName} ${param.isRequired} ${param.parameterType} ${param.parameterDescription}
</#list>
    * @return {"code":0,"message":"OK"}
    * @return_param code string 操作结果编码
    * @return_param message string 操作结果描述
    * @remark 返回结果编码为0代码操作成功，其他值代表失败。
    * @number 99
    */
    public void save(){
    //
    //
    //
    //
    //
    }

    /**
    * showdoc
    * @catalog ${apiDocVO.modelDesc}
    * @title 更新${apiDocVO.modelDesc}
    * @description ${apiDocVO.modelDesc}更新的接口
    * @method put
    * @url ${apiDocVO.modificationUrl}
    * @json_param ${apiDocVO.modificationRequestJson}
<#list apiDocVO.modificationParams as param>
    * @param ${param.parameterName} ${param.isRequired} ${param.parameterType} ${param.parameterDescription}
</#list>
    * @return {"code":0,"message":"OK"}
    * @return_param code string 操作结果编码
    * @return_param message string 操作结果描述
    * @remark 返回结果编码为0代码操作成功，其他值代表失败。
    * @number 99
    */
    public void update(){
    //
    //
    //
    //
    //
    }

    /**
    * showdoc
    * @catalog ${apiDocVO.modelDesc}
    * @title 删除${apiDocVO.modelDesc}
    * @description ${apiDocVO.modelDesc}删除的接口
    * @method delete
    * @url ${apiDocVO.deletionUrl}
    * @param id 必选 long 单据流水号
    * @return {"code":0,"message":"OK"}
    * @return_param code string 操作结果编码
    * @return_param message string 操作结果描述
    * @remark 返回结果编码为0代码操作成功，其他值代表失败。
    * @number 99
    */
    public void delete(){
    //
    //
    //
    //
    //
    }

}
