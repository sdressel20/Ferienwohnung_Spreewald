package Ferienwohnung;

public class Wohnung_premium extends Ferienwohnung {

    // Attribute

    private boolean hp;
    private boolean vp;
    private boolean sauna;
    private boolean versicherung_premium;

    
    // Konstruktor

    public Wohnung_premium(int groesse, int preis, int anzahl_pax, int wohnungsID, String adresse,
        boolean hp, boolean vp, boolean sauna, boolean versicherung_premium) {
        super(groesse, preis, anzahl_pax, wohnungsID, adresse);
        this.hp = hp;
        this.vp = vp;
        this.sauna = sauna;
        this.versicherung_premium = versicherung_premium;
    }


    // Methoden

    public boolean isVersicherung_premium() {
        return versicherung_premium;
    }

    public void setVersicherung_premium(boolean versicherung_premium) {
        this.versicherung_premium = versicherung_premium;
    }

    public boolean isSauna() {
        return sauna;
    }

    public void setSauna(boolean sauna) {
        this.sauna = sauna;
    }

    public boolean isHp() {
        return hp;
    }

    public void setHp(boolean hp) {
        this.hp = hp;
    }

    public boolean isVp() {
        return vp;
    }

    public void setVp(boolean vp) {
        this.vp = vp;
    }
    
}
