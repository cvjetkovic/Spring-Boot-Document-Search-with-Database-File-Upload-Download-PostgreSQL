package com.example.filedemo.service.db_file_storage_service;

import com.example.filedemo.exception.FileStorageException;
import com.example.filedemo.exception.MyFileNotFoundException;
import com.example.filedemo.model.law_one_file.Law;
import com.example.filedemo.repository.DBFileRepository;

import com.example.filedemo.shared.file_processing.text_extraction.ExtractTextFromFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DBFileStorageService extends ExtractTextFromFile {

    @Autowired
    private DBFileRepository dbFileRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Law storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            String lawTitle = fileName.split("\\.")[0];

            MultipartFile pdf = convertFileToMultipartFile(lawTitle + ".pdf",  " application/pdf", convertWordToPdf(file));

//          Law law = new Law(lawTitle, extractTextFromWORD(file), fileName, file.getContentType(), file.getBytes());
            Law law = new Law(lawTitle, extractTextFromWORD(file), fileName, file.getContentType(), file.getBytes(), pdf.getName(), pdf.getContentType(), pdf.getBytes());

            return dbFileRepository.save(law);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

//    public Law storeFileAndGeneratePDF(MultipartFile file) {
//        // Normalize file name
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
//        try {
//            // Check if the file's name contains invalid characters
//            if (fileName.contains("..")) {
//                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
//            }
//            String lawTitle = fileName.split("\\.")[0];
//
//
//
//            Law law = new Law(lawTitle, extractTextFromPDF(file), fileName, file.getContentType(), file.getBytes());
//
//            return dbFileRepository.save(law);
//        } catch (IOException ex) {
//            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
//        }
//    }

    public Law getFile(String lawId) {
        return dbFileRepository.findById(lawId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + lawId));
    }


    public Law deleteFile(String lawId) {
        dbFileRepository.deleteById(lawId);
        return null;
    }


}
