package com.avatech.edi.codegen.model.bo.mapperBO;

import com.avatech.edi.codegen.model.bo.TableLine;

/**
 * 业务对象行
 */
public class MapperObjectItem extends TableLine {

    private String boPackageName;

    public String getBoPackageName() {
        return boPackageName;
    }

    public void setBoPackageName(String boPackageName) {
        this.boPackageName = boPackageName;
    }
}
