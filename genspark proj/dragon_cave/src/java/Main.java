import java.util.Scanner;

public class Main {

    public static String userInput(int x){

        String answer = "";
        answer = x == 1 ? " You approach the cave...\n Its dark and spooky... \n A large dragon jumps out in front of you! He opens his jaws and...\n Gobbles you down in one bite!\n" : "Congratulations you won!";

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args){

        System.out.println(" Your are in a land full of Dragons. In front of you,\n you see two caves. In one cave, the dragon is friendly\n and will share his treasure with you The other dragon\n is greedy and hungry and will wat you on sight.\n Which cave will you go into? (1 or 2)");
        try{
            Scanner getInput = new Scanner(System.in);
            int input = getInput.nextInt();
            Main.userInput(input);

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return;
    }




}
