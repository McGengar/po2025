package animals;

public class Snake extends Animal {
    public Snake() {
        this.legs = 0;
        this.name = "Snake";
    }
    public String getDescription() {
        return "Liczba nóg węża: " + legs;
    }
    public void makeSound() {
        System.out.println("Sssss!");
    }
}
