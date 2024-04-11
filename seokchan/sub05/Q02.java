package source.seokchan.sub05;

public class Q02 {
    public static void main(String[] args) {
        String example = "로꾸꺼 로꾸꺼";
        String result = reverseStr(example);
        System.out.println(result);
    }
    public static String reverseStr(String args){
       String rev = "";
       for(int i = args.length() -1; i>=0; i--)
           rev += args.substring(i,i+1);
       return rev;
    }
}
