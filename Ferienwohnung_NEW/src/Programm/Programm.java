package Programm;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Benutzer.B_Anbieter;
import Benutzer.B_Direktkunde;
import Benutzer.Benutzer;
import Datenbank.DatenbankBenutzer;
import Ferienwohnung.Ferienwohnung;

public class Programm {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		boolean erfolgreichLogin = false;
		boolean pruefeLogin;
		boolean hauptprogrammGast;
		boolean hauptprogrammAnbieter;
		boolean auswahlFewo;

		ArrayList<String> Buchungs�bersicht = new ArrayList<>();

		System.out.println("Herzlich Wilkommen zu unserem Ferienwohnungstool f�r Ferienwohnungen im Spreewald");
		System.out.println("-----");
		
		// A) Programm
		while (erfolgreichLogin == false) {
			pruefeLogin = false;
			
			// B) Login - Bereich
			while (pruefeLogin == false) {
				pruefeLogin = LoginSeite.LoginPage(); // return true wenn LogIn
			}
			Benutzer myBenutzer = LoginSeite.benutzerLogin();
			System.out.println(myBenutzer.getIsGast());
			System.out.println(myBenutzer);

			
			// B) 1. Hauptmen� - Gast
			if (myBenutzer != null) {
				if (myBenutzer.getIsGast() == true) {
					B_Direktkunde myDirektkunde = (B_Direktkunde) myBenutzer;
					hauptprogrammGast = false;
					
					while (hauptprogrammGast == false) {

						System.out.println("HAUPTMEN�");
						System.out.println("-----");
						System.out.println("Bitte w�hlen Sie eine der folgenden Optionen:");
						System.out.println(
								"-1- �bersicht Ferienwohnungen\n-2- �bersicht Buchungen\n-3- Pers�nliche Daten\n-4- LogOut\n-5- Programm beenden");

						Scanner scan = new Scanner(System.in);
						int eingabeZahl = scan.nextInt();
						switch (eingabeZahl) {
						
						// C) 1. �bersicht Ferienwohnungen
						case 1: {
							auswahlFewo = false;
							while (auswahlFewo == false) {
								boolean optionen = false;
								Ferienwohnung wahlFerienwohnung = BuchungSeite.hauptmen�();
								optionen = false;

								while (optionen == false) {

									System.out.println("Bitte w�hlen Sie eine der folgenden Optionen:");
									System.out.println(
											"-1- Fotos Ferienwohnung\n-2- Buchungsanfrage versenden\n-3- zur�ck zum Hauptmen�");
									int eingabeZahlOptionen = scan.nextInt();

									switch (eingabeZahlOptionen) {
									
									// -1- Fotos Ferienwohnung
									case 1: {
										System.out.println("Fotos Ferienwohnung");
										System.out.println();
										break;

									}
									
									// -2- Buchungsanfrage versenden									
									case 2: {
										if (myDirektkunde.isVolljaehrig() == true) {
											String buchungsanfrageString = wahlFerienwohnung.anfrageFerienwohnung();
											Buchungs�bersicht.add(buchungsanfrageString);
											optionen = true;
											auswahlFewo = true;
											break;
										} else {
											System.out.println(
													"Um eine Buchungsanfrage zu stellen, m�ssen Sie vollj�hrig sein.");
											System.out.println();
											break;
										}

									}
									
									// -3- zur�ck zum Hauptmen�
									case 3: {
										System.out.println("zur�ck zum Hauptmen�");
										optionen = true;
										auswahlFewo = true;
										break;

									}
									default:
										throw new IllegalArgumentException("Unexpected value: " + eingabeZahl);
									}

								} // Ende while-Schleife Buchungsprogramm
							}
							break;

						}
						
						// C) 2. �bersicht Buchungen
						case 2: {
							if (Buchungs�bersicht.size() > 0) {
								System.out.println(
										"Sie haben insgesamt " + Buchungs�bersicht.size() + " Buchungen get�tigt");
								for (String string : Buchungs�bersicht) {
									System.out.println("- - - - - - - - - -");
									System.out.println(string);
								}

							} else {
								System.out.println("Es sind keine bestehenden Buchungen vorhanden.");

							}
							System.out.println();
							break;

						}
						
						// C) 3. Pers�nliche Daten
						case 3: {
							System.out.println("Bitte w�hlen Sie eine der folgenden Optionen:");
							System.out.println("-1- Zeige Pers�nliche Daten\n-2- �nderung Pers�nlicher Daten");
							int eingabeZahlOptionen = scan.nextInt();
							switch (eingabeZahlOptionen) {
							case 1: {
								myDirektkunde.zeigeDaten();
								break;
							}
							case 2: {
								myDirektkunde.�ndereDaten();
								break;
							}
							default: {
								break;
							}
							}
							System.out.println();

							break;

						}
						
						// C) 4. LogOut
						case 4: {
							System.out.println("Sie haben sich erfolgreich ausgeloggt");
							System.out.println();
							myBenutzer = myDirektkunde;
							hauptprogrammGast = true;
							break;

						}
						
						// C) 5. Programm ENDE
						case 5: {
							System.out.println(
									"Vielen Dank f�r die Nutzung des Ferienwohnungstools f�r Ferienwohnungen im Spreewald\n-----");
							System.out.println("ENDE");
							hauptprogrammGast = true;
							erfolgreichLogin = true;

							break;

						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + eingabeZahl);
						}
					}
				
				} else if (myBenutzer.getIsGast() == false) {
					B_Anbieter myAnbieter = (B_Anbieter) myBenutzer;
					
					hauptprogrammAnbieter = false;
					while (hauptprogrammAnbieter == false) {
					System.out.println();
					System.out.println("Hauptprogramm - Anbieter");
					System.out.println("*  *  *");
					System.out.println("Bitte w�hlen Sie eine der folgenden Optionen:");
					System.out.println("-1- Zeige Pers�nliche Daten\n-2- �nderung Pers�nlicher Daten\n-3- Zeige Ferienwohnungsdaten\n-4- �ndere Ferienwohnungsdaten\n-5- LogOut");
					Scanner scan = new Scanner(System.in);
					int eingabeZahlOptionen = scan.nextInt();
					switch (eingabeZahlOptionen) {
					case 1: {
						myAnbieter.zeigeDaten();
						break;
					}
					case 2: {
						myAnbieter.�ndereDaten();
						break;
					}
					case 3: {
						Ferienwohnung wahlFerienwohnung = BuchungSeite.hauptmen�();
						wahlFerienwohnung.zeigeDaten();
						break;
					}
					case 4: {
						Ferienwohnung wahlFerienwohnung = BuchungSeite.hauptmen�();
						wahlFerienwohnung.zeigeDaten();
						wahlFerienwohnung.�ndereDaten();
						break;
					}
					case 5: {
						System.out.println("Sie haben sich erfolgreich ausgeloggt");
						System.out.println();
						hauptprogrammAnbieter = true;
						break;
					}
					default: {
						break;
					}	
				}
					
				}
			} else {
				pruefeLogin = false;
			}
		}else {
		}
		}
		System.out.println("Ende");

	}
	}

