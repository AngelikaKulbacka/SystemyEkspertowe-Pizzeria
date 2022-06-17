package com.example.Pizzeria.models;

import java.math.BigDecimal;
import java.util.Objects;

public class Discount {
    String nameDiscount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount1 = (Discount) o;
        return Objects.equals(nameDiscount, discount1.nameDiscount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameDiscount);
    }

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
