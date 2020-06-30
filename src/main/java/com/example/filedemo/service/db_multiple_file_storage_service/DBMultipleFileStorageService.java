package com.example.filedemo.service.db_multiple_file_storage_service;

import com.example.filedemo.exception.FileStorageException;
import com.example.filedemo.model.law_multiple_files.LawMultipleFiles;

import com.example.filedemo.repository.DBMultipleFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DBMultipleFileStorageService {

    @Autowired
    private DBMultipleFileRepository dbMultipleFileRepository;

    public LawMultipleFiles storeFiles(MultipartFile html, MultipartFile word, MultipartFile pdf) {

        String htmlFileName = StringUtils.cleanPath(html.getOriginalFilename());
        String wordFileName = StringUtils.cleanPath(word.getOriginalFilename());
        String pdfFileName = StringUtils.cleanPath(pdf.getOriginalFilename());

        try {
            if (htmlFileName.contains("..") && wordFileName.contains("..") && pdfFileName.contains("..")) {
                throw new FileStorageException("Sorry! Filenames contains invalid path sequences " + htmlFileName + ", " + wordFileName + ", " + pdfFileName);
            }

            String lawTitle = htmlFileName.split("\\.")[0];

            LawMultipleFiles lawMultipleFiles = new LawMultipleFiles(lawTitle, "tekstZakona",
                    htmlFileName, html.getContentType(), html.getBytes(),
                    wordFileName, word.getContentType(), word.getBytes(),
                    pdfFileName, pdf.getContentType(), pdf.getBytes());

            return dbMultipleFileRepository.save(lawMultipleFiles);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + htmlFileName + ", " + wordFileName + ", " + pdfFileName + ". Please try again!", ex);
        }

    }
}
