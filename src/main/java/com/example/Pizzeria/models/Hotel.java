package com.example.Pizzeria.models;

public class Hotel {
//	String name;
	int ratingStarsNumber;
//	boolean hasBreakfast;
	String mealsType; // breakfast, 2 meals, 3 meals, none
	boolean hasPool;
	String roomType;
	
//	public String getName() {
//		return name;
//	}
//	
//	void setName(String name) {
//		this.name = name;
//	}
	
	public Hotel(int ratingStarsNumber, String mealsType, boolean hasPool, String roomType) {
		this.ratingStarsNumber = ratingStarsNumber;
		this.mealsType = mealsType;
		this.hasPool = hasPool;
		this.roomType = roomType;
	}
	
	
	public int getratingStarsNumber() {
		return ratingStarsNumber;
	}
	
	void setratingStarsNumber(int ratingStarsNumber) {
		this.ratingStarsNumber = ratingStarsNumber;
	}
	
	
	public String getMealsType() {
		return mealsType;
	}
	
	void setMealsType(String mealsType) {
		this.mealsType = mealsType;
	}
	
	public int mealsTypeToNumberOfMeals() {
		System.out.println(mealsType);
		if (mealsType.equals("jeden")) return 1;
		else if (mealsType.equals("dwa")) return 2;
		else if (mealsType.equals("trzy")) return 3;
		else return 0;
	}
	
	public boolean gethasPool() {
		return hasPool;
	}
	
	void setName(boolean hasPool) {
		this.hasPool = hasPool;
	}
	
	
	public String getRoomType() {
		return roomType;
	}
	
	void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
}
