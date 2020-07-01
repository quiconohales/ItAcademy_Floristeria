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
		this.commons = new InputCommons(this.scanner); //encapsula operacions bàsiques de entrada de dades per consola
		this.controller = new FloristeriaController(); //encapsula operacions sobre objectes del domini
		this.view = new FloristeriaView(); //encapsula les vistes a mostrar per consola
	}
	
	public void close() {
		this.scanner.close();
	}
	
	/**
	 * Mostra menu principal per pantalla i espera que l'usuari seleccioni per consola una opció
	 * També es mostra la floristeria actual, si es que n'hi ha alguna seleccionada
	 * 
	 * Opcio 1 : Crear Floristeria
	 * Opcio 2 : Seleccionar floristeria actual
	 * Opcio 3 : Afegir productes a floristeria actual
	 * Opcio 4 : Visualitzar stock de floristeria actual
	 * Opcio 5 : Sortir del programa
	 */
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
				  this.addProducte_exceptionControl();
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

	/**
	 * OPCIO 1
	 * ------- 
	 * Es crea una nova floristeria a partir de les dades introduïdes per l'usuari
	 * Si l'usuari introdueix algun camp buit es mostra error per pantalla i es torna a demanar a l'usuari
	 * que introdueixi les dades de nou
	 * La nova floristeria creada es selecciona per defecte com a floristeria actual
	 * 
	 */
	public void createFloristeria() {
		//System.out.println("1 createFloristeria");
		boolean correctFormat = false;
		
		while(correctFormat==false) {
			try {
				String name = commons.askString("Quin es el nom de la nova floristeria que vols crear?:");
				this.controller.createFloristeria(name);

				System.out.println("Floristeria creada correctament.");
				System.out.println("Selecciona des del menu aquesta floristeria com actual per a afegir stock.");
				correctFormat=true;
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Torna a introduir les dades de la floristeria de nou.");
			}
		}
	}
	
	/**
	 * OPCIO 2
	 * -------
	 * 
	 * Es mostra un menu amb el llistat de totes les floristeries creades
	 * Es demana a l'usuari que en seleccioni una per a seleccionarla com a floristeria actual
	 * Si la llista està buida s'informar de que no s'ha creat encara cap floristeria
	 * 
	 */
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
	
	/**
	 * OPCIO 3
	 * -------
	 * Es demana introduir les dades d'un nou producte per a crear-lo i afegir-lo a l'stock de la
	 * floristeria actual. 
	 * Si es produeix algun error en la introducció de dades (camp buit o numero negatiu) es torna a
	 * demanar les dades per consola de nou.
	 * 
	 */
	public void addProducte_exceptionControl() {
		
		boolean correctFormat = false;
		
		while (correctFormat==false) {
			
			try {
				
				addProducte();
				correctFormat = true;
				
			}catch(Exception e) {
				
				System.out.println(e.getMessage());
				System.out.println("Torna a introduir les dades del producte de nou.");
				
			}
		}		
	}
	
	/**
	 * OPCIO 3
	 * -------
	 * Es demana a l'usuari les dades corresponents per a crear un nou producte i afegir-lo a l'stock de
	 * la floristeria actual.
	 * Si encara no s'ha seleccionat cap floristeria actual es mostra missatge informatiu per pantalla.
	 * 
	 * 1. es demana el preu del nou producte
	 * 2. es demana que indiqui el tipus de producte (arbre, flor o decoracio)
	 * 2.1. si selecciona arbre, se li demana a l'usuari que introdueixi l'alçada
	 * 2.2. si selecciona flor, se li demana a l'usuari que introdueixi el color
	 * 2.3. si selecciona decoracio, se li demana a l'usuari que seleccioni el material
	 * 
	 * Finalment es pregunta a l'usuari si vol afegir més productes, i en cas afirmatiu es tornar a iniciar el mètode
	 * 
	 * @throws Exception
	 */
	public void addProducte() throws Exception{
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
	
	/**
	 * OPCIO 4
	 * -------
	 * 
	 * S'obté de la vista un String amb format que conté tot el llistat de productes de l'stock de la
	 * floristeria i es mostra per pantalla.
	 * Si encara no s'havia seleccionat cap floristeria actual, s'informa per pantalla.
	 * 
	 */
	public void showCurrentStockFloristeria() {
		
		if(controller.getCurrentFloristeria()==null) {
			System.out.println("Encara no has seleccionat una floristeria actual.");
		}else {
			Floristeria currentFloristeria = controller.getCurrentFloristeria();
			String outputStock = this.view.showFloristeriaDetails(currentFloristeria);
			System.out.println(outputStock);
		}
		
	}
	
	
}
