package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;

public class ReadSymptomDataFromMemory implements ISymptomReader {
	// constructeur par défaut suffisant car pas de parametre
	
	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		result.add("fievre");
		result.add("saignement");
		result.add("hematome");
		result.add("fievre");
		return result;
	}
}
