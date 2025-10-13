package Lab1;

import java.util.ArrayList;
import java.util.Random;

public class Lotto {
    public static void main(String[] args) {
        ArrayList<Integer> inputs =  new ArrayList<Integer>();
        ArrayList<Integer> numbers =  new ArrayList<Integer>();
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            inputs.add(Integer.parseInt(args[i]));
        }
        while (numbers.size()<6) {
            int input = rand.nextInt(49)+1;
            if (!numbers.contains(input)){
                numbers.add(input);
            }
        }
        System.out.print("Wygrywające liczby w Lotto to: ");
        for (int i = 0; i < 6; i++) {
            System.out.print(numbers.get(i));
            System.out.print(" ");
        }
        System.out.println();
        System.out.print("Twoje liczby to: ");
        for (int i = 0; i < 6; i++) {
            System.out.print(inputs.get(i));
            System.out.print(" ");
        }

        int matches = 0;
        for (int i = 0; i < 6; i++) {
                if (inputs.contains(numbers.get(i))) {
                    matches++;
                }
        }
        System.out.println();
        System.out.print("Liczba trafionych liczb: ");
        System.out.println(matches);

    }
}
