package soundex;

public class Soundex {
    static int[] peso = new int[]{0,1,2,3,0,1,2,0,0,2,2,4,5,5,0,1,2,6,2,3,0,1,0,2,0,2};
    public static void main(String[] args) {
        //System.out.println(soundex("threshold"));
        //System.out.println(soundex("hold"));
        System.out.println(soundex("zresjoulding"));
        System.out.println(soundex("phone"));
        System.out.println(soundex("foun"));

        System.out.println(soundex("threshold","hold"));
        System.out.println(soundex("threshold","zresjoulding"));
        System.out.println(soundex("phone","foun"));
    }

    public static String soundex(String string){
        string=string.toUpperCase();
        String out = ""+string.charAt(0);
        int last = peso[string.charAt(0)-'A'];
        int i=1,j=1;
        while(i<4){
            if(j>=string.length()){
                out+="0";
                i++;
            }
            else{
                int current = peso[string.charAt(j)-'A'];
                if(current !=0 && current!=last){
                    out +=current;
                    last=current;
                    i++;
                }
                j++;
            }
        }
        return out;
    }
    public static double soundex(String s1,String s2){
        String out1=soundex(s1);
        String out2=soundex(s2);
        double result=0;
        for(int i=0;i<4;i++){
            if(out1.charAt(i)==out2.charAt(i)) result+=0.25;
        }
        return result;
    }
}
