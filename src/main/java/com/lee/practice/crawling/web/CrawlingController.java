package com.lee.practice.crawling.web;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CrawlingController {

    @GetMapping("/")
    public String index() {
        return  "crawling";
    }

    @GetMapping("/crawling")
    public String crawling() throws IOException {

        Document document = Jsoup.connect("http://snuco.snu.ac.kr/ko/foodmenu").get();

        if (document != null) {
            return "connect";
        } else {
            return "connect fail";
        }



    }
}
