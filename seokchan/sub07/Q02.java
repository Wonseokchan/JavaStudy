package source.seokchan.sub07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Q02 {
    public static void main(String[] args) {
        //아내가 사고 싶은 물건  ["냉장고", "로봇청소기", "세탁기", "에어컨"] 을 리스트에 담아주세요.
        //남편이 사고 싶은 물건 ["노트북", "TV", "에어컨", "플레이스테이션", "로봇청소기"] 을 다른 리스트에 담아주세요.
        //1. 서로 사고 싶은 물건 목록을 새로운 리스트에 담아 콘솔에 출력해주세요(교집합)
        String[] a = { "냉장고", "로봇청소기", "세탁기", "에어컨" };
        String[] b = { "노트북", "TV", "에어컨", "플레이스테이션", "로봇청소기" };
        ArrayList<String > woman = new ArrayList<>(Arrays.asList(a));
        ArrayList<String> man = new ArrayList<>(Arrays.asList(b));

        ArrayList<String> emp = new ArrayList<>();
        for(int i = 0; i < woman.size(); i++){
            for(int j = 0; j < man.size(); j++){
                if(Objects.equals(woman.get(i), man.get(j)))
                    emp.add(woman.get(i));
            }
        }
        System.out.println(emp);

        //2. 사고 싶은걸 다 산다고 했을때의 구매 목록을 새로운 리스트에 담아 콘솔에 출력해주세요(합집합)
        ArrayList<String> all = new ArrayList<>(woman);
        for(int i = 0; i < man.size(); i++){
            boolean isContain = false;
            for(int j = 0; j < all.size(); j++) {
                if (man.get(i).equals(all.get(j)))
                    isContain = true;
            }
            if(isContain == false)
                all.add(man.get(i));
        }
        System.out.println(all);
    }
}
