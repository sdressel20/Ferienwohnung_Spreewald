package Datenbank;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;

import Ferienwohnung.Ferienwohnung;

public class DatenbankFerienwohnung {

	// Attribute

	public Map<Integer, Ferienwohnung> myDatenbank;

	// Konstruktor

	public DatenbankFerienwohnung(HashMap<Integer, Ferienwohnung> db) {
		this.myDatenbank = db;

	}

	// Methoden

	public void insertDatenbank(int nummer, Ferienwohnung newF) {
		myDatenbank.put(nummer, newF);

	}

	public int searchNummer(String benutzer) {
		int nummer = DatenbankFerienwohnung.getSingleKeyFromValue(myDatenbank, benutzer);
		return nummer;
	}

	public static <K, V> int getSingleKeyFromValue(Map<Integer, Ferienwohnung> key, String value) {
		for (Entry<Integer, Ferienwohnung> entry : key.entrySet()) {
			if (Objects.equals(value, entry.getValue())) {
				return entry.getKey();
			}
		}
		return (Integer) null;
	}

}
