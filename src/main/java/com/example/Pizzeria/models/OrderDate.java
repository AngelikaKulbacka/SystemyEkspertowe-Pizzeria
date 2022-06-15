package com.example.Pizzeria.models;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class OrderDate {
	private LocalDate orderDate;
	
	public OrderDate() {
		orderDate = LocalDate.now();
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	
	public String dayOfWeek() {
		if (orderDate.getDayOfWeek() == DayOfWeek.MONDAY)  {
			return "MONDAY";
		}  else if (orderDate.getDayOfWeek() ==  DayOfWeek.TUESDAY) {
			return "TUESDAY";
		} else if (orderDate.getDayOfWeek() ==  DayOfWeek.WEDNESDAY) {
			return "WEDNESDAY";
		} else  if (orderDate.getDayOfWeek() ==  DayOfWeek.THURSDAY)  {
			return "THURSDAY";
		} else if (orderDate.getDayOfWeek() ==  DayOfWeek.FRIDAY) {
			return "FRIDAY";
		} else if (orderDate.getDayOfWeek() ==  DayOfWeek.SATURDAY) {
			return "SATURDAY";
		} else if (orderDate.getDayOfWeek() ==  DayOfWeek.SUNDAY) {
			return "SUNDAY";
		}
		
		return "Error";
	}
}
