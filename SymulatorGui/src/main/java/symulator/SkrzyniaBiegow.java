package symulator;

public class SkrzyniaBiegow extends Komponent{
    int aktualnyBieg;
    int iloscBiegow;
    Sprzeglo sprzeglo;

    public int getAktualnyBieg() {
        return aktualnyBieg;
    }

    public int getIloscBiegow() {
        return iloscBiegow;
    }

    public Sprzeglo getSprzeglo() {
        return sprzeglo;
    }

    public SkrzyniaBiegow(Sprzeglo sprzeglo, int aktualnyBieg, int iloscBiegow, int cena, int waga, String nazwa, String producent, String model) {
        this.aktualnyBieg = aktualnyBieg;
        this.iloscBiegow = iloscBiegow;
        this.cena = cena;
        this.waga = waga;
        this.nazwa = nazwa;
        this.producent = producent;
        this.model = model;
        this.sprzeglo = sprzeglo;
    }

    public SkrzyniaBiegow(){
        this.sprzeglo = new Sprzeglo();
        this.aktualnyBieg=0;
        this.iloscBiegow=6;
        this.cena = 0.0;
        this.waga = 0.0;
        this.nazwa = "";
        this.producent = "";
        this.model = "";
    }

    public void zwiekszBieg(){
        if(this.aktualnyBieg<this.iloscBiegow && this.sprzeglo.stanSprzegla){
            this.aktualnyBieg+=1;
        }
    }
    public void zmniejszBieg(){
        if(this.aktualnyBieg>0 && this.sprzeglo.stanSprzegla) {
            this.aktualnyBieg-=1;
        }
    }
    @Override
    public String toString() {
        return this.nazwa;
    }
}
