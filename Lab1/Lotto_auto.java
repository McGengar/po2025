import java.util.ArrayList;
import java.util.Random;

public class Lotto_auto {
    public static void main(String[] args) {
        ArrayList<Integer> inputs =  new ArrayList<Integer>();
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            inputs.add(Integer.parseInt(args[i]));
        }
        int matches =0;
        int n = 0;
        long start_time = System.currentTimeMillis();
        do{
            n++;
            ArrayList<Integer> numbers =  new ArrayList<Integer>();
            while (numbers.size() < 6) {
                int input = rand.nextInt(49) + 1;
                if (!numbers.contains(input)) {
                    numbers.add(input);
                }
            }


            matches = 0;
            for (int i = 0; i < 6; i++) {
                if (inputs.contains(numbers.get(i))) {
                    matches++;
                }
            }
            //System.out.println();
            //System.out.print("Liczba trafionych liczb: ");
            //System.out.println(matches);
        }while (matches !=6);
        System.out.println();
        System.out.print("Twoje i zwycięskie liczby to: ");
        System.out.print(inputs);
        System.out.println("Czas potrzebny na wygranie bruteforcem: ");
        System.out.println(System.currentTimeMillis() - start_time);
        System.out.println("Liczba interacji: ");
        System.out.println(n);
    }
}
