import java.util.Scanner;

public class  Humans{
    Board board;
    Scanner scanner = new Scanner(System.in);

    private int health = 25;
    private String name;

    public Humans (){
    }
    public String getName(){
        return name;
    }
    public String setName(String x){
        return this.name = x;
    }

    public int getHealth(){
        return health;
    }
    public void setHealth(int x){
        this.health = x;
    }


    public Humans(int health){
        this.health = health;
        board = new Board();
    }


}
