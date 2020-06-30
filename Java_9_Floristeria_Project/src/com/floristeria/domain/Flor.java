package com.floristeria.domain;

public class Flor extends Producte {

	private String color;
	
	public Flor(double price, String color) {
		super(price);
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
}