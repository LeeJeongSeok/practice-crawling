package com.lee.practice.crawling.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuServiceTest {

    @Autowired
    MenuService menuService;

    @Test
    public void menuService_url_호출() throws Exception{

        Document document = Jsoup.connect("http://snuco.snu.ac.kr/ko/foodmenu").get();

    }

    @Test
    public void 메뉴_크롤링_테스트() throws  Exception {

        //given
        Document document = Jsoup.connect("http://snuco.snu.ac.kr/ko/foodmenu").get();
        Elements elements = document.select("table tbody tr td");

        //when
        String restaurant = elements.get(0).text();
        String breakfast = elements.get(1).text();
        String lunch = elements.get(2).text();
        String dinner = elements.get(3).text();

        //then
        assertThat("학생회관식당(880-5543)").isEqualTo(restaurant);
        assertThat("건새우근대된장국(#) 1,700원").isEqualTo(breakfast);
        assertThat("치즈돈까스&쫄면 4,000원 마파두부(#) 1,700원 돌솥사리곰탕 3,000원").isEqualTo(lunch);
        assertThat("버섯불고기 3,500원 조갯살미역국백반(#) 1,700원").isEqualTo(dinner);
    }
}
