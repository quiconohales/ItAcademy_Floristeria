package com.floristeria.view;

import com.floristeria.domain.Arbre;
import com.floristeria.domain.Decoracio;
import com.floristeria.domain.Flor;
import com.floristeria.domain.Floristeria;
import com.floristeria.domain.Fusta;
import com.floristeria.domain.Plastic;
import com.floristeria.domain.Producte;

public class FloristeriaView {

	public String showMainMenu() {
		
		String output="";
		
		output += "------------------------------------- \n";
		output += "               MENU                   \n";
		output += "------------------------------------- \n";
		output += "1. Crear Floristeria \n";
		output += "2. Seleccionar floristeria actual \n";
		output += "3. Afegir producte a floristeria actual \n";
		output += "4. Visualitzar stock de floristeria actual \n";
		output += "5. Sortir del programa \n";
		output += "------------------------------------- ";
		
		return output;
	}
	
	public String showFloristeriaDetails(Floristeria floristeria) {
		
		String output="";
		
		output += "------------------------------------- \n";
		output += "STOCK DE FLORISTERIA : " + floristeria.getName() + "\n";
		output += "------------------------------------- \n";

		int i=1;
		
		for (Producte producte : floristeria.getStockList()) {
			output += "Producte " + i + ": [preu = " + producte.getPrice() + "] ";
			output += showProducteDetails(producte) + "\n";
		}
		
		return output;
	}
	
	public String showProducteDetails(Producte producte) {
		
		String output = "";
		
		if (producte instanceof Flor) {
			
			Flor flor = (Flor) producte;
			output +=" FLOR :";
			output +=" [color = " + flor.getColor() + " ]";
			
		}else if (producte instanceof Arbre) {
			
			Arbre arbre = (Arbre) producte;
			output +=" ARBRE ";
			output +=" [alçada = " + arbre.getHeight() + " ]";	
			
		}else if (producte instanceof Decoracio) {
			
			Decoracio decor = (Decoracio) producte;
			output +=" DECORACIO ";
			
			String tipusMaterial = "";
			if (decor.getMaterial() instanceof Fusta) {
				tipusMaterial = "Fusta";
			}else if(decor.getMaterial() instanceof Plastic) {
				tipusMaterial = "Plastic";
			}
				
			output +=" [material = " + tipusMaterial + " ]";
		}
		
		return output;
	}
	
	public String showCurrentFloristeria(Floristeria floristeria) {
		
		String output = "";
		if (floristeria!=null) {
			output += "Floristeria Actual: "+ floristeria.getName() + "\n";
		}else {
			output += "Encara no has seleccionat cap floristeria actual. \n";
		}
		output += "------------------------------------- ";
		
		return output;
	}
	
	public String showMenuFloristeriaNames() {
		
		return "";
	}
}
