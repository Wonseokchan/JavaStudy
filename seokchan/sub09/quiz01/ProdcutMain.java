package source.seokchan.sub09.quiz01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ProdcutMain {
    public static void main(String[] args) {
        Product a = new Product("냉장고", 2000000);
        Product b = new Product("TV", 1000000);
        Product c = new Product("에어컨", 800000);
        Product d = new Product("컴퓨터", 1300000);
        Product e = new Product("선풍기", 100000);

        ArrayList<Product> proList = new ArrayList<>();
        proList.add(a);
        proList.add(b);
        proList.add(c);
        proList.add(d);
        proList.add(e);

        System.out.println(proList);
        System.out.println("\n=========================\n");
        Collections.sort(proList, (proA, proB) -> proA.getPrice() - proB.getPrice());
        for(Product pro : proList){
            System.out.println(pro);
        }

        for(int i = 0; i < proList.size(); i++){
            if(proList.get(i).getName().equals("TV"))
                System.out.println(i);
        }
    }
}
