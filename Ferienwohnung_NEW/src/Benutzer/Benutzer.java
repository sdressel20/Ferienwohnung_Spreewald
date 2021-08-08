package Benutzer;

import java.util.Scanner;

public class Benutzer {

	// Attribute

	
	private String benutzer;
	private String passwort;
	private String vorname;
	private String nachname;
	private boolean isGast;

	// Konstruktor

	public Benutzer() {

	}

	public Benutzer(String benutzer, String passwort, String vorname, String nachname) {
		super();
		this.benutzer = benutzer;
		this.passwort = passwort;
		this.vorname = vorname;
		this.nachname = nachname;
	}

	// Methoden

	public String getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(String benutzer) {
		this.benutzer = benutzer;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}


	public boolean getIsGast() {
		return this.isGast;
	}

	public void setGast(boolean isGast) {
		this.isGast = isGast;
	}

	// Methode Benutzer erstellen
	
	public Benutzer erstelleBenutzer() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Eingabe Benutzername:");
		String benutzerString = scan.next();
		System.out.println("Eingabe Passwort:");
		String passwortString = scan.next();
		System.out.println("Eingabe Vorname:");
		String vornameString = scan.next();
		System.out.println("Eingabe Nachname");
		String nachnameString = scan.next();

		Benutzer myBenutzer = new Benutzer(benutzerString, passwortString, vornameString, nachnameString);
		System.out.println("Ein neuer Benutzer mit dem Benutzernamen - " + myBenutzer.benutzer + " - wurde erstellt.");
		return myBenutzer;

		// Methode LogIn Benutzer

		// Methode Passwort ändern

	}

}
