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

		ArrayList<String> Buchungsübersicht = new ArrayList<>();

		System.out.println("Herzlich Wilkommen zu unserem Ferienwohnungstool für Ferienwohnungen im Spreewald");
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

			
			// B) 1. Hauptmenü - Gast
			if (myBenutzer != null) {
				if (myBenutzer.getIsGast() == true) {
					B_Direktkunde myDirektkunde = (B_Direktkunde) myBenutzer;
					hauptprogrammGast = false;
					
					while (hauptprogrammGast == false) {

						System.out.println("HAUPTMENÜ");
						System.out.println("-----");
						System.out.println("Bitte wählen Sie eine der folgenden Optionen:");
						System.out.println(
								"-1- Übersicht Ferienwohnungen\n-2- Übersicht Buchungen\n-3- Persönliche Daten\n-4- LogOut\n-5- Programm beenden");

						Scanner scan = new Scanner(System.in);
						int eingabeZahl = scan.nextInt();
						switch (eingabeZahl) {
						
						// C) 1. Übersicht Ferienwohnungen
						case 1: {
							auswahlFewo = false;
							while (auswahlFewo == false) {
								boolean optionen = false;
								Ferienwohnung wahlFerienwohnung = BuchungSeite.hauptmenü();
								optionen = false;

								while (optionen == false) {

									System.out.println("Bitte wählen Sie eine der folgenden Optionen:");
									System.out.println(
											"-1- Fotos Ferienwohnung\n-2- Buchungsanfrage versenden\n-3- zurück zum Hauptmenü");
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
											Buchungsübersicht.add(buchungsanfrageString);
											optionen = true;
											auswahlFewo = true;
											break;
										} else {
											System.out.println(
													"Um eine Buchungsanfrage zu stellen, müssen Sie volljährig sein.");
											System.out.println();
											break;
										}

									}
									
									// -3- zurück zum Hauptmenü
									case 3: {
										System.out.println("zurück zum Hauptmenü");
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
						
						// C) 2. Übersicht Buchungen
						case 2: {
							if (Buchungsübersicht.size() > 0) {
								System.out.println(
										"Sie haben insgesamt " + Buchungsübersicht.size() + " Buchungen getätigt");
								for (String string : Buchungsübersicht) {
									System.out.println("- - - - - - - - - -");
									System.out.println(string);
								}

							} else {
								System.out.println("Es sind keine bestehenden Buchungen vorhanden.");

							}
							System.out.println();
							break;

						}
						
						// C) 3. Persönliche Daten
						case 3: {
							System.out.println("Bitte wählen Sie eine der folgenden Optionen:");
							System.out.println("-1- Zeige Persönliche Daten\n-2- Änderung Persönlicher Daten");
							int eingabeZahlOptionen = scan.nextInt();
							switch (eingabeZahlOptionen) {
							case 1: {
								myDirektkunde.zeigeDaten();
								break;
							}
							case 2: {
								myDirektkunde.ändereDaten();
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
									"Vielen Dank für die Nutzung des Ferienwohnungstools für Ferienwohnungen im Spreewald\n-----");
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
					System.out.println("Bitte wählen Sie eine der folgenden Optionen:");
					System.out.println("-1- Zeige Persönliche Daten\n-2- Änderung Persönlicher Daten\n-3- Zeige Ferienwohnungsdaten\n-4- Ändere Ferienwohnungsdaten\n-5- LogOut");
					Scanner scan = new Scanner(System.in);
					int eingabeZahlOptionen = scan.nextInt();
					switch (eingabeZahlOptionen) {
					case 1: {
						myAnbieter.zeigeDaten();
						break;
					}
					case 2: {
						myAnbieter.ändereDaten();
						break;
					}
					case 3: {
						Ferienwohnung wahlFerienwohnung = BuchungSeite.hauptmenü();
						wahlFerienwohnung.zeigeDaten();
						break;
					}
					case 4: {
						Ferienwohnung wahlFerienwohnung = BuchungSeite.hauptmenü();
						wahlFerienwohnung.zeigeDaten();
						wahlFerienwohnung.ändereDaten();
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

