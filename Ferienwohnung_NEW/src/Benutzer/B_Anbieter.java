package Benutzer;

import java.util.Scanner;

import Ferienwohnung.Ferienwohnung;

public class B_Anbieter extends Benutzer {
	// Attribute

	// Konstruktor

	public B_Anbieter() {
		super();
		setGast(false);
		// TODO Auto-generated constructor stub
	}

	public B_Anbieter(String benutzer, String passwort, String vorname, String nachname) {
		super(benutzer, passwort, vorname, nachname);
		setGast(false);
		// TODO Auto-generated constructor stub
	}

	// Methoden
	public void zeigeDaten() {

		System.out.println("***Benutzerdaten***");
		System.out.println("(1) Benutzername: " + getBenutzer());
		System.out.println("(2) Vorname: " + getVorname());
		System.out.println("(3) Nachname: " + getNachname());
		System.out.println();

	}

	// Methode ändere Daten
	public void ändereDaten() {
		zeigeDaten();
		System.out.println("Bitte eine der oben aufgeführten Zahlen ein um die entsprechende Information anzupassen");
		Scanner scan = new Scanner(System.in);
		int eingabe = scan.nextInt();
		switch (eingabe) {
		case 1: {
			System.out.println("Benutzername aktuell: " + getBenutzer());
			System.out.println("Eingabe neuer Benutzername:");
			String benutzerString = scan.next();
			setBenutzer(benutzerString);
			break;
		}
		case 2: {
			System.out.println("Vorname aktuell: " + getVorname());
			System.out.println("Eingabe neuer Vorname:");
			String vornameString = scan.next();
			setVorname(vornameString);
			break;
		}

		case 3: {
			System.out.println("Nachname aktuell: " + getNachname());
			System.out.println("Eingabe neuer Nachname");
			String nachnameString = scan.next();
			setNachname(nachnameString);
			break;

		}

		default:
			throw new IllegalArgumentException("Falsche Eingabe, bitte versuchen Sie es erneut");
		}

	}

	// Methode LogIn Anbieter

}
