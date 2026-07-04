package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Writes symptom data and their occurrence counts to a text file
 * 
 * This class implements the {@code ISymptomWriter} interface and saves
 * the content of a map into an output file named {@code output.txt}
 */

public class WriteSymptomDataFromFile implements ISymptomWriter {
	// Path to the directory where the output file will be created
	private String filepath;
	
	// Map containing symptoms and their occurrence counts
	private Map<String, Integer> SymptomMap;
	
	/*
	 * Creates a new writer for symptom data
	 * 
     * @param filepath the path to the directory where the output file will be created
     * 
     * @param SymptomMap the map containing symptoms and their occurrence counts
	 */
	public WriteSymptomDataFromFile (String filepath, Map<String, Integer> SymptomMap) {
		this.filepath = filepath;
		this.SymptomMap = SymptomMap;
	}
		
	/*
     * Writes the symptom data to the {@code output.txt} file
     * 
     * Each entry is written on a separate line
     * 
     * @param SymptomMap the map containing the symptoms to write
     */
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

