package zadania;
import animals.Animal;
import animals.Dog;
import animals.Parrot;
import animals.Snake;

import java.util.Random;

public class Zoo {
    Animal[] animals = new Animal[100];
    public Zoo() {
        Random rand = new Random();
        for(int i = 0; i < animals.length; i++) {
            int r  = rand.nextInt(3);
            switch(r) {
                case 0:
                    animals[i] = new Dog();
                    break;
                case 1:
                    animals[i]  = new Parrot();
                    break;
                default:
                    animals[i]  = new Snake();
                    break;
            }
        }
    }
    public int countLegs() {
        int sum = 0;
        for(Animal a : animals){
            sum += a.legs;
            String desc = a.getDescription();
            a.makeSound();
            System.out.println(desc);
        }
        return sum;
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        System.out.println(zoo.countLegs());
    }
}
