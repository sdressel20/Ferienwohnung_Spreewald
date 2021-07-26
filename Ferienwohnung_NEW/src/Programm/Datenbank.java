package Programm;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;

import Benutzer.Benutzer;

public class Datenbank {

	// Attribute

	public HashMap<String, Benutzer> myDatenbank;
	
	// Konstruktor
	
	public Datenbank(HashMap<String, Benutzer> db) {
		this.myDatenbank = db;
		
	}

	// Methoden

	public void insertDatenbank(String passwort, Benutzer newB) {
		myDatenbank.put(passwort, newB);

	}

	public String searchPasswort(String benutzer) {
		String passwortString = Datenbank.getSingleKeyFromValue(myDatenbank, benutzer);
		return passwortString;
	}

	public static <K, V> String getSingleKeyFromValue(Map<String, Benutzer> key, String value) {
		for (Entry<String, Benutzer> entry : key.entrySet()) {
			if (Objects.equals(value, entry.getValue())) {
				return entry.getKey();
			}
		}
		return null;
	}
}
