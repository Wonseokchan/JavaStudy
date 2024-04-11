package source.seokchan.sub03;

import java.io.FilterOutputStream;

public class Q03 {
    public static void main(String[] args) {
        for(int i = 0; i <= 5; i++){
            String blank = "";
            for(int j = 0; j < i; j++){
                blank += " ";
            }
            String star = "";
            for(int k = 0; k< 5-i;k++){
                star += "*";
            }
            System.out.println(star+blank);
        }
    }
}
