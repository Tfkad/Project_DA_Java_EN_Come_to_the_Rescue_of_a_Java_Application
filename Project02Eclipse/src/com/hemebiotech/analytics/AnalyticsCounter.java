package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0 
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	// err chemin d'accès manquant
	private static String chemin = "C:\\Users\\C_local\\Documents\\Openclassrooms\\Developpeur_Java\\Projet_2\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\\\Project02Eclipse\\symptoms.txt";
		
	public static void main(String args[]) throws Exception {
		
		// creation objet readSymptom de type ISymptomReader (qui est une interface) et de classe ReadSymptomDataFromMemory 
		ISymptomReader readSymptom = new ReadSymptomDataFromFile(chemin);
		
		// création objet Map clé=symptom et valeur=nb symptom
		Map<String, Integer> SymptomMap = new HashMap <>();
				
		// remplir une liste à partir du fichier
		List<String> listSymptom = readSymptom.GetSymptoms();
		
		// boucler sur la ArrayList retournée listSymptom
		for(String symptom : listSymptom) { // Syntaxe ?
			
			// ajout si clé non trouvé dans la map
			if (!SymptomMap.containsKey(symptom)) {
				SymptomMap.put(symptom, 1);
			}
			else {
				// incrémente la valeur si clé existe déjà dans la Map
				SymptomMap.replace(symptom, SymptomMap.get(symptom)+1);
			}
			
			// print de la List
			System.out.println(symptom);
		}
		
		// Print de la Map
		System.out.println(SymptomMap);
	
		WriteSymptom();
		
		
		/*		
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader(chemin + "symptoms.txt"));
		String line = reader.readLine();

		int i = 0;	// set i to 0 // err i est inutile
		// int headacheCount = 0;	// err déjà déclaré
		while (line != null) {
			i++;	// increment i
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++; // err headacheCount vs headCount
				System.out.println("number of headaches: " + headacheCount); // err headacheCount vs headCount
			}
			else if (line.equals("rash")) { // err rash vs rush
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter (chemin + "result.out"); // err ajout chemin
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
		 */
	} 
		
}
