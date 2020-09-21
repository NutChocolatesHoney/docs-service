package com.docs.exception;

import java.util.Arrays;

public enum ExceptionEnum{
    True("是", ""),
    False("否", ""),
    UNKNOWN("未知", "");

    String name;
    String value;

    ExceptionEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(String value) {
        return Arrays.stream(ExceptionEnum.values())
                .filter(it -> it.value.equals(value))
                .findFirst().orElse(ExceptionEnum.UNKNOWN).name;
    }
}
