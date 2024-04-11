package seokchan.sub02;

public class Q02 {
    public static void main(String[] args) {
        int example = 278;
        String strEx = example +"";

        int a = Integer.parseInt(strEx.substring(0,1));
        int b = Integer.parseInt(strEx.substring(1,2));
        int c = Integer.parseInt(strEx.substring(2,3));

        int result = a + b + c;
        System.out.println(result);

        /*12f = 303 = 0001 0010 1111;
          AND   147 = 1001 0011;
                      0001 0010 0111;*/
    }
}
