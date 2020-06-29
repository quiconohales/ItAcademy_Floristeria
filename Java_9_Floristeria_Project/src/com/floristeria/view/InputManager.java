package com.floristeria.view;

import java.util.Scanner;

import com.floristeria.application.FloristeriaController;

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
		String outputMenu = this.view.showMainMenu();
		String currentFloristeriaName = this.view.showCurrentFloristeria();
		System.out.println(outputMenu);
		System.out.println(currentFloristeriaName);

	}
	
	public void showMenuFloristeriaNames() {
		
	}

	
	public void createFloristeria() {
		
	}
	
	public void selectCurrentFloristeria() {
		
	}
	
	public void addProducte() {

	}
	
	public void showCurrentStockFloristeria() {
		String outputStock = this.view.showFloristeriaDetails();
		System.out.println(outputStock);

	}
		
}
