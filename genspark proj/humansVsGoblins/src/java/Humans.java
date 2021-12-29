import java.util.Scanner;

public class  Humans{


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



    @Override
    public String toString(){
        return "Human={"+"health= "+health+ "name="+name+"}";
    }


}
