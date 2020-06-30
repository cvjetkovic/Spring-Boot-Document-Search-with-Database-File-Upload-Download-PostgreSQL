package com.example.filedemo.controller;

import com.example.filedemo.model.law_multiple_files.LawMultipleFiles;
import com.example.filedemo.payload.law_multiple_files_payload.UploadMultipleFileResponse;
import com.example.filedemo.service.db_multiple_file_storage_service.DBMultipleFileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class MultipleFileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);


    @Autowired
    private DBMultipleFileStorageService dbMultipleFileStorageService;

    @PostMapping("/uploadFiles")
    public UploadMultipleFileResponse uploadFiles(@RequestParam("html") MultipartFile html,
                                                  @RequestParam("word") MultipartFile word,
                                                  @RequestParam("pdf") MultipartFile pdf) {

        LawMultipleFiles lawMultipleFiles = dbMultipleFileStorageService.storeFiles(html, word, pdf);

        return new UploadMultipleFileResponse(lawMultipleFiles.getHtml_fileName(), "htmlDo", html.getContentType(), html.getSize(),
                lawMultipleFiles.getDoc_fileName(), "doc", word.getContentType(), word.getSize(),
                lawMultipleFiles.getPdf_fileName(), "gsf", pdf.getContentType(), pdf.getSize());


    }


//    @PostMapping("/uploadMultipleFiles")
//    public List<UploadMultipleFileResponse> uploadMultipleFiles(@RequestParam("htmls") MultipartFile [] htmls,
//                                                                @RequestParam("words") MultipartFile [] words,
//                                                                @RequestParam("pdfs") MultipartFile [] pdfs) {
//        return Arrays.asList(htmls, words, pdfs)
//                .stream()
//                .map(html -> uploadFiles(html),html -> uploadFiles(word),html -> uploadFiles(pdf))
//                .collect(Collectors.toList());
//    }


}
