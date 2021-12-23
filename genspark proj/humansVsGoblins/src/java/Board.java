import java.util.Arrays;
import java.util.Scanner;
import java.lang.reflect.Array;

public class Board {
   //Chad chad; String hName = chad.getName();
   Chad chad = new Chad(); String hName = chad.getName();
   Monsters monster1 = new Monsters(); String m1 = monster1.getName();

    PlaceHolder place = new PlaceHolder(); String holder = place.getName();
    Border border = new Border(); String margin = border.getName();

    private String[][] land = {{holder ,m1, hName, margin}, //3X3 array
                                {m1 ,m1, holder, margin},
                                {holder, holder, m1, margin},
                                 {holder, m1, holder, margin},
                                 {margin, margin, margin, margin}};

    public String[][] getLand(){
        return land;
    }
    public boolean play;
    public int[] getChadLoc(){
        int[] loc = new int[2];
        for(int i = 0; i<land.length - 1; i++){
            for(int j = 0; j<land[i].length; j++){
                String item = land[i][j];
                if(item.equals(chad.getName())){
                  loc[0] = i;
                    loc[1] = j;
                }
            }
        }return loc;
    }
    public void combat(){
        int max = 12;
        int min = 1;
        monster1.setStrength((int)(Math.random()*(max - min)) + min); //randomly set health
       int aHealth = chad.getHealth() - monster1.getStrength();
       chad.setHealth(aHealth);

        if(chad.getHealth() <= 0){
            System.out.println("The monster hits you for " + monster1.getStrength()+ " damage, your health is less than 0; you have died...");
    //if the monster kills the human
            //ends game
           System.exit(0);
        }else{
            System.out.println("The monster hits you for " +monster1.strength+ " damage, \n\tyour health is now " +chad.getHealth());

        }return ;
    }

    public Boolean getMonster(){
        boolean play = false;
        for(int i = 0; i<land.length - 1; i++){
            for(int j = 0; j<land[i].length; j++){
                String item = land[i][j];
                if(item.equals(monster1.getName())){
                    return true;
                }
            }
        }return play;
    }

    public void setChadLoc(String input){
       int[] loc = getChadLoc();
       int x = loc[0]; int y = loc[1];
        String space = place.getName();

        if(input.equals("a") && y > 0){ //hello hello hi
                if(land[x][y-1] == monster1.getName()){
                    combat();
                }
            land[x][y-1] = land[x][y]; // hello hi hi
            land[x][y] = space; // hello hi hello
            showBoard();
        }
        if(input.equals("d") && y < 2){
            if(land[x][y+1] == monster1.getName()){
                combat();
            }
            land[x][y+1] = land[x][y];
            land[x][y] = space;
            showBoard();
        }
        if(input.equals("w") && x > 0){
            if(land[x-1][y] == monster1.getName()){
                combat();
            }
            land[x-1][y] = land[x][y];
            land[x][y] = space;
            showBoard();
        }
        if(input.equals("s") && x < 3){
            if(land[x+1][y] == monster1.getName()){
                combat();
            }
            land[x+1][y] = land[x][y];
            land[x][y] = space;
            showBoard();
        }
        else{
            System.out.println("Your move is out of bounds... Choose again");
            showBoard();
        }

    }

    public  String showLand(){
        return Arrays.deepToString(land)
                .replace("],","\n").replace(",","\t| ")
                .replaceAll("[\\[\\]]", " ");
    }

    public Board(){
    }
    public Board(Humans humans, Monsters monsters, PlaceHolder place) {
    }


    public void showBoard(){
        if(getMonster() == false){
            System.out.println("Congratulations you finished the game");
            System.exit(0);
        }else{
            try {
            System.out.println(showLand());
            System.out.println("Choose a direction using w,s,a,d \n (w) for up, (s) for down (a) for left\n \t\t (d) for right");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            setChadLoc(input);
        }catch(Exception e){
                System.out.println(e);
            }
        }
    }


}
