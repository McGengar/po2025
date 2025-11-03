package symulator;

public class Sprzeglo extends Komponent{
    boolean stanSprzegla;

    public Sprzeglo() {
        this.stanSprzegla = false;
        this.cena = 0.0;
        this.waga = 0.0;
        this.nazwa = "";
        this.producent = "";
        this.model = "";
    }
    public Sprzeglo(int cena, int waga, String nazwa, String producent, String model) {
        this.cena = cena;
        this.waga = waga;
        this.nazwa = nazwa;
        this.producent = producent;
        this.stanSprzegla = false;
        this.model = model;
    }


    void wcisnij(){
        stanSprzegla=true;
    }
    void zwolnij(){
        stanSprzegla=false;
    }
}
