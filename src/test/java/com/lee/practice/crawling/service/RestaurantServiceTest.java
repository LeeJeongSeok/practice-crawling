package com.lee.practice.crawling.service;

import com.lee.practice.crawling.dto.Menu;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RestaurantServiceTest {

    @Autowired
    RestaurantService restaurantService;

    @Test
    public void crawling_데이터_유무_일치() throws Exception {

        //given
        Document document = Jsoup.connect("http://snuco.snu.ac.kr/ko/foodmenu").get();
        Elements tdElement = document.select("table tbody tr td");

        //when
        Menu menu = Menu.builder()
                .restaurant(tdElement.get(0).text())
                .breakfast(tdElement.get(1).text())
                .lunch(tdElement.get(2).text())
                .dinner(tdElement.get(3).text())
                .build();


        //then
        assertThat(tdElement.get(0).text()).isEqualTo(menu.getRestaurant());
        assertThat(tdElement.get(1).text()).isEqualTo(menu.getBreakfast());
        assertThat(tdElement.get(2).text()).isEqualTo(menu.getLunch());
        assertThat(tdElement.get(3).text()).isEqualTo(menu.getDinner());


    }
}
