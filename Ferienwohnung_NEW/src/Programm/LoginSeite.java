package Programm;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;

import Benutzer.B_Anbieter;
import Benutzer.B_Direktkunde;
import Benutzer.Benutzer;
import Datenbank.DatenbankBenutzer;

public class LoginSeite {

	static HashMap<String, Benutzer> spreewaldBenutzerMap = new HashMap<>();
	static DatenbankBenutzer spreewaldDB = new DatenbankBenutzer(spreewaldBenutzerMap);

	static B_Direktkunde firstUser = new B_Direktkunde("Gurke", "gurke", "Mark", "Müller", 13583, "Schlustr. 1",
			"Berlin", "21.07.1995");
	static B_Direktkunde secondUser = new B_Direktkunde("Gurke2", "gurke2", "Marion", "Müller", 13583, "Schlustr. 1",
			"Berlin", "21.07.2008");
	static B_Anbieter firstAnbieter = new B_Anbieter("Chef", "pass123", "Meike", "Müller");

	public static boolean LoginPage() {

		
		System.out.println("Menü:\n-1- LogIn\n-2- Passwort vergessen\n-3- Benutzer erstellen");
		Scanner scan = new Scanner(System.in);
		int eingabeZahl = scan.nextInt();

		switch (eingabeZahl) {
		case 1: {
			return true;
		}
		case 2: {
			System.out.println("Wie lautet dein Benutzername?");
			String benutzerString = scan.next();
			System.out.println("Ihr Passwort lautet " + spreewaldDB.searchPasswort(benutzerString));
			return false;
		}
		case 3: {
			B_Direktkunde myB_Direktkunde = new B_Direktkunde();
			myB_Direktkunde = myB_Direktkunde.erstelleBenutzer();
			spreewaldDB.insertDatenbank(myB_Direktkunde.getPasswort(), myB_Direktkunde);
			return false;

		}
		default:
			System.out.println("Die eingegebene Zahl existiert nicht in der Auswahl.");
			return false;
		}

	}

	public static Benutzer benutzerLogin() {
		
		spreewaldDB.insertDatenbank(firstUser.getPasswort(), firstUser);
		spreewaldDB.insertDatenbank(firstAnbieter.getPasswort(), firstAnbieter);
		spreewaldDB.insertDatenbank(secondUser.getPasswort(), secondUser);

		System.out.println("Menü:\n-1- Gast\n-2- Anbieter");
		Scanner scan = new Scanner(System.in);
		int eingabeZahl = scan.nextInt();
		switch (eingabeZahl) {
		case 1:
			System.out.println("Eingabe Benutzer:");
			String benutzer = scan.next();
			System.out.println("Eingabe Passwort:");
			String passwort = scan.next();
			try {
				if (spreewaldDB.myDatenbank.get(passwort).getBenutzer().equals(benutzer)) {
					return spreewaldDB.myDatenbank.get(passwort);

				} else {
					System.out.println("Passwort oder Benutzername ist falsch. Bitte versuchen Sie es erneut.");
					return null;
				}

			} catch (NullPointerException e) {
				System.out.println("E - Passwort oder Benutzername ist falsch. Bitte versuchen Sie es erneut.");
				return null;
			}
		case 2:
			System.out.println("Eingabe Benutzer:");
			benutzer = scan.next();
			System.out.println("Eingabe Passwort:");
			passwort = scan.next();
			try {
				if (spreewaldDB.myDatenbank.get(passwort).getBenutzer().equals(benutzer)) {
					System.out.println("Anbieter check");
					return spreewaldDB.myDatenbank.get(passwort);
				} else {
					System.out.println("Passwort oder Benutzername ist falsch. Bitte versuchen Sie es erneut.");
					return null;
				}

			} catch (NullPointerException e) {
				System.out.println("Passwort oder Benutzername ist falsch. Bitte versuchen Sie es erneut.");
				return null;
			}
		default:
			
		}
		return null;

}
}
