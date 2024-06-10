package com.samibarankorkmaz.internship.common.utility.enums;

import lombok.Getter;

@Getter
public enum InsuranceCompany {
    ALLIANZ("allianz"),
    ANADOLU("anadolu"),
    AXA("axa"),
    GENERALI("generali"),
    HDI("hdi"),

    MAPFRE("mapfre");

    private final String value;

    InsuranceCompany(String value) {
        this.value = value;
    }

}