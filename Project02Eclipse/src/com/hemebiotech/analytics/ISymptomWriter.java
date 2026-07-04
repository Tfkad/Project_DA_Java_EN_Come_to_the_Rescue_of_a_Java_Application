package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Defines the contract for writing symptom data
 * 
 * Classes implementing this interface are responsible for writing
 * symptom occurrence data to a destination such as a file, a database,
 * or another output medium
 */

public interface ISymptomWriter {
	
	/**
     * Writes the symptom data
     * 
     * @param SymptomMap a map containing symptom names as keys and their
     * occurrence counts as values
     */
	void WriteSymptoms (Map<String, Integer> SymptomMap);
}
