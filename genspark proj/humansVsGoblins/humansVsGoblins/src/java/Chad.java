public class Chad extends Humans{
    String st="26F9";
    int cp=Integer.parseInt(st,16);// it convert st into hex number.
    String name = setName(new String(Character.toChars(cp)));
    //String name = setName("  Chad ");
}
