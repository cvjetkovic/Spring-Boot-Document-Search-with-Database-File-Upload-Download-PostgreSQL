package com.example.filedemo.model.law_one_file;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "laws")
public class Law {

//    Law
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "law_title")
    private String lawTitle;

    @Column(name = "law_text", columnDefinition = "TEXT")
    private String lawText;

    //html data
    @Column(name = "filename")
    private String fileName;

    @Column(name = "filetype")
    private String fileType;

    @Column(name = "data")
    private byte[] data;

//    pdf data (generated from html/word and stored to db)
    @Column(name = "pdf_filename")
    private String pdf_fileName;

    @Column(name = "pdf_filetype")
    private String pdf_fileType;

    @Column(name = "pdf_data")
    private byte[] pdf_data;

    public Law() {

    }

    public Law(String lawTitle, String lawText, String fileName, String fileType, byte[] data) {
        this.lawTitle = lawTitle;
        this.lawText = lawText;
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

    public Law(String lawTitle, String lawText, String fileName, String fileType, byte[] data, String pdf_fileName, String pdf_fileType, byte[] pdf_data) {
        this.lawTitle = lawTitle;
        this.lawText = lawText;
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.pdf_fileName = pdf_fileName;
        this.pdf_fileType = pdf_fileType;
        this.pdf_data = pdf_data;
    }

    public String getPdf_fileName() {
        return pdf_fileName;
    }

    public void setPdf_fileName(String pdf_fileName) {
        this.pdf_fileName = pdf_fileName;
    }

    public String getPdf_fileType() {
        return pdf_fileType;
    }

    public void setPdf_fileType(String pdf_fileType) {
        this.pdf_fileType = pdf_fileType;
    }

    public byte[] getPdf_data() {
        return pdf_data;
    }

    public void setPdf_data(byte[] pdf_data) {
        this.pdf_data = pdf_data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLawTitle() {
        return lawTitle;
    }

    public void setLawTitle(String lawTitle) {
        this.lawTitle = lawTitle;
    }

    public String getLawText() {
        return lawText;
    }

    public void setLawText(String lawText) {
        this.lawText = lawText;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }


}
