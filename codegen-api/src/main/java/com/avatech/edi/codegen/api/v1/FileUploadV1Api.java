package com.avatech.edi.codegen.api.v1;

import com.avatech.edi.codegen.data.FileSettings;
import com.avatech.edi.codegen.exception.BusinessServiceException;
import com.avatech.edi.codegen.model.bo.project.ProjectStructure;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Fancy
 * @date 2019/11/4
 */
@RestController
public class FileUploadV1Api {

    @RequestMapping(value = "/uploadFolder", method = RequestMethod.POST)
    public String uploadDataStructureFile(MultipartFile[] folder){
        UUID uuid = UUID.randomUUID();
        saveMultiFile(FileSettings.DATASTRUCTURE_FILE_PATH + File.separator + uuid.toString(), folder);
        return uuid.toString();
    }

    public void saveMultiFile(String basePath, MultipartFile[] files) {
        if (files == null || files.length == 0) {
            return;
        }
        if (basePath.endsWith(File.separator)) {
            basePath = basePath.substring(0, basePath.length() - 1);
        }
        for (MultipartFile file : files) {
            String filePath = basePath + File.separator + file.getOriginalFilename();
            String fullFilePath =  makeDir(filePath);
            filePath = fullFilePath + File.separator + getFileName(file.getOriginalFilename());
            File dest = new File(filePath);
            try {
                file.transferTo(dest);
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getFileName(String filePath){
        if (filePath.lastIndexOf('/') > 0) {
            String fileName = filePath.substring(filePath.lastIndexOf('/'),filePath.length());
            return fileName;
        }
        return filePath;
    }

    private String makeDir(String filePath) {
        if (filePath.lastIndexOf('/') > 0) {
            String dirPath = filePath.substring(0, filePath.lastIndexOf('/'));
            File dir = new File(dirPath);
            if (!dir.exists()) {
                if(!dir.mkdirs()){
                    throw new BusinessServiceException("5000","文件夹创建失败");
                }
            }
            filePath =  dir.getAbsolutePath();
            return filePath;
        }
        throw new BusinessServiceException("5001","文件夹创建失败");
    }
}
