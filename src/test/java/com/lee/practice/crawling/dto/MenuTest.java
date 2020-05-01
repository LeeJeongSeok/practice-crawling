package com.lee.practice.crawling.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuTest {

    @Test
    public void menu_dto_테스트() {


        //given
        String restaurant = "Restaurant";
        String breakfast = "Breakfast";
        String lunch = "Lunch";
        String dinner = "Dinner";

        //when
        Menu menu = Menu.builder()
                .restaurant(restaurant)
                .breakfast(breakfast)
                .lunch(lunch)
                .dinner(dinner)
                .build();


        //then
        assertThat(menu.getRestaurant()).isEqualTo(restaurant);
        assertThat(menu.getBreakfast()).isEqualTo(breakfast);
        assertThat(menu.getLunch()).isEqualTo(lunch);
        assertThat(menu.getDinner()).isEqualTo(dinner);



    }
}
