[TOC]

# 中信国安易购 *SAPBusinessOne* 系统 *WebAPI* 规则及调用

## 技术标准

+ 网络传输协议(*network-protocol*) : ***HTTP***

+ 接口对接方式(*service-type*) : ***REST-API***

+ 通信方式(*communication-method*) : ***同步(Synchronous)***

+ 数据格式(*data-type*) : ***JSON***

+ 字符集编码格式(*characterset-encode*) : ***UTF-8***

+ 数据内容格式标准(*content-data-standard*)

- 日期类型(*date*) : ***YYYY-MM-DD*** <u>(***数据类型为字符串,Type : String***)</u>

- 浮点类型(*double/decimal*) : ***d.dd*** <u>(***保留两位小数***)</u>

## 接口列表及参数

### 接口参数总览

+ 访问方式(*network-access*) : ***LAN (局域网)***

+ 地址(*URL*) : ***10.249.0.66***

+ 端口(*port*) :

- 测试环境 : ***7070***

- 生产环境 : ***待定***

+ 签名(signature)

- 加密方式(*encryption*) : ***MD5***

- 加密盐值(*salt*) : ***AVATECH-ZXDS***

- 格式(*formatter*) : ***endpoint-date-salt***

*Example :*
``` for example
endpoint : http://10.249.0.66:7070/v1/Materials
call-date : 2019-4-2
signature(before-encrypted) : Materials-20190402-AVATECH-ZXDS
signature(after-encrypted) : 961a49d2aaf173b72c1d91eb3fb67d5b
```

+ 返回值列表(*out-parameters*)

- 返回值列表清单(value-list)

\#|error_code|error_message|comments
---|---|---|---
1|0|Ok|成功
2|101|待定|待定
...|...|...|...

### forERP( *ERP => SAP* )

#### 物料主数据(*materials*)

+ 路径(*endpoint*) : ***http://10.249.0.66:7070/v1/Materials***

+ 操作类型(*http-method*) : ***POST***

+ 传入参数列表(*input-parameters*) :

``` input parameters
{
"signature": "",
"data": [
{
"item_no": "",
"item_name": "",
"item_subno": "",
"purchase_tax": 0.80,
"sale_tax": 0.17,
"spec_type": "",
"item_brandno": "",
"item_brandname": "",
"item_clsno": "",
"item_clsname": "",
"unit_no": "",
"stock_type": "",
"is_pre_elimination": "",
"price_list": [
{
"branch_no": "",
"branch_name": "",
"purchase_unit_no":"",
"po_qty":1.00,
"purchase_price":20.00,
"max_stock_qty":30.00,
"min_stock_qty":1.00,
"supcust_no" : "",
"supply_institution":"",
"sale_way":"",
"delivery_type":"",
"pro_code1":0.00,
"pro_code2":""
}
]
}
]
}
```

+ 返回参数列表(*output-parameters*) :

``` output parameters
{
"error_data": [
{
"item_no": "M1001",
"error_code": 0,
"error_message": "Ok"
},
{
"item_no": "M1002",
"error_code": 102,
"error_message": "Data type is invalid!"
}
]
}
```

#### 客户主数据(*customers*)

+ 路径(*endpoint*) : ***http://10.249.0.66:7070/v1/Customers***

+ 操作类型(*http-method*) : ***POST***

+ 传入参数列表(*input-parameters*) :

``` input parameters
{
"signature": "",
"data": [
{
"branch_no": "",
"branch_name ": "",
"ext_code": "",
"defaultyhbranch_info": "",
"branch_man": "",
"branch_tel": "",
"address": "",
"credit_num": "",
"arrears_flag": "",
"tax_no": "",
"bank_account": "",
"company_address": "",
"invoice_address": "",
"apply_state": "",
"pro_code1": ""
}
]
}
```

+ 返回参数列表(*output-parameters*) :

``` output parameters
{
"error_data": [
{
"branch_no": "C1001",
"error_code": 0,
"error_message": "Ok"
},
{
"branch_no": "C1002",
"error_code": 102,
"error_message": "Data type is invalid!"
}
]
}
```

#### 供应商主数据(vendors)

+ 路径(*endpoint*) : ***http://10.249.0.66:7070/v1/Vendors***

+ 操作类型(*http-method*) : ***POST***

+ 传入参数列表(*input-parameters*) :

