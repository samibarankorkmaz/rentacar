package com.samibarankorkmaz.internship.common.utility.enums;

import lombok.Getter;

@Getter
public enum MarketSegment {
    LUXURY("luxury"),
    ECONOMY("economy"),
    SPORTS("sports"),
    SUV_CROSSOVER("SUV/Crossover");

    private final String value;

    MarketSegment(String value) {
        this.value = value;
    }

}
