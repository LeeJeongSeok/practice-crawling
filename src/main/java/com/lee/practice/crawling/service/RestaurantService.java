package com.lee.practice.crawling.service;

import com.lee.practice.crawling.dto.Menu;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class RestaurantService {

    Document document;


    public void callUrl() throws Exception{
        document = Jsoup.connect("http://snuco.snu.ac.kr/ko/foodmenu").get();
    }

    public void data__crawling() {
        Elements tdElement = document.select("table tbody tr td");


        Menu menu = Menu.builder()
                .restaurant(tdElement.get(0).text())
                .breakfast(tdElement.get(1).text())
                .lunch(tdElement.get(2).text())
                .dinner(tdElement.get(3).text())
                .build();
    }

    public void add_list() {

        List<Menu> menuList = new ArrayList<>();

    }


}