``` input parameters
{
"signature": "",
"data": [
{
"supcust_no": "",
"supcust_name": "",
"organization_code": "",
"default_purchase_price": "",
"supcust_delivery_type": "",
"region_no": "",
"sale_way": "",
"amt_type": "",
"settle_day": 30,
"sup_acct_back": "",
"sup_acct_no": "",
"sup_man": "",
"sup_tel": "",
"zip": "",
"sup_email": "",
"sup_fax": "",
"taxpayer_no": "",
"sup_addr": "",
"brand_des": ""
}
]
}
```

+ 返回参数列表(*output-parameters*) :

``` output parameters
{
"error_data": [
{
"supcust_no": "V1001",
"error_code": 0,
"error_message": "Ok"
},
{
"supcust_no": "V1002",
"error_code": 102,
"error_message": "Data type is invalid!"
}
]
}
```

#### 采购收货单

+ 路径(*endpoint*) : ***http://10.249.0.66:7070/v1/PurchaseDeliveryNotes***

+ 操作类型(*http-method*) : ***POST***

+ 传入参数列表(*input-parameters*) :

``` input parameters
{
"signature": "",
"data": [
{
"sheet_no": "",
"create_date": "",
"ext_sheet_no": "",
"lines": [
{
"ext_sheet_no": "",
"POline_num": "",
"real_qty": ""
}
]
}
]
}
```

+ 返回参数列表(*output-parameters*) :

``` output parameters
{
"error_data": [
{
"sheet_no": "P1001",
"error_code": 0,
"error_message": "Ok"
},
{
"sheet_no": "P1002",
"error_code": 102,
"error_message": "Data type is invalid!"
}
]
}
```

#### 采购退货单

+ 路径(*endpoint*) : ***http://10.249.0.66:7070/v1/PurchaseReturns***

+ 操作类型(*http-method*) : ***POST***

+ 传入参数列表(*input-parameters*) :

``` input parameters
{
"signature": "",
"data": [
{
"sheet_no": "",
"branch_no": "",
"create_date": "",
"ext_sheet_no": "",
"lines": [
{
"ext_sheet_no": "",
"line_num": "",
"real_qty": ""
}
]
}
]
}
```

+ 返回参数列表(*output-parameters*) :

``` output parameters
{
"error_data": [
{
"sheet_no": "P1001",
"error_code": 0,
"error_message": "Ok"
},
{
"sheet_no": "P1002",
"error_code": 102,
"error_message": "Data type is invalid!"
}
]
}
```

#### 配送出库单

+ 路径(*endpoint*) : ***http://10.249.0.66:7070/v1/DeliveryWarehouseOrder***

+ 操作类型(*http-method*) : ***POST***

+ 传入参数列表(*input-parameters*) :

``` input parameters
{
"signature": "f7777649225b1f7d4f4abdc86ccb283c",
"data": [
{
"sheet_type": "正常要货单",
"ext_code": "S013",
"branch_no": "0000001",
"discount_amt": 0.00,
"cz_pay_amt": 681.00,
"memo": "",
"cod_pay_amt": 0.000000,
"dbranch_no": "0012018112001",
"sheet_no": "DO1905291025728439",
"on_line_pay_amt": 0.000000,
"real_sheet_amt": 681.00,
"arrears_flag": "Y",
"platform_flow_no": null,
"create_date": "2019-05-29 10:25:25",
"real_pay_amt": 681.00,
"pay_way": "储值支付",
"voucher_no": "YH1905291022728439",
"acct_flag": "已付款",
"tms_payflow_no": "",
"sale_man": "袁是俊",
"cash_amt": 0.000000,
"appoint_branch_no": "0000001",
"lines": [
{
"line_num": 1,
"item_no": "6924882446104",
"discount_amt": 0,
"memo": null,
"valid_price": 5.250000,
"real_qty": 120.0000,
"cash_amt": 0,
"sub_amt": 630.00,
"orgi_amt": 630.00
},
{
"line_num": 0,
"item_no": "6928804010800",
"discount_amt": 0,
"memo": null,
"valid_price": 2.125000,
"real_qty": 24.0000,
"cash_amt": 0,
"sub_amt": 51.00,
"orgi_amt": 51.00
}
]
}
]
}
```

+ 返回参数列表(*output-parameters*) :

``` output parameters
{
"error_data": [
{
"sheet_no": "",
"error_code": 0,
"error_message": "Ok"
}
]
}
```


