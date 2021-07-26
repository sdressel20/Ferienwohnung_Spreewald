package Benutzer;

import java.util.Scanner;

public class B_Direktkunde extends Benutzer {

	// Attribute

	private int plz;
	private String strasse;
	private String stadt;
	private int alter;

	// Konstruktor

	public B_Direktkunde() {
		
		
	}
	
	public B_Direktkunde(String benutzer, String passwort, String vorname, String nachname, int plz, String strasse,
			String stadt, int alter) {
		super(benutzer, passwort, vorname, nachname);
		this.plz = plz;
		this.strasse = strasse;
		this.stadt = stadt;
		this.alter = alter;
	}

	// Methoden

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getStadt() {
		return stadt;
	}

	public void setStadt(String stadt) {
		this.stadt = stadt;
	}

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}

	// Methode bestätige Buchung() - prüft ob alle Eingaben getätigt sind
	public boolean bestaetigeBuchung() {
		if (volljaehrig() == false) {
			return false;
		}
		if (this.getVorname().isEmpty()) {
			return false;
		} else if (this.getNachname().isEmpty()) {
			return false;
		} else if (this.plz == 0) {
			return false;
		} else if (this.strasse == null) {
			return false;
		} else if (this.stadt == null) {
			return false;
		} else {
			return true;
		}
	}

	// Methode volljaehrig() - prüft ob Kunde buchungsbefugt ist
	public boolean volljaehrig() {
		if (this.alter >= 18) {
			return true;
		} else {
			return false;
		}
	}

	// Methode Benutzer erstellen

	
	public B_Direktkunde erstelleBenutzer() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Eingabe Benutzername:");
		String benutzerString = scan.next();
		System.out.println("Eingabe Passwort:");
		String passwortString = scan.next();
		System.out.println("Eingabe Vorname:");
		String vornameString = scan.next();
		System.out.println("Eingabe Nachname");
		String nachnameString = scan.next();
		System.out.println("Eingabe PLZ:");
		int plz = scan.nextInt();
		System.out.println("Eingabe Strasse:");
		String strasseString = scan.next();
		System.out.println("Eingabe Stadt");
		String stadtString = scan.next();
		System.out.println("Eingabe Alter:");
		int alter = scan.nextInt();

		B_Direktkunde myBenutzer = new B_Direktkunde(benutzerString, passwortString, vornameString, nachnameString, plz, strasseString, stadtString, alter);
		System.out.println("Ein neuer Gastzugang mit dem Benutzernamen - " + myBenutzer.getBenutzer() + " - wurde erstellt.");
		return myBenutzer;
	}
}

// MEthode Benutzer bearbeiten

// Methode LogIn Benutzer