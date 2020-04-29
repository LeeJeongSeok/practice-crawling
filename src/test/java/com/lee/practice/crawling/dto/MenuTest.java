package com.lee.practice.crawling.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuTest {

    @Test
    public void menu_dto_테스트() {

        //given
        String restaurant = "학생회관식당(880-5543)";
        String breakfast = "청국장찌개";
        String lunch = "칠리깐풍육";
        String dinner = "너비아니구이";

        //when
        Menu menu = new Menu(restaurant, breakfast, lunch, dinner);

        //then
        assertThat(menu.getRestaurant()).isEqualTo(restaurant);
        assertThat(menu.getBreakfast()).isEqualTo(breakfast);
        assertThat(menu.getLunch()).isEqualTo(lunch);
        assertThat(menu.getDinner()).isEqualTo(dinner);
    }
}
