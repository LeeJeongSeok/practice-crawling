package com.lee.practice.crawling.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@Builder
@ToString
public class Menu {

    private final String restaurant;
    private final String breakfast;
    private final String lunch;
    private final String dinner;


}
