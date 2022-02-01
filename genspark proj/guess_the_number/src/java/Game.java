import java.util.Random;
import java.util.Scanner;

public class Game {
    public static String userInput(int inputNumInt, String input){


        try {
            Scanner getInputNum = new Scanner(System.in);
            Boolean play = true;
            Random random = new Random();
            int randomNumber = random.nextInt(20);
            int counter = 1;

            do {
                if (inputNumInt > randomNumber) {
                    System.out.println("Your Guess is too high");
                    System.out.println("Take a guess");
                    //System.out.println(randomNumber);
                    inputNumInt = getInputNum.nextInt();
                    counter++;
                } else if (inputNumInt < randomNumber) {
                    System.out.println("Your Guess is too low");
                    System.out.println("Take a guess");
                    //System.out.println(randomNumber);
                    inputNumInt = getInputNum.nextInt();
                    counter++;
                }
                if (inputNumInt == randomNumber) {
                    System.out.println("Good job, " + input + " You guessed my number in " + counter + " guesses.");
                    System.out.println("Would you like to play again? (1 for Yes or Any other number for No)");
                    play = false;
                    Scanner getFinalInputNum = new Scanner(System.in);

                    int finalInput = getFinalInputNum.nextInt();
                    newGame(finalInput);

                }
            } while (play == true);
        }catch(Exception e){
            return "You gave an invalid input";
        }
        return "Good Job";
    }

    public static String newGame(int finalInput) {


        if (finalInput == 1) {
            game();
        } else {
            System.out.println("good game");
        } return "congrats you won";

    }
    public static void game() {


        Boolean play = true;
        try {
            System.out.println("Hello! What is your name?");
            Scanner getInput = new Scanner(System.in);
            String input = getInput.nextLine();


            System.out.println("Well " + input + ", I am thinking of a number between 1 and 20.");
            System.out.println("Take a guess.");


            Scanner getInputNum = new Scanner(System.in);
            int inputNum = getInputNum.nextInt(); //user input
            int inputNumInt = inputNum;
            userInput(inputNumInt, input);
        }catch(Exception e){
            System.out.println("You gave an invalid input");
        }

    }
}
