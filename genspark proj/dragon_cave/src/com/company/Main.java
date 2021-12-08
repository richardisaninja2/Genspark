package com.company;
import java.util.Scanner; //import Scanner

public class Main {
    public static void main(String[] args) {

        System.out.println(" Your are in a land full of Dragons. In front of you,\n you see two caves. In one cave, the dragon is friendly\n and will share his treasure with you The other dragon\n is greedy and hungry and will wat you on sight.\n Which cave will you go into? (1 or 2)");

      Scanner getInput = new Scanner(System.in);
      String input = getInput.nextLine();

        if (input.equals("1")) {
            System.out.println(" You approach the cave...\n Its dark and spooky... \n A large dragon jumps out in front of you! He opens his jaws and...\n Gobbles you down in one bite!\n");
        }else{
            System.out.println("Congratulations you won!");
        }
    }
}
