package source.seokchan.sub05;
import java.util.Random;
public class Q03 {
    public static void main(String[] args) {
        int rand = makeRandom(10, 20);
        System.out.println(rand);
    }
    public static int makeRandom(int a, int b){
        int ranNum = 0;
        ranNum = (int)(Math.random()*(b-a+1)) + a;

        return ranNum;
    }
}
