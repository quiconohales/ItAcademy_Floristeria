package com.floristeria.domain;

import com.floristeria.exceptions.EmptyFieldException;

public class Flor extends Producte {

	private String color;
	
	public Flor(double price, String color) throws Exception{
		super(price);
		this.color = color;
		if(color.contentEquals("")) throw new EmptyFieldException("El camp COLOR no pot estar buit!");
	}
	
	public String getColor() {
		return color;
	}
	
}