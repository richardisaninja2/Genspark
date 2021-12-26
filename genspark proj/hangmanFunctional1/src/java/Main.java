import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        chooseWord();

    }
    public static void chooseWord() throws IOException {
        String word = "";
        File file = new File("src/java/words.txt");
        //put file words into a list of Words
        List<String> list = new ArrayList<>(Files.readAllLines(Paths.get("src/java/words.txt"))).stream().map(Object::toString).collect(Collectors.toList());
        int max = list.size() - 1;
        int min = 0;
        word = list.get((int)(Math.random()*(max - min)) + min); //get a random word from the list above
        if(!word.isEmpty()){
            beginning(word);
        }else{
            System.out.println("file does not exist");
        }
    }
    public static int structure(int count){
        switch(count){
            case 1:
                System.out.println("+-----+ \n" +
                        "| \n" +
                        "| \n" +
                        "| \n" +
                        "=========");
                break;
            case 2:
                System.out.println("+-----+ \n" +
                        "| O\n" +
                        "| \n" +
                        "| \n" +
                        "=========");
                break;

            case 3:
                System.out.println("+-----+ \n" +
                        "| O\n" +
                        "| |\n" +
                        "| \n" +
                        "=========");
                break;
            case 4:
                System.out.println("+-----+ \n" +
                        "| O\n" +
                        "| |\n" +
                        "| |\n" +
                        "=========");
                break;
        }return count;

    }
    public static void beginning(String word) throws IOException {
        System.out.println("HANGMAN");
        System.out.println("+-----+ \n" +
                "| \n" +
                "| \n" +
                "| \n" +
                "=========");
        System.out.println("Missed letters: \n" +
                "Guess a letter");
        getInput(word);
    }

    public static void getInput(String word) throws IOException {

            Scanner getInput = new Scanner(System.in);
            String input = getInput.nextLine();
            guesses(input, word);
        return;
    }


    public static void guesses(String input, String word) throws IOException {
        Scanner scanner = new Scanner(System.in);
        //checks the input for the guesses and adds them to an array or not
        int count = 1;
        Boolean play = true;

        String[] arrOfWord = word.split("");
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> badGuesses = new ArrayList<>();
        ArrayList<String> spaceHolders = new ArrayList<>();
        Arrays.stream(arrOfWord).forEach(a -> list.add(a));
        list.stream().forEach(a -> spaceHolders.add("_"));

        while (play = true) {

            if (badGuesses.contains(input) || spaceHolders.contains(input)) {
                //if letter guessed was already guesed
                System.out.println("You have already guesses that letter, Choose again");
                structure(count);
                System.out.println("Missed letters " + badGuesses);
                System.out.println(spaceHolders);
                    input = scanner.nextLine(); //have to turn this to a character

            } else if (list.contains(input)) {
                //if the input is good
                spaceHolders.set(list.indexOf(input)/*put it at the index of the input*/, input); //put the input at the index it's at if there is one
                structure(count);
                System.out.println("Missed letters " + badGuesses);
                System.out.println(spaceHolders);
                if (spaceHolders.contains("_")){
                        input = scanner.nextLine(); //have to turn this to a character

                } else {
                    //if game has ended
                    System.out.println("Yes! the word is " + word + "! You have won!\nDo you want to play again (yes or no)");
                    try {
                        input = scanner.nextLine();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    if (input.equals("y") || input.equals("yes")) {
                        chooseWord();
                    }else{
                        System.exit(0);
                    }
                }
            } else {
                //area for bad guesses
                badGuesses.add(input);
                structure(count += 1);
                System.out.println("Missed letters " + badGuesses);
                System.out.println(spaceHolders);
                if (count < 4) {
                    input = scanner.nextLine(); //have to turn this to a character
                } else {
                    System.out.println("Would you like to play again (y for yes or anything else for no?)");
                    input = scanner.nextLine();
                    if (input.equals("y") || input.equals("yes")) {
                        chooseWord();
                    }else{
                        System.exit(0);
                    }
                }
            }
        }
    }

}
