package com.example.filedemo.payload.law_multiple_files_payload;



public class UploadMultipleFileResponse {

    private String html_fileName;
    private String html_fileDownloadUri;
    private String html_fileType;
    private long html_size;

    private String word_fileName;
    private String word_fileDownloadUri;
    private String word_fileType;
    private long word_fileSize;

    private String pdf_fileName;
    private String pdf_fileDownloadUri;
    private String pdf_fileType;
    private long pdf_fileSize;

    public UploadMultipleFileResponse(){}

    public UploadMultipleFileResponse(String html_fileName, String html_fileDownloadUri, String html_fileType, long html_size, String word_fileName, String word_fileDownloadUri, String word_fileType, long word_fileSize, String pdf_fileName, String pdf_fileDownloadUri, String pdf_fileType, long pdf_fileSize) {
        this.html_fileName = html_fileName;
        this.html_fileDownloadUri = html_fileDownloadUri;
        this.html_fileType = html_fileType;
        this.html_size = html_size;
        this.word_fileName = word_fileName;
        this.word_fileDownloadUri = word_fileDownloadUri;
        this.word_fileType = word_fileType;
        this.word_fileSize = word_fileSize;
        this.pdf_fileName = pdf_fileName;
        this.pdf_fileDownloadUri = pdf_fileDownloadUri;
        this.pdf_fileType = pdf_fileType;
        this.pdf_fileSize = pdf_fileSize;
    }

    public String getHtml_fileName() {
        return html_fileName;
    }

    public void setHtml_fileName(String html_fileName) {
        this.html_fileName = html_fileName;
    }

    public String getHtml_fileDownloadUri() {
        return html_fileDownloadUri;
    }

    public void setHtml_fileDownloadUri(String html_fileDownloadUri) {
        this.html_fileDownloadUri = html_fileDownloadUri;
    }

    public String getHtml_fileType() {
        return html_fileType;
    }

    public void setHtml_fileType(String html_fileType) {
        this.html_fileType = html_fileType;
    }

    public long getHtml_size() {
        return html_size;
    }

    public void setHtml_size(long html_size) {
        this.html_size = html_size;
    }

    public String getWord_fileName() {
        return word_fileName;
    }

    public void setWord_fileName(String word_fileName) {
        this.word_fileName = word_fileName;
    }

    public String getWord_fileDownloadUri() {
        return word_fileDownloadUri;
    }

    public void setWord_fileDownloadUri(String word_fileDownloadUri) {
        this.word_fileDownloadUri = word_fileDownloadUri;
    }

    public String getWord_fileType() {
        return word_fileType;
    }

    public void setWord_fileType(String word_fileType) {
        this.word_fileType = word_fileType;
    }

    public long getWord_fileSize() {
        return word_fileSize;
    }

    public void setWord_fileSize(long word_fileSize) {
        this.word_fileSize = word_fileSize;
    }

    public String getPdf_fileName() {
        return pdf_fileName;
    }

    public void setPdf_fileName(String pdf_fileName) {
        this.pdf_fileName = pdf_fileName;
    }

    public String getPdf_fileDownloadUri() {
        return pdf_fileDownloadUri;
    }

    public void setPdf_fileDownloadUri(String pdf_fileDownloadUri) {
        this.pdf_fileDownloadUri = pdf_fileDownloadUri;
    }

    public String getPdf_fileType() {
        return pdf_fileType;
    }

    public void setPdf_fileType(String pdf_fileType) {
        this.pdf_fileType = pdf_fileType;
    }

    public long getPdf_fileSize() {
        return pdf_fileSize;
    }

    public void setPdf_fileSize(long pdf_fileSize) {
        this.pdf_fileSize = pdf_fileSize;
    }
}
