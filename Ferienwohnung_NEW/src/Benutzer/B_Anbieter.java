package Benutzer;

import java.util.Scanner;

import Ferienwohnung.Ferienwohnung;

public class B_Anbieter extends Benutzer {
    // Attribute


    // Konstruktor
    
	public B_Anbieter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public B_Anbieter(String benutzer, String passwort, String vorname, String nachname) {
		super(benutzer, passwort, vorname, nachname);
		// TODO Auto-generated constructor stub
	}
    
    // Methoden

    

    // Methode erstelle Ferienwohnung

    public Ferienwohnung erstelleFerienwohnung() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Eingabe der Größe in qm:");
        int groesse = scan.nextInt();

        System.out.println("Eingabe Adresse:");
        String adresse = scan.next();

        System.out.println("Eingabe Preis/Tag:");
        int preis = scan.nextInt();

        System.out.println("Eingabe Anzahl PAX:");
        int pax = scan.nextInt();

        int wohnungsID = Ferienwohnung.anzahl_Ferienwohnungen;
        Ferienwohnung.anzahl_Ferienwohnungen++;

        Ferienwohnung myF = new Ferienwohnung(groesse, preis, pax, wohnungsID, adresse);
        System.out.println("Die folgende Ferienwohnung wurde erstellt: " + myF.toString());

        return myF;
    }

	

	@Override
	public Benutzer erstelleBenutzer() {
		// TODO Auto-generated method stub
		return super.erstelleBenutzer();
	}
    
    // Methode LogIn Anbieter
    
    
}
