package com.lee.practice.crawling.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuTest {

    @Test
    public void menu_dto_테스트() {

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
