package Benutzer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class B_Direktkunde extends Benutzer {

	// Attribute

	private int plz;
	private String strasse;
	private String stadt;
	private Date geburtsdatum;

	// Konstruktor

	public B_Direktkunde() {
		setGast(true);

	}

	public B_Direktkunde(String benutzer, String passwort, String vorname, String nachname, int plz, String strasse,
			String stadt, String geburtsdatum) {
		super(benutzer, passwort, vorname, nachname);
		this.plz = plz;
		this.strasse = strasse;
		this.stadt = stadt;
		try {
			this.geburtsdatum = new SimpleDateFormat("dd.MM.yyyy").parse(geburtsdatum);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setGast(true);

	}

	// Methoden

	@Override
	public void setGast(boolean isGast) {
		// TODO Auto-generated method stub
		super.setGast(isGast);
	}

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

	public String getGeburtsdatum() {
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
		String date = DATE_FORMAT.format(this.geburtsdatum);
		return date;
	}

	public void setGeburtsdatum(String geburtsdatum) {
		try {
			this.geburtsdatum = new SimpleDateFormat("dd.MM.yyyy").parse(geburtsdatum);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Methode volljaehrig() - prüft ob Kunde buchungsbefugt ist
	public boolean isVolljaehrig() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Date date1 = this.geburtsdatum;
		Calendar c = Calendar.getInstance();
		c.setTime(date1);
		c.add(Calendar.YEAR, 18);
		date1 = c.getTime();
		Date date2 = Calendar.getInstance().getTime();
		if (date1.before(date2)) {
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
		System.out.println("Eingabe Geburtsdatum:\n(Format dd.mm.jjjj)");
		String geburtsdatum = scan.next();

		B_Direktkunde myBenutzer = new B_Direktkunde(benutzerString, passwortString, vornameString, nachnameString, plz,
				strasseString, stadtString, geburtsdatum);
		System.out.println(
				"Ein neuer Gastzugang mit dem Benutzernamen - " + myBenutzer.getBenutzer() + " - wurde erstellt.");
		return myBenutzer;
	}

	// Methode zeigeDaten
	public void zeigeDaten() {
		
		System.out.println("***Benutzerdaten***");
		System.out.println("(1) Benutzername: " + getBenutzer());
		System.out.println("(2) Vorname: " + getVorname());
		System.out.println("(3) Nachname: " + getNachname());
		System.out.println("(4) PLZ: " + getPlz());
		System.out.println("(5) Stadt: " + getStadt());
		System.out.println("(6) Strasse: " + getStrasse());
		System.out.println("(7) Geburtsdatum: " + getGeburtsdatum());
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

		case 4: {
			System.out.println("PLZ aktuell: " + getPlz());
			System.out.println("Eingabe neue PLZ:");
			int plz = scan.nextInt();
			setPlz(plz);
			break;

		}

		case 5: {
			System.out.println("Strasse aktuell: " + getStrasse());
			System.out.println("Eingabe neue Strasse:");
			String strasseString = scan.next();
			setStrasse(strasseString);
			break;

		}
		case 6: {
			System.out.println("Stadt aktuell: " + getStadt());
			System.out.println("Eingabe neue Stadt");
			String stadtString = scan.next();
			setStadt(stadtString);
			break;

		}
		case 7: {
			System.out.println("Geburtsdatum aktuell: " + getGeburtsdatum());
			System.out.println("Eingabe neues Geburtsdatum:\n(Format dd.mm.jjjj)");
			String geburtsdatum = scan.next();
			setGeburtsdatum(geburtsdatum);
			break;

		}
		default:
			throw new IllegalArgumentException("Falsche Eingabe, bitte versuchen Sie es erneut");
		}

	}
}
