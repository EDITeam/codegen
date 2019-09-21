# java 后端服务代码生成器

项目运行后在浏览器输入：http://localhost:8080/projectinfo，获取到响应json消息：

```json
{
	"projectName": "ava",
	"projectType": "0",
	"serviceProtocol": "null",
	"serializaFormat": "0",
	"dataBaseType": "1",
	"ormType": "1",
	"dataFilePath": "C:\\Temp\\Out",
	"projectFilePath": "C:\\Temp\\In"
}
```

说明：
|字段名称|简介|
|--------|----|
|projectName|项目名称|
|projectType|项目类型（0：单模块；1：多模块）|
|serviceProtocel|服务协议（0：http协议；1：SOAP协议）|
|serializaFormat|序列化格式（0：json；1：xml）|
|dataBaseType|数据库类型（0：MSSQL；1：HANA；2：MYSQL；4：ORACLE;）|
|ormType|orm框架（0：JPA；1：Mybatis）|
|dataFilePath|数据结构目录|
|projectFilePath|项目创建后存放目录|