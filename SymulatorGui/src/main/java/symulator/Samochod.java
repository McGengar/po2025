package symulator;

import org.example.symulatorgui.HelloApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Samochod extends Thread {
    Pozycja pozycja;
    Silnik silnik;
    SkrzyniaBiegow skrzynia;
    boolean stanWlaczenia;
    int nrRejest;
    String model;
    int predkoscMax;
    int predkosc;
    Pozycja cel;
    private double kat = 0;

    public double getKat() {
        return kat;
    }

    public int getWaga() {
        return waga;
    }

    int waga;

    public Pozycja getPozycja() {
        return pozycja;
    }

    public Silnik getSilnik() {
        return silnik;
    }

    public SkrzyniaBiegow getSkrzynia() {
        return skrzynia;
    }

    public boolean isStanWlaczenia() {
        return stanWlaczenia;
    }

    public int getNrRejest() {
        return nrRejest;
    }

    public String getModel() {
        return model;
    }

    public int getPredkoscMax() {
        return predkoscMax;
    }

    public Samochod(Pozycja pozycja, Silnik silnik, SkrzyniaBiegow skrzynia, boolean stanWlaczenia, int nrRejest, String model, int predkoscMax) {
        this.pozycja = pozycja;
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.stanWlaczenia = stanWlaczenia;
        this.nrRejest = nrRejest;
        this.model = model;
        this.predkoscMax = predkoscMax;
        this.predkosc = 0;
        this.cel = new Pozycja();
        this.start();
    }

    public Samochod() {
        this.pozycja = new Pozycja();
        this.silnik = new Silnik();
        this.skrzynia = new SkrzyniaBiegow();
        this.stanWlaczenia = false;
        this.nrRejest = 0;
        this.model = "";
        this.predkoscMax = 0;
        this.predkosc = 0;
        this.cel = new Pozycja();
        this.start();
    }

    public void jedzDo(Pozycja nowaPozycja) {
        this.cel=nowaPozycja;
    }

    public void wlacz() {
        this.silnik.uruchom();
        stanWlaczenia=true;
    }

    public void wylacz() {
        this.silnik.zatrzymaj();
        this.skrzynia.aktualnyBieg = 0;
        stanWlaczenia=false;
    }


    public int getPredkosc() {
        this.predkosc=this.getSilnik().getObroty()/10* this.getSkrzynia().getAktualnyBieg();
        return this.predkosc;
    }

    public void setPredkosc(int predkosc) {
        this.predkosc = predkosc;
    }
    @Override
    public void run() {
        long frameTime = 20;
        double deltat = frameTime / 1000.0;

        while (!isInterrupted()) {
            try {
                if (cel != null) {
                    double dx_total = cel.x - pozycja.x;
                    double dy_total = cel.y - pozycja.y;
                    double odleglosc = Math.sqrt(dx_total * dx_total + dy_total * dy_total);

                    if (odleglosc > 1.0) {
                        double dx = getPredkosc() * deltat * dx_total / odleglosc;
                        double dy = getPredkosc() * deltat * dy_total / odleglosc;
                        this.kat = Math.toDegrees(Math.atan2(dy, dx));

                        if (Math.abs(dx) > odleglosc) dx = dx_total;
                        if (Math.abs(dy) > odleglosc) dy = dy_total;

                        pozycja.x += dx;
                        pozycja.y += dy;

                        notifyListeners();
                    }
                }
                Thread.sleep(frameTime);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
    public static final Logger LOGGER = Logger.getLogger(Samochod.class.getName());
    private List<Listener> listeners = new ArrayList<>();
    public void addListener(Listener listener) {
        listeners.add(listener);
    }
    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }
    private void notifyListeners() {
        for (Listener listener : listeners) {
            listener.update();
        }
    }

}