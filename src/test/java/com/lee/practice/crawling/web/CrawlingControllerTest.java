package com.lee.practice.crawling.web;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CrawlingController.class)
public class CrawlingControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void crawling_controller가_리턴된다() throws Exception {

        String text = "crawling";

        mvc.perform(get("/")).andExpect(status().isOk()).andExpect(content().string(text));
    }

    @Test
    public void crawling할려는_웹페이지가_정상작동중인가() throws Exception {

        Document document = Jsoup.connect("http://snuco.snu.ac.kr/ko/foodmenu").get();

        mvc.perform(get("/crawling")).andExpect(status().isOk()).andExpect(content().string("connect"));
    }

    @Test
    public void crawling할려는_태그가_있는가() throws Exception {

        Document document = Jsoup.connect("http://snuco.snu.ac.kr/ko/foodmenu").get();

        Elements elements = document.select("table tbody tr td.views-field views-field-field-restaurant");

        assertThat("학생회관식당(880-5543)").isEqualTo(elements);

    }

    @Test
    public void 태그안에_data가_있는가() throws Exception {

    }

}
