package com.floristeria.domain;

import java.util.ArrayList;
import java.util.List;

import com.floristeria.exceptions.EmptyFieldException;

public class Floristeria {

	private String name;
	private List<Producte> stockList;
	
	public Floristeria(String name) throws EmptyFieldException{
		this.name = name;
		this.stockList = new ArrayList<Producte>();
		if(name.contentEquals("")) throw new EmptyFieldException("El camp NOM no pot estar buit!");
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
