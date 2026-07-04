package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * javadoc
 */

public class WriteSymptomDataFromFile implements ISymptomWriter {
	private String filepath;
	private Map<String, Integer> SymptomMap;
	
	// constructeur avec parametre	
	public WriteSymptomDataFromFile (String filepath, Map<String, Integer> SymptomMap) {
		this.filepath = filepath;
		this.SymptomMap = SymptomMap;
	}
		
	@Override
	public void WriteSymptoms(Map<String, Integer> SymptomMap) {
		try (FileWriter writer = new FileWriter(filepath + "output.txt") ) {
			for (Map.Entry<String, Integer> entry : SymptomMap.entrySet()) {
				// System.out.println(entry.getKey() + " : " + entry.getValue() + "\r\n");
				writer.write(entry.getKey() + " : " + entry.getValue() + "\r\n");
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}

