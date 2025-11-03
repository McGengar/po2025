package symulator;

public class Silnik extends Komponent{
    int maxObroty;
    int obroty;

    public Silnik(int maxObroty, int obroty, int cena, int waga, String nazwa, String producent, String model){
        this.maxObroty=maxObroty;
        this.obroty=obroty;
        this.cena=cena;
        this.waga=waga;
        this.nazwa=nazwa;
        this.model=model;
        this.producent=producent;

    }
    public Silnik(){
        this.maxObroty=6700;
        this.obroty=0;
        this.cena = 0.0;
        this.waga = 0.0;
        this.nazwa = "";
        this.producent = "";
        this.model = "";
    }

    void uruchom(){
        this.obroty=0;
    }
    void zatrzymaj(){
        this.obroty=0;
    }
    void zwiekszObroty(){
        if(this.obroty<this.maxObroty) {
            this.obroty += 1;
        }
    }
    void zmniejszObroty(){
        if(this.obroty>0) {
            this.obroty -= 1;
        }
    }
}
