package Programm;

import java.util.HashMap;
import java.util.Scanner;

import Datenbank.DatenbankBenutzer;
import Datenbank.DatenbankFerienwohnung;
import Ferienwohnung.Ferienwohnung;

public class BuchungSeite {
	
	static HashMap<Integer, Ferienwohnung> spreewaldFerienwohnungMap;
	static DatenbankFerienwohnung spreewaldDB = new DatenbankFerienwohnung(spreewaldFerienwohnungMap);

	// Übersicht Ferienwohnung
	public void bookingPage() {
		System.out.println("Der LogIn war erfolgreich, bitte Wählen Sie eine der folgenden Ferienwohnungen aus:");
		System.out.println("-----");

		System.out.println("Menü:");
		Scanner scan = new Scanner(System.in);
		int eingabeZahl = scan.nextInt();
		
		switch (eingabeZahl) {
		case 1: {
			Ferienwohnung myFewo = spreewaldFerienwohnungMap.get(eingabeZahl);
			int nextStep = myFewo.waehleFerienwohnung();
			switch (nextStep) {
			case value: {
				
				yield type;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + key);
			}
			
			
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + eingabeZahl);
		}
		

	}

	// Auswahl Ferienwohnungen
	
	

	// Prüfe Verfügbarkeit

	
	// Buchung Ferienwohnung

	
	// Rechnung / Buchungsbestätigung

}
