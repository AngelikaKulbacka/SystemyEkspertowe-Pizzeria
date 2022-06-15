package com.example.Pizzeria.models;

import java.math.BigDecimal;

public class Pizza {
	private String pizzaType;
	private String pizzaSize;
	private String dipping;
	private int pizzaCount;
	private BigDecimal price;
	private boolean isStudent;
	
	
	public boolean isStudent() {
		return isStudent;
	}
	public void setStudent(boolean isStudent) {
		this.isStudent = isStudent;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getPizzaCount() {
		return pizzaCount;
	}
	public void setPizzaCount(int pizzaCount) {
		this.pizzaCount = pizzaCount;
	}
	private int toppings;
	public String getPizzaType() {
		return pizzaType;
	}
	public void setPizzaType(String pizzaType) {
		this.pizzaType = pizzaType;
	}
	public String getPizzaSize() {
		return pizzaSize;
	}
	public void setPizzaSize(String pizzaSize) {
		this.pizzaSize = pizzaSize;
	}
	public String getDipping() {
		return dipping;
	}
	public void setDipping(String dipping) {
		this.dipping = dipping;
	}
	public int getToppings() {
		return toppings;
	}
	public void setToppings(int toppings) {
		this.toppings = toppings;
	}
}
