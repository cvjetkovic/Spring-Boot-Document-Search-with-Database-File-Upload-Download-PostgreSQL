package com.example.filedemo.controller;

import com.example.filedemo.model.law_one_file.Law;
import com.example.filedemo.payload.law_one_file_payload.UploadFileResponse;
import com.example.filedemo.service.db_file_storage_service.DBFileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private DBFileStorageService dbFileStorageService;


    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        Law law = dbFileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(law.getId())
                .toUriString();

        return new UploadFileResponse(law.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{lawId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String lawId,
                                                 @RequestParam(name = "fileType", required = true) String fileType) {
        Law law = dbFileStorageService.getFile(lawId);

        if (fileType.equals("word")){
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(law.getFileType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + law.getFileName() + "\"")
                    .body(new ByteArrayResource(law.getData()));
        }else if (fileType.equals("pdf")){
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(law.getPdf_fileType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + law.getPdf_fileName() + "\"")
                    .body(new ByteArrayResource(law.getPdf_data()));
        }
        return null;

//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(law.getFileType()))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + law.getFileName() + "\"")
//                .body(new ByteArrayResource(law.getData()));
    }

    @DeleteMapping("/delete/{lawId}")
    public String deleteFile(@PathVariable String lawId) {
        dbFileStorageService.deleteFile(lawId);

        return "File deleted: " + lawId;
    }


}
