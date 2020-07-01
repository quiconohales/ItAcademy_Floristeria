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
	
	//Es guarda la floristeria actual seleccionada per l'usuari des del menu o l'última floristeria creada
	private Floristeria currentSelectedFloristeria = null; 
	
	public FloristeriaController(){
		this.repository = new FloristeriaRepository();
	}
	
	/**
	 * Crea una nova FLORISTERIA i la guarda al repositori
	 * @param name
	 * @throws Exception
	 */
	public void createFloristeria(String name) throws Exception{
		Floristeria floristeria = new Floristeria(name);
		this.repository.addFloristeria(floristeria);
		
		//seleccionar automaticament ultima floristeria creada com a floristeria actual 
		this.currentSelectedFloristeria = floristeria; 
	}
	
	/**
	 * Crea un nou objecte FLOR i l'afegeix a l'stock de la floristeria parametre
	 */
	public void addProducteFlor(Floristeria floristeria, double preu, String color) throws Exception{
		Flor flor = new Flor(preu,color);
		floristeria.addProducte(flor);
	}
	
	/**
	 * Crea un nou objecte ARBRE i l'afegeix a l'stock de la floristeria parametre
	 */
	public void addProducteArbre(Floristeria floristeria, double preu, double height) throws Exception{
		Arbre arbre = new Arbre (preu, height);
		floristeria.addProducte(arbre);
	}
	
	/**
	 * Crea un nou objecte DECORACIO i l'afegeix a l'stock de la floristeria parametre
	 */
	public void addProducteDecoracio(Floristeria floristeria, double preu, Material tipusMaterial ) throws Exception{
		Decoracio decoracio = new Decoracio (preu, tipusMaterial);
		floristeria.addProducte(decoracio);
		
	}
	
	/**
	 * 
	 * @return Retorna tot el llistat de floristeries creades fins al moment
	 */
	public List<Floristeria> getAllFloristerias(){
		return this.repository.getAllFloristeriasList();
	}
	
	/**
	 * Selecciona com a nova floristeria actual la floristeria passada per paràmetre
	 * 
	 * @param currentSelectedFloristeria
	 */
	public void selectCurrentFloristeria(Floristeria currentSelectedFloristeria) {
		this.currentSelectedFloristeria = currentSelectedFloristeria;
	}
	
	/**
	 * 
	 * @return Retorna la floristeria actual
	 */
	public Floristeria getCurrentFloristeria() {
		return this.currentSelectedFloristeria;
	}
}
