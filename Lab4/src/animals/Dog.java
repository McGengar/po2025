package animals;

public class Dog extends Animal {
    public Dog() {
        this.legs = 4;
        this.name = "Dog";
    }
    public String getDescription() {
        return "Liczba nóg psa: " + legs;
    }
    public void makeSound() {
        System.out.println("Hau Hau!");
    }
}
