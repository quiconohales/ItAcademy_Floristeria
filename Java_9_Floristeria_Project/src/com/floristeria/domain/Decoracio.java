package com.floristeria.domain;

public class Decoracio extends Producte {

	Material material;
	public Decoracio(double price, Material material) throws Exception{
		super(price);
		this.material=material;
	}
	
	public Material getMaterial() {
		return material;
	}
}
