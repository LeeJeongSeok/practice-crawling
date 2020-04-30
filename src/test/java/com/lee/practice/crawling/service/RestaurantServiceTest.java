package com.lee.practice.crawling.service;

import com.lee.practice.crawling.dto.Menu;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;


public class RestaurantServiceTest {

    @Autowired
    RestaurantService restaurantService;

    @Test
    public void url_호출_테스트() throws Exception{
        Document document = Jsoup.connect("http://snuco.snu.ac.kr/ko/foodmenu").get();
    }

    @Test
    public void 데이터_크롤링() throws Exception {

        //given
        String res = "";
        String bre = "";
        String lun = "";
        String din = "";

        //when
        Document document = Jsoup.connect("http://snuco.snu.ac.kr/ko/foodmenu").get();
        Elements tdElement = document.select("table tbody tr td");

        res = tdElement.get(0).text();
        bre = tdElement.get(1).text();
        lun = tdElement.get(2).text();
        din = tdElement.get(3).text();


        //then
        assertThat("학생회관식당(880-5543)").isEqualTo(res);
        assertThat("건새우근대된장국(#) 1,700원").isEqualTo(bre);
        assertThat("치즈돈까스&쫄면 4,000원 마파두부(#) 1,700원 돌솥사리곰탕 3,000원").isEqualTo(lun);
        assertThat("버섯불고기 3,500원 조갯살미역국백반(#) 1,700원").isEqualTo(din);
    }

    @Test
    public void dto_테스트() {

        Menu menu = Menu.builder()
                .restaurant("학생회관식당(880-5543)")
                .breakfast("건새우근대된장국(#) 1,700원")
                .lunch("치즈돈까스&쫄면 4,000원 마파두부(#) 1,700원 돌솥사리곰탕 3,000원")
                .dinner("버섯불고기 3,500원 조갯살미역국백반(#) 1,700원")
                .build();


        assertThat("학생회관식당(880-5543)").isEqualTo(menu.getRestaurant());
        assertThat("건새우근대된장국(#) 1,700원").isEqualTo(menu.getBreakfast());
        assertThat("치즈돈까스&쫄면 4,000원 마파두부(#) 1,700원 돌솥사리곰탕 3,000원").isEqualTo(menu.getLunch());
        assertThat("버섯불고기 3,500원 조갯살미역국백반(#) 1,700원").isEqualTo(menu.getDinner());
    }
}
