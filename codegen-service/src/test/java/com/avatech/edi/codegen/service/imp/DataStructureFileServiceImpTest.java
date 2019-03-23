package com.avatech.edi.codegen.service.imp;

import org.dom4j.DocumentException;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataStructureFileServiceImpTest {

    @Test
    public void readerDataStructureFile() throws DocumentException {
        DataStructureFileServiceImp imp = new DataStructureFileServiceImp();
       imp.readerDataStructureFile("C:\\Temp\\Out");

    }
}