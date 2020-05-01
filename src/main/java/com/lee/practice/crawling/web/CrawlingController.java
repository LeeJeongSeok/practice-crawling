package com.lee.practice.crawling.web;

import com.lee.practice.crawling.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CrawlingController {

    @Autowired
    RestaurantService restaurantService;


    @GetMapping("/crawling")
    public String crawling() {
        try {
            restaurantService.crawling_data();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "crawling";
    }
}
