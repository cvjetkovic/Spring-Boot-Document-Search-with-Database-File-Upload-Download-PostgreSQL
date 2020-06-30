package com.example.filedemo.model.law_multiple_files;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "multiple_laws")
public class LawMultipleFiles {

    //Law
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;


    @Column(name = "law_title")
    private String lawTitle;

    @Column(name = "law_text", columnDefinition = "TEXT")
    private String lawText;


    //    HTML data
    @Column(name = "html_filename")
    private String html_fileName;

    @Column(name = "html_filetype")
    private String html_fileType;

    @Column(name = "html_data")
    private byte[] html_data;


    //    DOC data
    @Column(name = "doc_filename")
    private String doc_fileName;

    @Column(name = "doc_filetype")
    private String doc_fileType;

    @Column(name = "doc_data")
    private byte[] doc_data;


    //   PDF data
    @Column(name = "pdf_filename")
    private String pdf_fileName;

    @Column(name = "pdf_filetype")
    private String pdf_fileType;

    @Column(name = "pdf_data")
    private byte[] pdf_data;

    public LawMultipleFiles() {

    }

    public LawMultipleFiles(String lawTitle, String lawText, String html_fileName, String html_fileType, byte[] html_data, String doc_fileName, String doc_fileType, byte[] doc_data, String pdf_fileName, String pdf_fileType, byte[] pdf_data) {
        this.lawTitle = lawTitle;
        this.lawText = lawText;
        this.html_fileName = html_fileName;
        this.html_fileType = html_fileType;
        this.html_data = html_data;
        this.doc_fileName = doc_fileName;
        this.doc_fileType = doc_fileType;
        this.doc_data = doc_data;
        this.pdf_fileName = pdf_fileName;
        this.pdf_fileType = pdf_fileType;
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

    public String getHtml_fileName() {
        return html_fileName;
    }

    public void setHtml_fileName(String html_fileName) {
        this.html_fileName = html_fileName;
    }

    public String getHtml_fileType() {
        return html_fileType;
    }

    public void setHtml_fileType(String html_fileType) {
        this.html_fileType = html_fileType;
    }

    public byte[] getHtml_data() {
        return html_data;
    }

    public void setHtml_data(byte[] html_data) {
        this.html_data = html_data;
    }

    public String getDoc_fileName() {
        return doc_fileName;
    }

    public void setDoc_fileName(String doc_fileName) {
        this.doc_fileName = doc_fileName;
    }

    public String getDoc_fileType() {
        return doc_fileType;
    }

    public void setDoc_fileType(String doc_fileType) {
        this.doc_fileType = doc_fileType;
    }

    public byte[] getDoc_data() {
        return doc_data;
    }

    public void setDoc_data(byte[] doc_data) {
        this.doc_data = doc_data;
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
}
