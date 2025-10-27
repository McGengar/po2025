package animals;

abstract public class Animal {
    public String name;
    public int legs;
    abstract public String getDescription();
    public int getLegs() {
        return legs;
    }
    public void makeSound(){}
}
