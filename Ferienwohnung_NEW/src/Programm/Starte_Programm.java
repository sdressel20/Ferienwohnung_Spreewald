package Programm;

import Benutzer.B_Anbieter;
import Benutzer.B_Direktkunde;

public class Starte_Programm {
	public static void main(String[]args) {//main methode
		B_Direktkunde firstDirektkunde = new B_Direktkunde("Nico", "", "123", 13583, "Berlinstr", "Berlin", 18);
		System.out.println(firstDirektkunde.volljaehrig());
		System.out.println(firstDirektkunde.bestätigeBuchung());

		B_Anbieter Max = new B_Anbieter("Max", "Müller", "123abc");
		Max.erstelleFerienwohnung();

		
		
	}//ende main
}//ende der klasse
