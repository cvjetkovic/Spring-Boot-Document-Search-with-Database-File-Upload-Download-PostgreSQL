package com.example.filedemo.controller;

import com.example.filedemo.model.law_one_file.LawSearchResponse;
import com.example.filedemo.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping(path = "/titleSearch/{query}", params = { "limit", "offset" })
    public LawSearchResponse getSearchByTitle(@PathVariable String query,
                                              @RequestParam(name = "limit", defaultValue = "1", required = false) int limit,
                                              @RequestParam(name = "offset", defaultValue = "0", required = false) int offset) {
        if (query.equals(":*")){
            return null;
        }

        return searchService.titleSearch(query,limit,offset);
    }

    @GetMapping(path = "/textSearch/{query}", params = { "limit", "offset" })
    public LawSearchResponse getSearchByText(@PathVariable String query,
                                             @RequestParam(name = "limit", defaultValue = "1", required = false) int limit,
                                             @RequestParam(name = "offset", defaultValue = "0", required = false) int offset) {
        if (query.equals(":*")){
            return null;
        }

        return searchService.textSearch(query,limit,offset);
    }


    @GetMapping(path = "/fullSearch/{query}", params = { "limit", "offset" })
    public LawSearchResponse getSearchByTitleAndText(@PathVariable String query,
                                                     @RequestParam(name = "limit", defaultValue = "1", required = false)  int limit,
                                                     @RequestParam(name = "offset", defaultValue = "0", required = false) int offset) {
        if (query.equals(":*")){
            return null;
        }

        return searchService.fullsearch(query,limit,offset);
    }



}
