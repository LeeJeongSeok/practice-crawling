package com.lee.practice.crawling.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CrawlingController {


    @GetMapping("/crawling")
    public String crawling() throws IOException {


        return "crawling";
    }
}
