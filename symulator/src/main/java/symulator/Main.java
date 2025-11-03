package symulator;

public class Main {
    public static void main(String[] args) {
        Silnik silnik = new Silnik(6700,0,6700,670,"ssb silnik","SSB","SuperSzybki67");
        Sprzeglo sprzeglo = new Sprzeglo(5000,300,"Uuusprzeglo","UuuEntprice","Sigma");
        SkrzyniaBiegow skrzyniaBiegow = new SkrzyniaBiegow(sprzeglo,0,6,2500,40,"SkrzyniaAlfa","Wilki","Auu");
        Pozycja pozycja= new Pozycja(21,37);

        Samochod honda_szybsza_niz_wygloada = new Samochod(pozycja,silnik,skrzyniaBiegow,true,213767,"Civic",167);
    }
}
