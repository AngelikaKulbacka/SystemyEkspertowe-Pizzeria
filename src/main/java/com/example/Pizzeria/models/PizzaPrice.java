package com.example.Pizzeria.models;

import java.math.BigDecimal;

public class PizzaPrice {
	private BigDecimal price;
	private boolean isStudent;	
	
//	public TravelPrice() {
//		this.price = new BigDecimal(0.0);
//	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
