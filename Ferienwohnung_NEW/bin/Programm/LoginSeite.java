package Programm;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;

import Benutzer.B_Direktkunde;
import Benutzer.Benutzer;
import Datenbank.DatenbankBenutzer;

public class LoginSeite {

	static HashMap<String, Benutzer> spreewaldBenutzerMap;
	static DatenbankBenutzer spreewaldDB = new DatenbankBenutzer(spreewaldBenutzerMap);

	public static boolean LoginPage () {
		
		System.out.println("Herzlich Wilkommen zu unserem Ferienwohnungstool für Ferienwohnungen im Spreewald");
		System.out.println("-----");

		
		System.out.println("Menü:\n-1- LogIn\n-2- Passwort vergessen\n-3- Benutzer erstellen");
		Scanner scan = new Scanner(System.in);
		int eingabeZahl = scan.nextInt();
		
		switch (eingabeZahl) {
		case 1: {
			System.out.println("Eingabe Benutzer:");
			String benutzer = scan.next();
			System.out.println("Eingabe Passwort:");
			String passwort = scan.next();
			if (spreewaldBenutzerMap.get(passwort).getBenutzer() == benutzer) {
				return true;
			}
			else {
				System.out.println("Passwort oder Benutzername ist falsch. Bitte versuchen Sie es erneut.");
			}
		}
		case 2: {
			System.out.println("Wie lautet dein Benutzername?");
			String benutzerString = scan.next();
			System.out.println("Ihr Passwort lautet " + spreewaldDB.searchPasswort(benutzerString));
			return false;			 
		}
		case 3: {
			System.out.println("Was für einen Benutzer möchtest du erstellen?");
			System.out.println("-1- Gast\n-2- Anbieter");
			int eingabeZahl2 = scan.nextInt();
			
			switch (eingabeZahl2) {
			case 1: {
				B_Direktkunde myB_Direktkunde = new B_Direktkunde();
				myB_Direktkunde = myB_Direktkunde.erstelleBenutzer();
				spreewaldDB.insertDatenbank(myB_Direktkunde.getPasswort(), myB_Direktkunde);		
			}
			case 2: {
				Benutzer myBenutzer = new Benutzer();
				myBenutzer = myBenutzer.erstelleBenutzer();
				spreewaldDB.insertDatenbank(myBenutzer.getPasswort(), myBenutzer);
			}
			default:
				System.out.println("Die eingegebene Zahl existiert nicht in der Auswahl.");
				return false;
			}
			
			
			
			
		}
		default:
			System.out.println("Die eingegebene Zahl existiert nicht im Menü. Bitte eine neue Zahl verwenden.");
			return false;
		}

		
		
	}

	
	
	

	
}
