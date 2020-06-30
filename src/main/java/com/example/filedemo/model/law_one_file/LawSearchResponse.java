package com.example.filedemo.model.law_one_file;



import java.util.List;
/**
 * @author Vladimir Cvjetkovic
 */
public class LawSearchResponse {

    private Number total;
    private List<LawSearch> laws;

    public LawSearchResponse(){

    }

    public LawSearchResponse(Number total, List<LawSearch> laws) {
        this.total = total;
        this.laws = laws;
    }

    public Number getTotal() {
        return total;
    }

    public void setTotal(Number total) {
        this.total = total;
    }

    public List<LawSearch> getLaws() {
        return laws;
    }

    public void setLaws(List<LawSearch> laws) {
        this.laws = laws;
    }
}
