package com.floristeria.view;

import java.util.Scanner;

import com.floristeria.application.FloristeriaController;
import com.floristeria.domain.Floristeria;

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
			
			if(exit==false) commons.pause();
		}

	}

	//1
	public void createFloristeria() {
		System.out.println("1 createFloristeria");

	}
	//2
	public void selectCurrentFloristeria() {
		System.out.println("2 selectCurrentFloristeria");

	}
	//3
	public void addProducte() {
		System.out.println("3 addProducte");

	}
	//4
	public void showCurrentStockFloristeria() {
		
		if(controller.getCurrentFloristeria()==null) {
			System.out.println("Encara no has seleccionat una floristeria actual.");
		}else {
			Floristeria currentFloristeria = controller.getCurrentFloristeria();
			String outputStock = this.view.showFloristeriaDetails(currentFloristeria);
			System.out.println(outputStock);
		}
		
	}
		
	public void showMenuFloristeriaNames() {
		System.out.println("showMenuFloristeriaNames");
	}
	
}
