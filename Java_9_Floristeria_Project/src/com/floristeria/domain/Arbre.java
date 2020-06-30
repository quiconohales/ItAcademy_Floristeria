package com.floristeria.domain;

public class Arbre extends Producte {

	private double height;

	public Arbre(double price, double height) {
		super(price);
		this.height = height;
	}
	
	public double getHeight() {
		return height;
	}
	
	
}
