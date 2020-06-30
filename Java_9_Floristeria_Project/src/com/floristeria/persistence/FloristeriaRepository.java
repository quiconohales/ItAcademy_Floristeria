package com.floristeria.persistence;

import java.util.ArrayList;
import java.util.List;

import com.floristeria.domain.Floristeria;

public class FloristeriaRepository {

	private static List<Floristeria> floristeriasList = new ArrayList<>();
	
	public FloristeriaRepository() {
		
	}
	
	public List<Floristeria> getAllFloristeriasList() {
		return new ArrayList<>(floristeriasList);
	}
	
	public void addFloristeria(Floristeria floristeria) {
		floristeriasList.add(floristeria);
	}
	
}
