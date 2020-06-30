package com.example.filedemo.service;

import com.example.filedemo.model.law_one_file.LawSearch;
import com.example.filedemo.model.law_one_file.LawSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SearchService {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    public LawSearchResponse titleSearch(String query, int limit, int offset) {

        String titleSearchSQL = " SELECT f.id, f.law_title FROM public.laws f, to_tsquery('" + query + "') AS q WHERE (tsv_law_title @@ q) LIMIT  '" + limit + "'  OFFSET '" + offset + "' ";
        String countTitleSearchSQL = "SELECT count (*) FROM public.laws f, to_tsquery('" + query + "') AS q WHERE (tsv_law_title @@ q)";

        return getLawSearches(titleSearchSQL, countTitleSearchSQL);
    }

    public LawSearchResponse textSearch(String query, int limit, int offset) {

        String textSearchSQL = " SELECT f.id, f.law_title FROM public.laws f, to_tsquery('" + query + "') AS q WHERE (tsv_law_text @@ q) LIMIT  '" + limit + "'  OFFSET '" + offset + "' ";
        String countTextSearchSQL = "SELECT count (*) FROM public.laws f, to_tsquery('" + query + "') AS q WHERE (tsv_law_text @@ q)";

        return getLawSearches(textSearchSQL, countTextSearchSQL);

    }

    public LawSearchResponse fullsearch(String query, int limit, int offset) {

        String fullSearchSQL = " SELECT f.id, f.law_title FROM public.laws f, to_tsquery('" + query + "') AS q WHERE (tsv_law_title_text @@ q) LIMIT  '" + limit + "'  OFFSET '" + offset + "' ";
        String countFullSearchSQL = "SELECT count (*) FROM public.laws f, to_tsquery('" + query + "') AS q WHERE (tsv_law_title_text @@ q)";

        return getLawSearches(fullSearchSQL, countFullSearchSQL);
    }

    private LawSearchResponse getLawSearches(String titleSearch, String countSQL) {

        List<Map<String, Object>> obj = jdbcTemplate.queryForList(titleSearch);
        List<LawSearch> returnValue = new ArrayList<>();
        LawSearchResponse lawSearchResponse = new LawSearchResponse();

        Number totalSearchResults = jdbcTemplate.queryForObject(countSQL, Long.class);

        for (Map<String, Object> map : obj) {
            LawSearch model = new LawSearch();
            model.setUuid((String) map.get("id"));
            model.setLawTitle((String) map.get("law_title"));
            returnValue.add(model);
        }
        lawSearchResponse.setLaws(returnValue);
        lawSearchResponse.setTotal(totalSearchResults);
        return lawSearchResponse;
    }


}

