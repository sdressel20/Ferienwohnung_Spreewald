package Programm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


import Datenbank.DatenbankBenutzer;
import Datenbank.DatenbankFerienwohnung;
import Ferienwohnung.Ferienwohnung;

public class BuchungSeite {

	public static HashMap<Integer, Ferienwohnung> spreewaldFerienwohnungMap = new HashMap<>();
	public static DatenbankFerienwohnung spreewaldDB = new DatenbankFerienwohnung(spreewaldFerienwohnungMap);
	
	// Anlegen Ferienwohnungen
	static Ferienwohnung ersteFerienwohnung = new Ferienwohnung("Naturpalast", 82, 75, 4, 4, "Lübben",
			"Kirchstrasse 5");
	static Ferienwohnung zweiteFerienwohnung = new Ferienwohnung("Gurkenfass", 45, 40, 2, 4, "Burg", "Marktplatz 9");
	static Ferienwohnung dritteFerienwohnung = new Ferienwohnung("Kanalsiedlung", 93, 85, 5, 4, "Schlepzig",
			"Bachweg 1");

	// Übersicht Ferienwohnung
	public static Ferienwohnung hauptmenü() {
		spreewaldDB.insertDatenbank(1, ersteFerienwohnung);
		spreewaldDB.insertDatenbank(2, zweiteFerienwohnung);
		spreewaldDB.insertDatenbank(3, dritteFerienwohnung);

		Ferienwohnung myFerienwohnung = wähleFerienwohnung();
		return myFerienwohnung;
		
		
	}

// Auswahl Ferienwohnungen

	public static Ferienwohnung wähleFerienwohnung() {
		System.out.println("HAUPTMENÜ\nBitte wählen Sie eine der folgenden Ferienwohnungen aus:");
		System.out.println("-----");

		for (int i = 1; i <= spreewaldDB.myDatenbank.size(); i++) {
			System.out.println("-" + i + "-" + " " + spreewaldDB.myDatenbank.get(i).getName() + " (Personen: "
					+ spreewaldDB.myDatenbank.get(i).getAnzahl_pax() + " )");
		}

		Scanner scan = new Scanner(System.in);
		int eingabeZahl = scan.nextInt();

		Ferienwohnung myFewo = spreewaldFerienwohnungMap.get(eingabeZahl);
		System.out.println("* * * * * * *");
		System.out.println("Ferienwohnung " + myFewo.getName());
		System.out.println("- - - - - - - - ");		
		System.out.println("Details: " + myFewo.toString());
		System.out.println();

		return myFewo;
		
		
	}

	
	
// Buchung Ferienwohnung

// Rechnung / Buchungsbestätigung

}
