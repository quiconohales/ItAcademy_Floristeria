package com.floristeria.domain;

import com.floristeria.exceptions.NegativeNumberException;

public class Producte {

	protected double price;
	
	public Producte(double price) throws NegativeNumberException{
		this.price=price;
		if (price<0) throw new NegativeNumberException("El camp PREU ha de ser un número positiu!");

	}
	
	public double getPrice() {
		return this.price;
	}
	
}
