package com.example.filedemo.model.law_one_file;


/**
 * @author Vladimir Cvjetkovic
 */

public class LawSearch  {

    private String uuid;
    private String lawTitle;

    public LawSearch(){

    }

    public LawSearch(String uuid, String lawTitle ) {
        this.uuid = uuid;
        this.lawTitle = lawTitle;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLawTitle() {
        return lawTitle;
    }

    public void setLawTitle(String lawTitle) {
        this.lawTitle = lawTitle;
    }


}
