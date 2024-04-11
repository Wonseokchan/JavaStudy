package source.seokchan.sub07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class Q01 {
    public static void main(String[] args) {
        //1. 정수를 담을 수 있는 ArrayList 객체를 생성하고, 10부터 20 사이의 랜덤 숫자를 10개 담으시오. (10도 나오고 20도 나올 수 있어야 함)
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            a.add((int)(Math.random()*11)+10);
        }
        System.out.println("1. "+a);

        //2. 해당 정수형 리스트에서 중복된 숫자들을 제거한 후 출력하시오.
        ArrayList<Integer> b = new ArrayList<>();
        for(int i = 0; i < a.size(); i++){
            if(!b.contains(a.get(i)))
                b.add(a.get(i));
        }
        System.out.println("2. "+b);

        //remove 이용하는 방법
        for(int i = 0; i < a.size(); i++){
            for(int j = a.size()-1; j > i; j--){
                if(a.get(i)==a.get(j))
                    a.remove(j);
            }
        }
        System.out.println("2. " +a);

        //3. 중복을 제거한 정수형 리스트를 오름차순으로 정렬하여 출력하시오.
        Collections.sort(b);
        System.out.println("3. "+b);

        //4. 중복을 제거한 정수형 리스트를 내림차순으로 정렬하여 출력하시오.
        Collections.sort(b, Collections.reverseOrder());
        System.out.println("4. "+b);

    }
}
