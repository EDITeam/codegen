package ${mapperObject.packageName}.service;

import com.avatech.edi.model.bo.IBusinessObject;

/**
* PLEASE KEEP THIS INFOMATION
* CREATE BY AVATECH EDI CODE TOOL
* AT ${.now?string["yyyy-MM-dd"]}
*/
public class AbastractTransactionService<T extends IBusinessObject> {

    private void callTransaction(T bo,String operationType){

    }

    public void save(T bo){
        this.callTransaction(bo,"A");
    }

    public void update(T bo){
        this.callTransaction(bo,"U");
    }

    public void delete(T bo){
        this.callTransaction(bo,"D");
    }

}