#### 配送退货单

+ 路径(*endpoint*) : ***http://10.249.0.66:7070/v1/DeliveryReturnOrder***

+ 操作类型(*http-method*) : ***POST***

+ 传入参数列表(*input-parameters*) :

``` input parameters
{
"signature": "acad6dbbea04c59d7890deca382e3ad1",
"data": [
{
"sheet_no": "",
"create_date": "",
"appoint_branch_no": "",
"branch_no": "",
"dbranch_no": "",
"memo": "",
"lines": [
{
"item_no": "",
"real_qty": "",
"valid_price": "",
"voucheryhno": "",
"do_sheet_no": "",
"do_line_num": "",
"sheet_no": "",
"sub_amt": "",
"memo": ""
}
]
}
]
}
```

+ 返回参数列表(*output-parameters*) :

``` output parameters
{
"error_data": [
{
"sheet_no": "",
"error_code": 0,
"error_message": "Ok"
}
]
}
```


#### 报损报溢

+ 路径(*endpoint*) : ***http://10.249.0.66:7070/v1/ReportProfitAndLoss***

+ 操作类型(*http-method*) : ***POST***

+ 传入参数列表(*input-parameters*) :

``` input parameters
{
"signature": "",
"data": [
{
"sheet_no": "",
"create_date": "",
"appoint_branch_no": "",
"branch_no": "",
"trans_no": "",
"memo": "",
"lines": [
{
"item_no": "",
"real_qty": "",
"unit_no": "",
"memo": ""
}
]
}
]
}
```

+ 返回参数列表(*output-parameters*) :

``` output parameters
{
"error_data": [
{
"sheet_no": "",
"error_code": 0,
"error_message": "Ok"
}
]
}
```


#### 转仓单

+ 路径(*endpoint*) : ***http://10.249.0.66:7070/v1/StockTransfers***

+ 操作类型(*http-method*) : ***POST***

+ 传入参数列表(*input-parameters*) :

``` input parameters
{
"signature": "",
"data": [
{
"sheet_no": "",
"create_date": "",
"branch_no": "",
"dbranch_no": "",
"dc_branch_no": "",
"memo": "",
"lines": [
{
"item_no": "",
"real_qty": "",
"unit_no": "",
"memo": ""
}
]
}
]
}
```

+ 返回参数列表(*output-parameters*) :

``` output parameters
{
"error_data": [
{
"sheet_no": "",
"error_code": 0,
"error_message": "Ok"
}
]
}
```





### forOA( *OA => SAP* )


## 其他

## 作者

***北京奥维世纪科技有限公司-研发中心***

**2019年4月**

## 版本信息

\#|版本号|日期|撰写者|审核者|操作方式|更新内容|备注
---|---|---|---|---|---|---|---
1|1.0|2019.4.2|段菡|段菡、樊星、孟凡亮|A|All characters|
2|1.1|2019.4.4|段菡|张亚杰|U|客户主数据-传入参数列表、返回参数列表;<br>供应商主数据-传入参数列表、返回参数列表|
3|1.1.1|2019.4.4|段菡|张亚杰|U|客户主数据-传入参数列表、返回参数列表|需要联动<br>修改对应的<br>接口需求设计<br>文档
4|1.2|2019.4.9|段菡|张亚杰|U|物料主数据-传入参数列表|
5|1.2.1|2019.4.9|段菡|张亚杰|U|客户主数据-传入参数列表|
6|1.3|2019.4.11|段菡|张亚杰|U|物料主数据-传入参数列表|需要联动<br>修改对应的<br>接口需求设计<br>文档
7|1.4|2019.4.16|段春雷|张亚杰|U|采购收货-传入参数列表、返回参数列表|<br>文档
8|1.4|2019.4.16|段春雷|张亚杰|U|采购退货-传入参数列表、返回参数列表|<br>文档
9|1.5|2019.5.9|段春雷|孟凡亮|U|配送出库单-传入参数列表、返回参数列表|<br>文档
10|1.6|2019.5.16|段春雷|张亚杰|U|配送退货单-传入参数列表、返回参数列表|<br>文档
10|1.7|2019.5.16|段春雷|张亚杰|U|报损报溢单-传入参数列表、返回参数列表|<br>文档
11|1.8|2019.5.17|段春雷|张亚杰|U|转仓单-传入参数列表、返回参数列表|<br>文档
