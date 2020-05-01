package com.lee.practice.crawling.service;

import com.lee.practice.crawling.dto.Menu;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {

    public List<Menu> crawling_data() throws Exception {

        List<Menu> menuList = new ArrayList<>();

        Document document = Jsoup.connect("http://snuco.snu.ac.kr/ko/foodmenu").get();
        Elements tdElement = document.select("table tbody tr");

        for (Element content : tdElement) {
            Elements tdContent = content.select("td");

            Menu menu = Menu.builder()
                    .restaurant(tdContent.get(0).text())
                    .breakfast(tdContent.get(1).text())
                    .lunch(tdContent.get(2).text())
                    .dinner(tdContent.get(3).text())
                    .build();

            menuList.add(menu);

        }

        return menuList;
    }

}
