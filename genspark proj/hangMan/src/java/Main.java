import java.util.*;

public class Main {
    public static void main(String[] args) {
        difficulty();

    }
    public static void difficulty(){
        System.out.println("Hi, choose your difficulty!(easy, med, or hard)");
        Scanner scanner = new Scanner(System.in);
        try{
                String input = scanner.nextLine();

                String word = "";
                HashMap <String, String> map = new HashMap<>();
                map.put("easy", "bye");
                map.put("med", "hello");
                map.put("hard", "impossible");

                if(map.containsKey(input)){
                    word = map.get(input);
                    beginning(word);
                }

                else{
                    difficulty();
                }
         }catch(Exception e){
            System.out.println("invalid input");
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
    public static void beginning(String word){
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

    public static void getInput(String word){
        try{

            Scanner getInput = new Scanner(System.in);
            String input = getInput.nextLine();
            guesses(input, word);
        }catch(Exception e){
            System.out.println(e);
        }
    }


    public static void guesses(String input, String word) {
        Scanner scanner = new Scanner(System.in);
        //checks the input for the guesses and adds them to an array or not
        int count = 1;
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> badGuesses = new ArrayList<>();
        ArrayList<String> spaceHolders = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            list.add(String.valueOf(word.charAt(i))); //puts word letters into char list
        }
        for (var e : list) {
            spaceHolders.add("_"); //make space holder have values of _ _ _ for every character in the list
        }
            do {
                if (badGuesses.contains(input) || spaceHolders.contains(input)) {
                    //if letter guessed was already guesed
                    System.out.println("You have already guesses that letter, Choose again");
                    structure(count);
                    System.out.println("Missed letters " + badGuesses);
                    System.out.println(spaceHolders);
                    try {
                        input = scanner.nextLine(); //have to turn this to a character
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                } else if (list.contains(input)) {
                    spaceHolders.set(list.indexOf(input)/*put it at the index of the input*/, input); //put the input at the index it's at if there is one
                    structure(count);
                    System.out.println("Missed letters " + badGuesses);
                    System.out.println(spaceHolders);
                    if (spaceHolders.contains("_")) {
                        try {
                            input = scanner.nextLine(); //have to turn this to a character
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else {
                        System.out.println("Yes! the word is " + word + "! You have won!\nDo you want to play again (yes or no)");
                        try {
                            input = scanner.nextLine(); //have to turn this to a character
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        if (input.equals("y")) {
                            beginning(word);
                        }
                    }
                } else {
                    //area for bad guesses
                    badGuesses.add(input);
                    structure(count += 1);
                    System.out.println("Missed letters " + badGuesses);
                    System.out.println(spaceHolders);
                    System.out.println(count);
                    if (count < 4) {
                        input = scanner.nextLine(); //have to turn this to a character
                    } else {
                        System.out.println("Would you like to play again (y for yes or anything else for no?)");
                        input = scanner.nextLine();
                        if (input.equals("y")) {
                            beginning(word);
                        }
                    }
                }
            }
            while (spaceHolders.contains("_") && count < word.length() + 1);
    }

}
