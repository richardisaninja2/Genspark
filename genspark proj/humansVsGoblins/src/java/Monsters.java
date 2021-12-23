public class Monsters {
    int strength = (int)(Math.random() * 8);
    String st="26C4";
    int cp=Integer.parseInt(st,16);// it convert st into hex number.
    String name = new String(Character.toChars(cp));

    public String getName(){
        return this.name;
    }

    public Monsters (){}

    public Monsters(int strength){
        this.strength = strength;
    }

    public int getStrength(){
        return strength;
    }

    public void setStrength(int x){
        this.strength = x;
    }

    @Override
    public String toString(){
        return "Monsters{"+"strength="+strength+"name="+name+"}";
    }
}
