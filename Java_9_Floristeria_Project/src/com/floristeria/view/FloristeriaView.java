package com.floristeria.view;

import java.util.List;

import com.floristeria.domain.Arbre;
import com.floristeria.domain.Decoracio;
import com.floristeria.domain.Flor;
import com.floristeria.domain.Floristeria;
import com.floristeria.domain.Fusta;
import com.floristeria.domain.Plastic;
import com.floristeria.domain.Producte;

public class FloristeriaView {

	/**
	 * Mostra el menu principal amb totes les opcions entre les quals pot escollir l'usuari
	 * @return retorna un String amb format per ser mostrat el menu per pantalla
	 */
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
	
	/**
	 * Mostra tot l'stock de productes de la floristeria
	 * Fa un recorregut de la llista de productes que conté l'objecte floristeria passat per paràmetre
	 * i mostra tota la informació de cada producte
	 * 
	 * @param floristeria
	 * @return retorna un String amb format per ser mostrat l'stock de la floristeria per pantalla
	 */
	public String showFloristeriaDetails(Floristeria floristeria) {
		
		String output="";
		
		output += "------------------------------------- \n";
		output += "STOCK DE FLORISTERIA : " + floristeria.getName() + "\n";
		output += "------------------------------------- \n";

		int i=1;
		
		for (Producte producte : floristeria.getStockList()) {
			output += "Producte " + i + ": [preu = " + producte.getPrice() + "] ";
			output += showProducteDetails(producte) + "\n";
			i++;
		}
		
		if(i==1) output +="Encara no has creat/afegit cap producte al stock d'aquesta floristeria.";
		
		return output;
	}
	
	/**
	 * Mostra tots els detalls del parametre producte en funció de la subclasse a la qual pertany 
	 * (Arbre/Flor/Decoracio)
	 * 
	 * @param producte
	 * @return retorna un String amb una linia que informa del tipus de producte i tota la seva informació
	 */
	public String showProducteDetails(Producte producte) {
		
		String output = "";
		
		if (producte instanceof Flor) {
			
			Flor flor = (Flor) producte;
			output +=" FLOR :";
			output +=" [color = " + flor.getColor() + " ]";
			
		}else if (producte instanceof Arbre) {
			
			Arbre arbre = (Arbre) producte;
			output +=" ARBRE :";
			output +=" [alçada = " + arbre.getHeight() + " ]";	
			
		}else if (producte instanceof Decoracio) {
			
			Decoracio decor = (Decoracio) producte;
			output +=" DECORACIO :";
			
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
	
	/**
	 * Mostra el nom en majúscules de la floristeria actual passada per paràmetre
	 * 
	 * 
	 * @param floristeria
	 * @return retorna un String amb format per ser mostrada la floristeria actual per pantalla
	 */
	public String showCurrentFloristeria(Floristeria floristeria) {
		
		String output = "";
		if (floristeria!=null) {
			output += "Floristeria Actual: "+ floristeria.getName().toUpperCase() + "\n";
		}else {
			output += "Encara no has seleccionat cap floristeria actual. \n";
		}
		output += "------------------------------------- ";
		
		return output;
	}
	
	/**
	 * Mostra un menu amb tots els noms de les floristeries del parametre llista floristeriaList
	 * 
	 * @param floristeriaList
	 * @return retorna un String amb format per a mostrar el menu de floristeries
	 */
	public String showMenuFloristeriaNames(List<Floristeria> floristeriaList) {
		
		String output = "";
		
		output += "------------------------------------- \n";
		output += "       LLISTAT DE FLORISTERIES        \n";
		output += "------------------------------------- \n";
		
		int i=1;
		for (Floristeria f : floristeriaList) {
			output += i +". " + f.getName() + "\n";
			i++;
		}
		
		output += "------------------------------------- ";

		
		return output;
	}
	
	/**
	 * Mostra fi del programa
	 * 
	 * @return
	 */
	public String endProgram() {
		String output = "";
		output += "------------------------------------- \n";
		output += "      	   FI DEL PROGRAMA           \n";
		output += "------------------------------------- \n";
		return output;
		
	}
}
