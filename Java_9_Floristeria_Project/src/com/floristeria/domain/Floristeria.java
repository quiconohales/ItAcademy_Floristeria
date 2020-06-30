package com.floristeria.domain;

import java.util.ArrayList;
import java.util.List;

public class Floristeria {

	private String name;
	private List<Producte> stockList;
	
	public Floristeria(String name) {
		this.name = name;
		this.stockList = new ArrayList<Producte>();
	}
	
	public String getName() {
		return this.name;
	}

	public void addProducte(Producte producte ){
		this.stockList.add(producte);
	}

	public List <Producte> getStockList(){
		return this.stockList;
	}
	
}
