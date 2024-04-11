package source.seokchan.sub08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Q01 {
    public static void main(String[] args) {
        //makeLotto를 ArrayList와 HashSet을 이용해서 만들어보세요
        ArrayList<Integer> myLotto = makeLotto();
        System.out.println(myLotto);
    }

    public static ArrayList<Integer> makeLotto() {
            HashSet<Integer> lottoset = new HashSet<>();
            while(true) {
                int rand = ((int) (Math.random() * 45) + 1);
                lottoset.add(rand);
                if(lottoset.size()==6)
                    break;
            }
            ArrayList<Integer> result = new ArrayList<>();
            result.addAll(lottoset);
            Collections.sort(result);
            return result;
            //정렬
        }
}
