package com.example.filedemo.shared.file_processing.file_conversion;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
/**
 * @author Vladimir Cvjetkovic
 */
public abstract class MultipartToFileConverter {

    protected File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {

        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fileOutputStream = null;
        try {
//          file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(multipartFile.getBytes());

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            assert fileOutputStream != null;
            fileOutputStream.close();
        }

        return file;
    }

    protected  MultipartFile convertFileToMultipartFile(String originalFileName, String fileType, byte [] data){

        String fileName = StringUtils.cleanPath(originalFileName);

        return new MockMultipartFile(fileName,
                originalFileName, fileType, data);
    }
}
