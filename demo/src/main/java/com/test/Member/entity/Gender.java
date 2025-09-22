package com.test.Member.entity;

import com.test.common.validation.ValueEnum;

public enum Gender implements ValueEnum<String> {
    남성("MALE"),
    여성("FEMALE");

    private String value;

    Gender(String value) {
        this.value = value;
    }


    @Override
    public String getValue() {
        return value;
    }
}
