package Ferienwohnung;

public class Wohnung_classic extends Ferienwohnung {

    // Attribute

    private boolean versicherung_classic;

    // Konstruktor
    
    public Wohnung_classic(int groesse, int preis, int anzahl_pax, boolean versicherung_classic) {
        super(groesse, preis, anzahl_pax, anzahl_pax, getAdresse());
        this.versicherung_classic = versicherung_classic;
    }


    // Methoden

    public boolean isVersicherung_classic() {
        return versicherung_classic;
    }


    public void setVersicherung_classic(boolean versicherung_classic) {
        this.versicherung_classic = versicherung_classic;
    }
    
}
