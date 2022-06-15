package com.example.Pizzeria.models;

import java.math.BigDecimal;

public class Drink {
	private String name;
	private BigDecimal price;
	
	
	
	public Drink(String name, BigDecimal price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
}
