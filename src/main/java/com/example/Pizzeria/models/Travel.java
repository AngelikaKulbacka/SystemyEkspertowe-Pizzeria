package com.example.Pizzeria.models;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Travel {
//	private List<Person> people;
	private Country country;
	private Hotel hotel;
	private LocalDate stayFrom;
	private LocalDate stayTo;
	private int adultsNumber;
	private int childrenNumber;
	
	
	public long getDaysOfStay() {
		return ChronoUnit.DAYS.between(stayFrom, stayTo);
	}
	
	public int weeksOfStay() {
		return (int) getDaysOfStay() / 7;
	}
	
	public boolean isBeginningDuringSummertime() {
		return stayFrom.getMonth() == Month.JUNE || stayFrom.getMonth() == Month.JULY || stayFrom.getMonth() == Month.AUGUST;
	}

	// ADULTS NUMBER
	public int getAdultsNumber() {
		return adultsNumber;
	}
	
	public void setAdultsNumber(int adultsNumber) {
		this.adultsNumber = adultsNumber;
	}
	
	// CHILDREN NUMBER
	public int getChildrenNumber() {
		return childrenNumber;
	}
	
	public void setChildrenNumber(int childrenNumber) {
		this.childrenNumber = childrenNumber;
	}
	
	// GROUP COUNT
	public int getGroupNumber() {
		return adultsNumber + childrenNumber;
	}
	
	// COUNTRY
	public Country getCountry() {
		return country;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}
	
	// HOTEL
	public Hotel getHotel() {
		return hotel;
	}
	
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	// STAY FROM
	public LocalDate getStayFrom() {
		return stayFrom;
	}
	
	public void setStayFrom(LocalDate stayFrom) {
		this.stayFrom = stayFrom;
	}
	
	// STAY TO
	public LocalDate getStayTo() {
		return stayTo;
	}
	
	public void setStayTo(LocalDate stayTo) {
		this.stayTo = stayTo;
	}
}
