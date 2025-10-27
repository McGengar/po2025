package animals;

public class Parrot extends Animal {
    public Parrot() {
        this.legs = 2;
        this.name = "Parrot";
    }
    public String getDescription() {
        return "Liczba nóg papugi: " + legs;
    }
    public void makeSound() {
        System.out.println("Rrrrra!");
    }
}
