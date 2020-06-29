package com.floristeria.application;

import java.util.List;

import com.floristeria.domain.Floristeria;
import com.floristeria.persistence.FloristeriaRepository;

public class FloristeriaController {

	private FloristeriaRepository repository;
	public static enum tipusMaterial {FUSTA,PLASTIC};
	
	private Floristeria currentSelectedFloristeria = null;
	
	public FloristeriaController(){
		this.repository = new FloristeriaRepository();
	}
	
	public void createFloristeria(String name) {
		
	}
	
	public void addProducteFlor(Floristeria floristeria, String color) {
		
	}
	
	public void addProducteArbre(Floristeria floristeria, double height) {
		
	}
	
	public void addProducteDecoracio(Floristeria floristeria, String tipusMaterial ) {
		
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
