package com.samibarankorkmaz.internship.common.utility.enums;

import lombok.Getter;

@Getter
public enum EngineType {
    GASOLINE("gasoline"),
    DIESEL("diesel"),
    LPG("lpg"),
    ELECTRIC("electric"),
    HYBRID("hybrid");

    private final String value;

    EngineType(String value) {
        this.value = value;
    }

}