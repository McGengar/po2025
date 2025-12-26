package symulator;

public class Silnik extends Komponent{
    int maxObroty;
    int obroty;
    public boolean wlaczony = false;
    public int getMaxObroty() {
        return maxObroty;
    }

    public int getObroty() {
        return obroty;
    }

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
        this.maxObroty=6000;
        this.obroty=0;
        this.cena = 0.0;
        this.waga = 0.0;
        this.nazwa = "";
        this.producent = "";
        this.model = "";
    }

    public void uruchom(){
        this.obroty=0;
        this.wlaczony=true;
    }
    public void zatrzymaj(){
        this.obroty=0;
        this.wlaczony=false;
    }
    public void zwiekszObroty(){
        if(this.obroty<this.maxObroty && this.wlaczony) {
            this.obroty += 100;
        }
    }
    public void zmniejszObroty(){
        if(this.obroty>0 && this.wlaczony) {
            this.obroty -= 100;
        }
    }
    @Override
    public String toString() {
        return this.nazwa;
    }
}
