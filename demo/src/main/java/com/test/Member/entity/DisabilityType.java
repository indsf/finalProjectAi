package com.test.Member.entity;

import com.test.Member.exception.DisabilityTypeValidCheck;

import com.test.common.validation.ValueEnum;

import java.util.Arrays;

public enum DisabilityType implements ValueEnum<String> {

    없음("없음"),
    시각장애("시각장애"),
    청각장애("청각장애"),
    지적장애("지적장애"),
    지체장애("지체장애"),
    자폐성장애("자폐성장애"),
    뇌병변장애("뇌병변장애"),
    정신장애("정신장애");

    private final String value;

    DisabilityType(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return null;
    }

    public static DisabilityType disFromValue(String value){
        return Arrays.stream(DisabilityType.values())
                .filter(ft -> ft.getValue().equals(value))
                .findFirst()
                .orElseThrow(()->DisabilityTypeValidCheck.bussinessException);
    }
}
