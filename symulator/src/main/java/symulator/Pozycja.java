package symulator;

public class Pozycja {
    double x;
    double y;

    public Pozycja(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Pozycja(){
        this.x = 0;
        this.y = 0;
    }

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void updatePozycja(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public String getPozycja(){
        return "X: " + this.x + " Y: " + this.y;
    }

}
