package ${mapperObject.packageName}.service;

import com.avatech.edi.model.bo.IBusinessObject;
import ${mapperObject.packageName}.repository.mapper.TransactionNoticeMapper;
import com.avatech.edi.common.exception.BusinessObjectException;
import com.avatech.edi.common.exception.DBException;
import com.avatech.edi.model.bo.IBusinessObject;
import com.avatech.edi.model.dto.TranscationResult;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;

/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/
public class AbastractTransactionService<T extends IBusinessObject> {

    @Autowired
    private TransactionNoticeMapper transactionNoticeMapper;

    private void callTransaction(T bo,String operationType){
        try {
            HashMap<String,Object> transactionParam = new HashMap<>();
            transactionParam.put("object_code",bo.getObjectCode());
            transactionParam.put("transaction_type",operationType);
            transactionParam.put("table_name","");
            transactionParam.put("cols_val_tab_del",bo.getId());

            TranscationResult result = transactionNoticeMapper.callTransactionNotice(transactionParam);
            if(result == null){
                throw new DBException("510","transacation no return value");
            }
            if(!result.getCode().equals(0)){
                throw new BusinessObjectException(result.getCode(), result.getMessage());
            }
        }catch (Exception e){
            throw new DBException("510","transaction error:"+e.getMessage());
        }
    }

    public Long save(T bo){
        this.callTransaction(bo,"A");
        return bo.getId();
    }

    public void update(T bo){
        this.callTransaction(bo,"U");
    }

    public void delete(T bo){
        this.callTransaction(bo,"D");
    }

}
