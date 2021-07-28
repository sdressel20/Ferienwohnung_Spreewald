package Ferienwohnung;

public class Ferienwohnung {

	public static int anzahl_Ferienwohnungen;

    // Attribute

	private int groesse;
	private int preis;
	private int anzahl_pax;
	private int wohnungsID;
	private static String adresse;
	
	// Konstruktor
    
	public Ferienwohnung(int groesse, int preis, int anzahl_pax, int wohnungsId, String adresse) {
		this.groesse = groesse;
		this.preis = preis;
		this.anzahl_pax = anzahl_pax;
		this.wohnungsID = wohnungsId;
		this.adresse = adresse;
	}


	public static String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public int getWohnungsID() {
		return wohnungsID;
	}


	public void setWohnungsID(int wohnungsID) {
		this.wohnungsID = wohnungsID;
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
		return preis;
	}


	public void setPreis(int preis) {
		this.preis = preis;
	}
	
	// Methoden

    public String toString(){
        return "Groesse: " + this.groesse + " | Preis: " + this.preis + " | PAX: " + this.anzahl_pax +
		 " | Adresse: " + this.adresse + " | ID: " + this.wohnungsID;
    }
	
	// Methode buche Ferienwohnung
    //Test neu
		
	
}
