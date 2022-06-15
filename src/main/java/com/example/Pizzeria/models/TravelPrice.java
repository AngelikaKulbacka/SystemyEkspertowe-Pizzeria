package com.example.Pizzeria.models;

import java.math.BigDecimal;

public class TravelPrice {
	private BigDecimal price;
	private BigDecimal adultsPrice; // cena za dobe dla jednego doroslego
	private BigDecimal childPrice; // cena za dobe dla jednego dziecka
	private BigDecimal mealPrice;
	private BigDecimal flightPrice; // cena biletu za jedna dorosla osobe
	
	private double defaultPrice = 2000.0; // wycieczka trwajaca dzien, 1 dorosly, pokoj normalny, skala hotelu najnizsza, bez posilkow i basenu wynosi ok. 2000 zl
	
	
	public TravelPrice() {
		this.price = new BigDecimal(0.0);
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	public BigDecimal getAdultsPrice() {
		return adultsPrice;
	}
	
	public void setAdultsPrice(BigDecimal adultsPrice) {
		this.adultsPrice = adultsPrice;
	}
	
	public BigDecimal getChildPrice() {
		return childPrice;
	}
	
	public void setChildPrice(BigDecimal childPrice) {
		this.childPrice = childPrice;
	}

	public BigDecimal getMealPrice() {
		return mealPrice;
	}
	
	public void setMealPrice(BigDecimal mealPrice) {
		this.mealPrice = mealPrice;
	}
	
	
	public BigDecimal getFlightPrice() {
		return flightPrice;
	}
	
	public void setFlightPrice(BigDecimal flightPrice) {
		this.flightPrice = flightPrice;
	}
}
