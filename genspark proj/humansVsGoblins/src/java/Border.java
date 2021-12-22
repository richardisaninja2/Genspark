public class Border extends PlaceHolder{

    String st="26CC";
    int cp=Integer.parseInt(st,16);// it convert st into hex number.
    String name = setName(new String(Character.toChars(cp)));


}
