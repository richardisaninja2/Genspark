import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        game();
    }

    public static void game() {

        Boolean play = true;
        System.out.println("Hello! What is your name?");
        Scanner getInput = new Scanner(System.in);
        String input = getInput.nextLine();


        System.out.println("Well " +input+ ", I am thinking of a number between 1 and 20.");
        System.out.println("Take a guess.");

        Scanner getInputNum = new Scanner(System.in);
        int inputNum = getInputNum.nextInt(); //user input
        int inputNumInt = inputNum;


        Random random = new Random();
        int randomNumber = random.nextInt(20);
        int counter = 0;

       do{
           if(inputNumInt > randomNumber){
               System.out.println("Your Guess is too high");
               System.out.println("Take a guess");
               System.out.println(randomNumber);
               inputNumInt = getInputNum.nextInt();
               counter++;
           }
           else if( inputNumInt < randomNumber){
               System.out.println("Your Guess is too low");
               System.out.println("Take a guess");
               System.out.println(randomNumber);
               inputNumInt = getInputNum.nextInt();
               counter++;
           }
           if(inputNumInt == randomNumber){
               System.out.println("Good job, " +input + " You guessed my number in " + counter + " guesses.");
               System.out.println("Would you like to play again? (y or n)");

               Scanner getFinalInput = new Scanner(System.in);
                String finalInput = getFinalInput.nextLine();
                if(finalInput.equals("y")){
                    game();
                }else{
                    play = false;
                }

           }
       }while(play == true);

    }

}
