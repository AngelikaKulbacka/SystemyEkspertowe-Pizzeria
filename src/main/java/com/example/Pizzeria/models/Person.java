package com.example.Pizzeria.models;

public class Person {
	private int age;
	private String gender;
	private boolean hasCovidPassport;
	
	// age
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	// gender
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	// passport
	public boolean getHasCovidPassport() {
		return hasCovidPassport;
	}
	
	public void setGender(boolean hasCovidPassport) {
		this.hasCovidPassport = hasCovidPassport;
	}
	
	
}
