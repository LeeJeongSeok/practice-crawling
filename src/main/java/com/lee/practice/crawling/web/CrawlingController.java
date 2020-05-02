package com.lee.practice.crawling.web;

import com.lee.practice.crawling.dto.Menu;
import com.lee.practice.crawling.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CrawlingController {

    @Autowired
    RestaurantService restaurantService;


    @GetMapping("/crawling")
    public String crawling(Model model) {

        try {
            List<Menu> RestaurantMenu = restaurantService.crawling_data();
            model.addAttribute("RestaurantMenu", RestaurantMenu);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("인터넷이 연결 X");
        }
        return "index";
    }
}
