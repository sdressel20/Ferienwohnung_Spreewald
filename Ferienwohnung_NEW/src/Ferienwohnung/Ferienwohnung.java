package Ferienwohnung;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import x_Old.Kalender;

public class Ferienwohnung {

	public static int anzahl_Ferienwohnungen;

	// Attribute

	private String name;
	private int groesse;
	private int netto_preis;
	private int anzahl_pax;
	private int mindestlaufzeit;
	private String stadt;
	private String strasse;

	// Konstruktor

	public Ferienwohnung(String name, int groesse, int preis, int anzahl_pax, int mindestlaufzeit, String stadt,
			String strasse) {
		this.name = name;
		this.groesse = groesse;
		this.netto_preis = preis;
		this.anzahl_pax = anzahl_pax;
		this.mindestlaufzeit = mindestlaufzeit;
		this.stadt = stadt;
		this.strasse = strasse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStadt() {
		return stadt;
	}

	public void setAdresse(String stadt) {
		this.stadt = stadt;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public void setStadt(String stadt) {
		this.strasse = strasse;
	}

	public int getMindestlaufzeit() {
		return mindestlaufzeit;
	}

	public void setMindestlaufzeit(int mindestlaufzeit) {
		this.mindestlaufzeit = mindestlaufzeit;
	}

	public int getAnzahl_pax() {
		return anzahl_pax;
	}

	public void setAnzahl_pax(int anzahl_pax) {
		this.anzahl_pax = anzahl_pax;
	}

	public int getGroesse() {
		return groesse;
	}

	public void setGroesse(int groesse) {
		this.groesse = groesse;
	}

	public int getPreis() {
		return netto_preis;
	}

	public void setPreis(int preis) {
		this.netto_preis = preis;
	}

	// Methoden

	public String toString() {
		return "Groesse: " + this.groesse + " | Preis: " + this.netto_preis + " | PAX: " + this.anzahl_pax
				+ " | Adresse: " + this.stadt + ", " + this.strasse + " | Mindestlaufzeit: " + this.mindestlaufzeit;
	}

	// Methode Auswahl Ferienwohnung

	public int waehleFerienwohnung() {
		System.out.println("Hier finden Sie alle Informationen zu der Ferienwohnung " + this.getName());
		this.zeigeDaten();
		System.out.println();
		System.out.println("Bitte wählen Sie Ihe weiteren Optionen:");

		Scanner scan = new Scanner(System.in);
		int eingabeZahl = scan.nextInt();

		return eingabeZahl;

	}

	public void zeigeBilder() {

	}

	// Anfrage verschicken
	public String anfrageFerienwohnung() throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		String today = df.format(Calendar.getInstance().getTime());
		Scanner scan = new Scanner(System.in);
		Date todayDate = df.parse(today);
		String ankunft = null, abreise = null;
		Date ankunftDate = null, abreiseDate = null;

		boolean notPast = false;
		while (notPast == false) {
			System.out.println("Bitte geben Sie das gewünschte Anreisedatum ein: (Format: TT.MM.JJJJ)");

			ankunft = scan.next();
			ankunftDate = df.parse(ankunft);
			notPast = checkAnkunft(ankunftDate);
			if (notPast == false) {
				System.out.println();
				System.out.println("x x x x x x x x x x");
				System.out
						.println("Das Ankunftsdatum liegt in der Vergangenheit - bitte geben Sie ein neues Datum ein.");
				System.out.println("x x x x x x x x x x");
				System.out.println();

			}

		}
		boolean nachAnkunft = false;
		while (nachAnkunft == false) {
			System.out.println("Bitte geben Sie das gewünschte Abreisedatum ein: (Format: TT.MM.JJJJ)");
			abreise = scan.next();
			abreiseDate = df.parse(abreise);
			nachAnkunft = checkAbreise(ankunftDate, abreiseDate, getMindestlaufzeit());
			if (nachAnkunft == false) {
				System.out.println();
				System.out.println("x x x x x x x x x x");
				System.out.println(
						"Sie haben die Mindestaufenthalt der Ferienwohnung nicht erreicht - bitte geben Sie ein neues Datum ein."
								+ "\nDas früheste Abreisedatum ist der "
								+ berechneFrühestenAbreisetag(ankunftDate, mindestlaufzeit));
				System.out.println("x x x x x x x x x x");
				System.out.println();

			}

		}
		String buchungString = "----\n*Buchungsanfrage versendet*\nFerienwohnung: " + this.getName() + "\nAnreise: "
				+ ankunft + "\nAbreise: " + abreise + "\nPreis: " + berechnePreis(ankunftDate, abreiseDate);
		System.out.println(buchungString);
		System.out.println();
		return buchungString;

	}

	public boolean checkAnkunft(Date ankunft) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		String today = df.format(Calendar.getInstance().getTime());
		Date todayDate = df.parse(today);

		boolean result = todayDate.before(ankunft);
		return result;
	}

