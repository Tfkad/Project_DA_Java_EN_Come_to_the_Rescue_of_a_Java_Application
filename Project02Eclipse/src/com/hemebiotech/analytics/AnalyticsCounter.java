package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	// private static int headacheCount = 0;	// initialize to 0 
	// private static int rashCount = 0;		// initialize to 0
	// private static int pupilCount = 0;		// initialize to 0
		
	// File workDir = new File(System.getProperty("user.dir"));
	// File resourcesDir = new File(workDir, "resources") 
	
	private static String chemin = "C:\\Users\\C_local\\Documents\\Openclassrooms\\Developpeur_Java\\Projet_2\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\\\Project02Eclipse\\";
	
	public static List <String> getSymptoms() {
		// creation objet readSymptom de type ISymptomReader (qui est une interface) et de classe ReadSymptomDataFromFile
		ISymptomReader readSymptom = new ReadSymptomDataFromFile(chemin + "symptoms.txt");
		
		// remplir une liste à partir du fichier
		return readSymptom.GetSymptoms();
	}
	
	public static Map <String, Integer> countSymptoms(List <String> listSymptoms) {
		// création objet clé=symptom et valeur=nb symptom
		Map<String, Integer> symptomMap = new HashMap <>();
				
		// countSymptoms boucler sur la ArrayList listSymptoms 
		for(String symptom : listSymptoms) {
			// ajout si clé non trouvé dans la map
			if (!symptomMap.containsKey(symptom)) {
				symptomMap.put(symptom, 1);
			}
			else {
				// incrémente la valeur si clé existe déjà dans la Map
				symptomMap.replace(symptom, symptomMap.get(symptom)+1);
			}
		}
		return symptomMap;
	} 

	public static Map <String, Integer> sortSymptoms(Map <String, Integer> mapSymptoms) {
		// transformer la HasMap en TreeMap (trié)
		
		// création objet clé=symptom et valeur=nb symptom
		Map <String, Integer> treeSymptomMap = new TreeMap <>();
		
		for (Map.Entry<String, Integer> entry : mapSymptoms.entrySet()) {
			treeSymptomMap.putAll(mapSymptoms);
		}	
		return treeSymptomMap;
	} 
	
	public static void writeSymptoms(Map <String, Integer> mapSymptoms) {
		// creation objet writeSymptom de type ISymptomWriter (qui est une interface) et de classe WriteSymptomDataFromFile 
		ISymptomWriter writeSymptom = new WriteSymptomDataFromFile(chemin, mapSymptoms);
				
		// écrire dans un fichier les symptomes et les qté
		writeSymptom.WriteSymptoms(mapSymptoms);
	} 
	
	public static void main(String args[]) throws Exception {
		// lecture du fichier des symptomes
		List<String> listSymptom = AnalyticsCounter.getSymptoms();
		
		// compter par symptome				
		Map <String, Integer> mapSymptom = AnalyticsCounter.countSymptoms(listSymptom);
		
		// tri des symptomes	
		Map <String, Integer> treeMapSymptom = AnalyticsCounter.sortSymptoms(mapSymptom);
		
		// Print avant et après le tri
		System.out.println(mapSymptom);
		System.out.println(treeMapSymptom);
		
		// enregistrement des résultats dans un fichier
		AnalyticsCounter.writeSymptoms(treeMapSymptom);
	} 
}
