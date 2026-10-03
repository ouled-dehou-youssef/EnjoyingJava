package org.youssefdehou;


import java.util.*;


class CoffeeRequest{

    private int number;
    private Set<Integer> numbersPremier = new HashSet<>();

    public void setNumbersPremier(Set<Integer> numbersPremier) {
        this.numbersPremier = numbersPremier;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    int sumElementNumber = 0;

    public Set<Integer> getNumbersPremier() {
        return numbersPremier;
    }

    public void coffeeRequestmethod(int number){



        if(number<=0)
            System.exit(0);


        String s = Integer.toString(number);

        int[] elementsNumber = new int[s.length()];

        for(int i = 0; i < s.length(); i++) {
            elementsNumber[i] = Character.getNumericValue(s.charAt(i));
            sumElementNumber += elementsNumber[i];
        }

        int j = 2;
        boolean flag = true;

        while(j*j<sumElementNumber){

            if(sumElementNumber%j == 0)
                break;

            else{
                numbersPremier.add(sumElementNumber);
                j++;
            }



        }

    }
}


public class Main {
    public static void main(String[] args) {

        int sumElementNumber = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.print("-> ");
        Set<Integer> numbersPremier = new HashSet<>();

        CoffeeRequest coffeeRequest = new CoffeeRequest();
        coffeeRequest.setNumber(scanner.nextInt());
        int number = coffeeRequest.getNumber();



        while (number != 42) {
/* --------------------------------------------------------------------- */

        coffeeRequest.coffeeRequestmethod(number);


        coffeeRequest.sumElementNumber = 0;
//
        System.out.print("-> ");

        coffeeRequest.setNumber(scanner.nextInt());
        number = coffeeRequest.getNumber();

        }

        System.out.println("Count of coffee-request : " + coffeeRequest.getNumbersPremier().size());






    }
}