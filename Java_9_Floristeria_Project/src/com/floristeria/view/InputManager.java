package com.floristeria.view;

import java.util.List;
import java.util.Scanner;

import com.floristeria.application.FloristeriaController;
import com.floristeria.domain.Floristeria;
import com.floristeria.domain.Fusta;
import com.floristeria.domain.Plastic;

public class InputManager {

	private Scanner scanner;
	private InputCommons commons;
	private FloristeriaController controller;
	private FloristeriaView view;
	
	public InputManager() {
		this.scanner = new Scanner(System.in);
		this.commons = new InputCommons(this.scanner);
		this.controller = new FloristeriaController();
		this.view = new FloristeriaView();
	}
	
	public void close() {
		this.scanner.close();
	}
	
	public void showMenu() {
		
		
		boolean exit = false;
		
		while (exit==false) {
			
			String outputMenu = this.view.showMainMenu();
			
			Floristeria currentFloristeria = controller.getCurrentFloristeria();
			String outputFloristeriaName = this.view.showCurrentFloristeria(currentFloristeria);
			
			System.out.println(outputMenu);
			System.out.println(outputFloristeriaName);
			
			int option = commons.askOption(1, 5);
			
			switch(option) {
			  case 1:
				  this.createFloristeria();
				  break;
			  case 2:
				  this.selectCurrentFloristeria();
				  break;
			  case 3:
				  this.addProducte();
				  break;
			  case 4:
				  this.showCurrentStockFloristeria();
				  break;
			  case 5:
				  exit = true;
				  break;
			  default:
			    break;
			}
			
			if(exit==false) { 
				commons.pause();
			}else {
				System.out.println(view.endProgram());
			}
		}

	}

	//OPTION 1
	public void createFloristeria() {
		//System.out.println("1 createFloristeria");
		String name = commons.askString("Quin es el nom de la nova floristeria que vols crear?:");
		this.controller.createFloristeria(name);
		
		System.out.println("Floristeria creada correctament.");
		System.out.println("Selecciona des del menu aquesta floristeria com actual per a afegir stock.");
	}
	
	//OPTION 2
	public void selectCurrentFloristeria() {
		
		//System.out.println("2 selectCurrentFloristeria");
		
		List<Floristeria> list = this.controller.getAllFloristerias();
		int size = list.size();
		
		if (size>0) { //Si ja s'ha creat alguna floristeria
			
			String outputMenu2 = view.showMenuFloristeriaNames(list);
			System.out.println(outputMenu2);
			
			int option = commons.askInt("Selecciona una floristeria actual:",1, size);
			
			Floristeria newCurrentFloristeria = list.get(option-1);
			controller.selectCurrentFloristeria(newCurrentFloristeria);
			
		}else { //No hi ha cap floristeria creada
			System.out.println("Encara no has creat cap floristeria.");
		}
	}
	//OPTION 3
	public void addProducte() {
		//System.out.println("3 addProducte");
		
		Floristeria floristeriaActual = controller.getCurrentFloristeria();
		
		if (floristeriaActual==null) {
			System.out.println("Encara no has seleccionat cap floristeria actual");
			return;
		}
		
		double price = commons.askDouble("Introdueix el preu del nou producte:");
		
		int option = commons.askInt("Quin tipus de producte vols afegir? "+
				"(1:Arbre / 2:Flor / 3:Decoracio):",1,3);
		
		if (option==1) {
			
			System.out.println("Has seleccionat ARBRE.");
			double height = commons.askDouble("Introdueix l'alçada de l'arbre:");
			this.controller.addProducteArbre(floristeriaActual, price, height);
			
		}else if (option==2) {
			
			System.out.println("Has seleccionat FLOR.");
			String color = commons.askString("Introdueix el color de la flor:");
			this.controller.addProducteFlor(floristeriaActual, price, color);
			
		}else if (option==3) {
			
			System.out.println("Has seleccionat DECORACIO.");
			int tipusMaterial = commons.askInt("De quin tipus de material vols la decoració ?:"+
					"(1:Fusta / 2:Plastic):",1,2);
			if (tipusMaterial==1) {
				this.controller.addProducteDecoracio(floristeriaActual, price, new Fusta());
			}else {
				this.controller.addProducteDecoracio(floristeriaActual, price, new Plastic());
			}
		}
		
		int repeat = commons.askInt("Vols afegir un altre producte? ( 1:Si / 0:No )",0, 1);
		if (repeat==1) this.addProducte();
		
	}
	
	//OPTION 4
	public void showCurrentStockFloristeria() {
		
		if(controller.getCurrentFloristeria()==null) {
			System.out.println("Encara no has seleccionat una floristeria actual.");
		}else {
			Floristeria currentFloristeria = controller.getCurrentFloristeria();
			String outputStock = this.view.showFloristeriaDetails(currentFloristeria);
			System.out.println(outputStock);
		}
		
	}
		/*
	public void showMenuFloristeriaNames() {
		System.out.println("showMenuFloristeriaNames");
	}*/
	
}
