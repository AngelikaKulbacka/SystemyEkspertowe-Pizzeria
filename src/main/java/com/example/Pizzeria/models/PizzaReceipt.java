package com.example.Pizzeria.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PizzaReceipt {
	private BigDecimal price;
	HashSet<Discount> discountHashSet =new HashSet<>();

	public HashSet<Discount> getDiscountHashSet() {
		return discountHashSet;
	}

	public void setDiscountHashSet(HashSet<Discount> discountHashSet) {
		this.discountHashSet = discountHashSet;
	}
//	List<Discount> discountList = new ArrayList<>();
//	public List<Discount> getDiscountList() {
//		return discountList;
//	}
//
//	public void setDiscountList(List<Discount> discountList) {
//		this.discountList = discountList;
//	}

	public void addDiscount(Discount discount){
		discountHashSet.add(discount);
//		discountList.add(discount);
	}
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	

}
