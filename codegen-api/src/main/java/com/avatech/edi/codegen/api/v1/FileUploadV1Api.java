package com.avatech.edi.codegen.api.v1;

import com.avatech.edi.codegen.data.FileSettings;
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
        if (basePath.endsWith("/")) {
            basePath = basePath.substring(0, basePath.length() - 1);
        }
        for (MultipartFile file : files) {
            String filePath = basePath + "/" + file.getOriginalFilename();
            makeDir(filePath);
            File dest = new File(filePath);
            try {
                file.transferTo(dest);
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void makeDir(String filePath) {
        if (filePath.lastIndexOf('/') > 0) {
            String dirPath = filePath.substring(0, filePath.lastIndexOf('/'));
            File dir = new File(dirPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
        }
    }
}
