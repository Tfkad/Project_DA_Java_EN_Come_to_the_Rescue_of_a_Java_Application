package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0 
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	// err chemin d'accès manquant
	private static String chemin = "C:\\Users\\C_local\\Documents\\Openclassrooms\\Developpeur_Java\\Projet_2\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\\\Project02Eclipse\\";
		
	public static void main(String args[]) throws Exception {
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
	}
}
