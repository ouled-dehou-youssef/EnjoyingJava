package org.youssefdehou;


import java.util.Scanner;




class Program {
    int number;
    boolean x = true;
    int i;
    int iterations;

    public Program(int number) {
        this.number = number;
    }

    public boolean isprime(int number){
        i = 2;
        while (i * i <= number) {
            iterations++;
            if (number % i == 0) {

                x = false;
                break;
            } else {
                x = true;

                i++;
            }
        }

        if(x)
            iterations++;
        return x;
    }

}

public class Main {
    public static void main(String[] args) {

        int number = 0;

        System.out.println("Entre a number");

        number = new Scanner(System.in)
                .nextInt();

        Program program = new Program(number);



        if ((number == 0) || (number == 1) || (number < 0)) {
            System.out.println("IllegalArgument");
            System.exit(-1);
        }

        if(program.isprime(number)){
            System.out.println("true   " + (program.iterations));
        }
        else{
            System.out.println("false   " + (program.iterations));
        }




    }

}

