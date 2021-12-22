public class PlaceHolder {
        String st="26C9";
        int cp=Integer.parseInt(st,16);// it convert st into hex number.

        String name = new String(Character.toChars(cp));

        public String getName(){
                return this.name;
        }
        public String setName(String x){
              return  this.name = x;
        }
}