	public boolean checkAbreise(Date ankunft, Date abreise, int mindestlaufzeit) throws ParseException {
		Calendar c = Calendar.getInstance();
		c.setTime(ankunft);
		c.add(Calendar.DAY_OF_MONTH, mindestlaufzeit);
		Date minDauer = c.getTime();
		boolean result = minDauer.before(abreise);
		return result;
	}

	public String berechneFrühestenAbreisetag(Date ankunft, int mindestlaufzeit) {
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(ankunft);
		c.add(Calendar.DAY_OF_MONTH, mindestlaufzeit + 1);
		Date minDauer = c.getTime();
		String date = DATE_FORMAT.format(minDauer);
		return date;
	}

	public String berechnePreis(Date ankunft, Date abreise) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(ankunft);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(abreise);
		int reisedauer = (int) ((abreise.getTime() - ankunft.getTime()) / (1000 * 60 * 60 * 24));
		int preis = getPreis() * reisedauer;
		String preisString = String.valueOf(preis);
		return preisString + " EUR";
	}

	public void zeigeDaten() {

		System.out.println("***Details***");
		System.out.println("(1) Name: " + getName());
		System.out.println("(2) Stadt: " + getStadt());
		System.out.println("(3) Strasse: " + getStrasse());
		System.out.println("(4) Mindestaufenthalt: " + getMindestlaufzeit() + " Nächte");
		System.out.println("(5) Kapazität Gäste: " + getAnzahl_pax());
		System.out.println("(6) Größe: " + getGroesse() + " qm");
		System.out.println("(7) Preis: " + getPreis() + " EUR");
		System.out.println();

	}

	public void ändereDaten() {
		zeigeDaten();
		System.out.println("Bitte eine der oben aufgeführten Zahlen ein um die entsprechende Information anzupassen");
		Scanner scan = new Scanner(System.in);
		int eingabe = scan.nextInt();
		switch (eingabe) {
		case 1: {
			System.out.println("Name aktuell: " + getName());
			System.out.println("Eingabe neuer Name:");
			String nameString = scan.next();
			setName(nameString);
			break;
		}
		case 2: {
			System.out.println("Stadt aktuell: " + getStadt());
			System.out.println("Eingabe neue Stadt");
			String stadtString = scan.next();
			setStadt(stadtString);
			break;
		}

		case 3: {
			System.out.println("Strasse aktuell: " + getStrasse());
			System.out.println("Eingabe neue Strasse:");
			String strasseString = scan.next();
			setStrasse(strasseString);
			break;
		}

		case 4: {
			System.out.println("Mindestaufenthalt aktuell: " + getMindestlaufzeit());
			System.out.println("Eingabe neue Mindestaufenthalt:");
			int minestlaufzeit = scan.nextInt();
			setMindestlaufzeit(minestlaufzeit);
			break;

		}

		case 5: {
			System.out.println("Kapazität Gäste aktuell: " + getAnzahl_pax());
			System.out.println("Eingabe neue Kapazität Gäste:");
			int pax = scan.nextInt();
			setAnzahl_pax(pax);
			break;

		}
		case 6: {
			System.out.println("Größe aktuell: " + getGroesse());
			System.out.println("Eingabe neue Größe:");
			int groesse = scan.nextInt();
			setGroesse(groesse);
			break;

		}
		case 7: {
			System.out.println("Preis aktuell: " + getPreis());
			System.out.println("Eingabe neuer Preis pro Nacht:)");
			int preis = scan.nextInt();
			setPreis(preis);
			break;

		}
		default:
			throw new IllegalArgumentException("Falsche Eingabe, bitte versuchen Sie es erneut");
		}

	}

}
