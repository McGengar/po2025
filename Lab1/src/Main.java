public class Main {


    public static void main(String[] args) {


        System.out.println("Hello, World!");


        int size = 5;


        if(args.length != 0){


            size = Integer.parseInt(args[0]);


        }





        for(int i=0;i<=size;i++) {


            for(int j=0;j<=i;j++) {


                System.out.print("*");


            }


            System.out.println();


        }


    }


}