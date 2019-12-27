
/******
* Object:  StoredProcedure ava_sp_transactionnotification
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
******/

<#if projectInfo.dataBaseType == "MSSQL">
create proc [ava_sp_transactionnotification]
    @object_code nvarchar(20), 			-- SBO Object Type
    @transaction_type nchar(1),			-- [A]dd, [U]pdate, [D]elete
    @table_name nvarchar(255),
    @cols_val_tab_del bigint
AS
begin

    -- Return values
    declare @code  int				        -- Result (0 for no error)
    declare @message nvarchar (200) 		-- Error string to be displayed
    select @code = 0
    select @message = N'Ok'

--------------------------------------------------------------------------------------------------------------------------------

--	ADD	YOUR	CODE	HERE

--------------------------------------------------------------------------------------------------------------------------------
    select @code as "code",@message as "message";
end

</#if>

<#if projectInfo.dataBaseType == "MYSQL">
CREATE PROCEDURE `ava_sp_transactionnotification`(
    in object_code nvarchar(20), 			-- SBO Object Type
    in transaction_type nchar(1),			-- [A]dd, [U]pdate, [D]elete
    in table_name nvarchar(255),
    in cols_val_tab_del bigint
)
BEGIN
    declare `code` int;
    declare `message` nvarchar(255);
    set `code` = 0;
    set `message` = N'OK';

/**
--------------------------------------------------------------------------------------------------------------------------------

--	ADD	YOUR	CODE	HERE

--------------------------------------------------------------------------------------------------------------------------------
**/
    select  `code` as `code`,`message` as `message`;
END
</#if>

<#if projectInfo.dataBaseType == "HANA">
CREATE PROCEDURE "ava_sp_transactionnotification"
(
    object_code nvarchar(20), 				-- SBO Object Type
    transaction_type nchar(1),			    -- [A]dd, [U]pdate, [D]elete
    table_name nvarchar(255),
    cols_val_tab_del bigint
)
LANGUAGE SQLSCRIPT AS
BEGIN

    -- Return values
    DECLARE code integer;
    --返回值(0 无错误)
    DECLARE message nvarchar(200);
    --返回的消息
    SELECT 0 INTO code FROM  dummy;
    SELECT 'OK' INTO message FROM dummy;
--------------------------------------------------------------------------------------------------------------------------------
--ADD YOUR CODE HERE
--------------------------------------------------------------------------------------------------------------------------------
    --返回结果
    SELECT TO_INTEGER(code) "code", message "message" FROM dummy;
END

</#if>


