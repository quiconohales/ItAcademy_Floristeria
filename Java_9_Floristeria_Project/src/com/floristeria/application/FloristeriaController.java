package com.floristeria.application;

import java.util.List;

import com.floristeria.domain.Arbre;
import com.floristeria.domain.Decoracio;
import com.floristeria.domain.Flor;
import com.floristeria.domain.Floristeria;
import com.floristeria.domain.Material;
import com.floristeria.persistence.FloristeriaRepository;

public class FloristeriaController {

	private FloristeriaRepository repository;
	public static enum tipusMaterial {FUSTA,PLASTIC};
	
	private Floristeria currentSelectedFloristeria = null;
	
	public FloristeriaController(){
		this.repository = new FloristeriaRepository(); 
	}
	
	public void createFloristeria(String name) {
		Floristeria floristeria = new Floristeria(name);
		this.repository.addFloristeria(floristeria);
	}
	
	public void addProducteFlor(Floristeria floristeria, double preu, String color) {
		Flor flor = new Flor(preu,color);
		floristeria.addProducte(flor);
	}
	
	public void addProducteArbre(Floristeria floristeria, double preu, double height) {
		Arbre arbre = new Arbre (preu, height);
		floristeria.addProducte(arbre);
	}
	
	public void addProducteDecoracio(Floristeria floristeria, double preu, Material tipusMaterial ) {
		Decoracio decoracio = new Decoracio (preu, tipusMaterial);
		floristeria.addProducte(decoracio);
		
	}
	
	public List<Floristeria> getAllFloristerias(){
		return this.repository.getAllFloristeriasList();
	}
	
	public void selectCurrentFloristeria(Floristeria currentSelectedFloristeria) {
		this.currentSelectedFloristeria = currentSelectedFloristeria;
	}
	
	public Floristeria getCurrentFloristeria() {
		return this.currentSelectedFloristeria;
	}
}
