package com.floristeria.domain;

import com.floristeria.exceptions.NegativeNumberException;

public class Arbre extends Producte {

	private double height;

	public Arbre(double price, double height) throws NegativeNumberException{
		super(price);
		this.height = height;
		if (height<0) throw new NegativeNumberException("El camp ALÇADA ha de ser un número positiu!");
	}
	
	public double getHeight() {
		return height;
	}
	
	
}
