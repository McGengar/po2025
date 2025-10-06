import java.util.Random;
import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter six numbers between 1 and 49");
        int[] inputs = new int[6];
        int[] numbers = new int[6];
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            inputs[i] = input.nextInt();
            numbers[i] = rand.nextInt(49)+1;
        }
        System.out.print("Wygrywające liczby w Lotto to: ");
        for (int i = 0; i < 6; i++) {
            System.out.print(numbers[i]);
            System.out.print(" ");
        }
        int matches = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (inputs[i] == numbers[j]) {
                    matches++;
                }
            }
        }
        System.out.println();
        System.out.print("Liczba trafionych liczb: ");
        System.out.println(matches);

    }
}
