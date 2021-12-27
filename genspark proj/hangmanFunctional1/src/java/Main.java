import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    private static int score = 0;
    public static int getScore(){
        return score;
    }
    public static void main(String[] args) throws IOException {
        chooseWord();

    }
    public static void chooseWord() throws IOException {
        System.out.println("Your score is "+getScore());
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
                    System.out.println("You made it to the next round.. Press enter to move on.. or any other key to exit");
                        input = scanner.nextLine();
                    if (input.isEmpty()) {//the enter key had been pressed
                        score+=1;
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
                    checkHighScore();
                    if(checkHighScore() > score){
                        System.out.println("ooooh nice, your score is "+score+", enter a name over 2 characters to save your score");
                    }else{
                        System.out.println("CONGRATULATIONS!!! YOU HAVE THE NEW HIGHEST SCORE.. enter a name to save your score");
                    }
                    input = scanner.nextLine();
                    if(!input.isEmpty()){
                        storeScore(input);
                        playAgain();
                    }else{
                        System.out.println("your name wasn't the correct length.. your score won't be saved\n");
                        playAgain();
                    }
                }
            }
        }
    }
    public static int checkHighScore() throws IOException {
        //List to read high scores
        //ask one of the instructors how I could have checked for a high score in a shorter manner.
        List<String>scoresList = new ArrayList<>(Files.readAllLines(Paths.get("src/java/scores.txt")));//get content of files
        String joinedList = String.join(",", scoresList); //join the list and make it a string
        String[] scoresArr = joinedList.split(","); //split the string and make it an array
        List<String> onlyScores = IntStream.range(0, scoresArr.length).filter(i -> i % 2 == 1).mapToObj(i -> scoresArr[i]).collect(Collectors.toList()); //get the odd indexes of the array which should be only the scores
        List<Integer> intList = onlyScores.stream().map(Integer::valueOf).collect(Collectors.toList()); //convert the scores from a string to an integer
        Integer maxScore = intList.stream().max(Comparator.comparing(Integer::valueOf)).get(); //compare the scores to find the max score
        System.out.println(maxScore);
        return maxScore;
    }
    public static void playAgain() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like to play again ((y) for yes or anything else for no?)");
        String input = scanner.nextLine();
        if (input.equals("y") || input.equals("yes")) {
            score = 0;
            chooseWord();
        }else{
            System.exit(0);
        }
    }
    public static void storeScore(String input) throws IOException {
        String storingScore = input+","+ score;
        Files.write(Paths.get("src/java/scores.txt"), Collections.singleton(storingScore),StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}
