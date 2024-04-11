package source.ch09_extends_interface.mysort;

import source.ch08_class.school.Student;

import java.util.ArrayList;

public class MyCollections {

    //첫번째 파라미터로 들어오는 ArrayList에 들어있는 객체 타입을 모른다.
    public static <T> void mySort(ArrayList<T> paramList, MyComparator<T> comp){
        for(int k = 0; k < paramList.size() - 1; k++){
            for(int i = 0; i < paramList.size() - 1 - k; i++){
                //if문 내부 조건이 true일 때 자리를 바꿈
                //if문 내부 조건이 정렬의 기준이 됨
                if(comp.myCompare(paramList.get(i), paramList.get(i+1))) {
                    T temp = paramList.get(i);
                    paramList.set(i, paramList.get(i + 1));
                    paramList.set(i + 1, temp);
                }
            }
        }
    }
}
