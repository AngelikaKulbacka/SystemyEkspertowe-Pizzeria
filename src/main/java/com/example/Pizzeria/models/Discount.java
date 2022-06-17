package com.example.Pizzeria.models;

import java.math.BigDecimal;

public class Discount {
    String nameDiscount;
    BigDecimal discount;

    public Discount(String nameDiscount, BigDecimal discount) {
        this.nameDiscount = nameDiscount;
        this.discount = discount;
    }

    public String getNameDiscount() {
        return nameDiscount;
    }

    public void setNameDiscount(String nameDiscount) {
        this.nameDiscount = nameDiscount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
