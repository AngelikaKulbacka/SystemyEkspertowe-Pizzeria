package com.example.Pizzeria.models;

import java.math.BigDecimal;
import java.util.HashSet;

public class PizzaReceipt {
	private BigDecimal price;
	HashSet<Discount> discountHashSet =new HashSet<>();

	public HashSet<Discount> getDiscountHashSet() {
		return discountHashSet;
	}

	public void setDiscountHashSet(HashSet<Discount> discountHashSet) {
		this.discountHashSet = discountHashSet;
	}

	public void addDiscount(Discount discount){
		discountHashSet.add(discount);
	}
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	

}
