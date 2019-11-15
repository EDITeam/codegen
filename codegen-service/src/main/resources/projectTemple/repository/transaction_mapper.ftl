package com.avatech.dahupt.${projectName}.repository.mapper;

import com.avatech.edi.model.dto.TranscationResult;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/
@Component
public interface TransactionNoticeMapper {

    TranscationResult callTransactionNotice(HashMap<String,Object> transactionParam);
}
