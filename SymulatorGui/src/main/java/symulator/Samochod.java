package symulator;

public class Samochod{
    Pozycja pozycja;
    Silnik silnik;
    SkrzyniaBiegow skrzynia;
    boolean stanWlaczenia;
    int nrRejest;
    String model;
    int predkoscMax;

    public Samochod(Pozycja pozycja, Silnik silnik, SkrzyniaBiegow skrzynia, boolean stanWlaczenia, int nrRejest, String model, int predkoscMax) {
        this.pozycja = pozycja;
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.stanWlaczenia = stanWlaczenia;
        this.nrRejest = nrRejest;
        this.model = model;
        this.predkoscMax = predkoscMax;
    }
    public Samochod() {
        this.pozycja = new Pozycja();
        this.silnik = new Silnik();
        this.skrzynia = new SkrzyniaBiegow();
        this.stanWlaczenia = false;
        this.nrRejest = 0;
        this.model = "";
        this.predkoscMax = 67;
    }

    void wlacz(){
        this.silnik.uruchom();
    }
    void wylacz(){
        this.silnik.zatrzymaj();
        this.skrzynia.aktualnyBieg=0;
    }
}
