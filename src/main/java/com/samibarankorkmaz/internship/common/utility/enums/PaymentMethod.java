package com.samibarankorkmaz.internship.common.utility.enums;

import lombok.Getter;

@Getter
public enum PaymentMethod {
    CREDIT_CARD("credit_card"),
    DEBIT_CARD("debit_card"),
    CASH("cash"),
    BANK_TRANSFER("bank_transfer");

    private final String value;

    PaymentMethod(String value) {
        this.value = value;
    }

}