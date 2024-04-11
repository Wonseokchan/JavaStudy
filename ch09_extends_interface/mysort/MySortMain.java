package source.ch09_extends_interface.mysort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import source.ch08_class.school.Student;
public class MySortMain {
    public static void main(String[] args) {
        ArrayList stuList = new ArrayList();

        stuList.add(new Student("코난",98,89,77));
        stuList.add(new Student("짱구",28,46,97));
        stuList.add(new Student("호빵맨",92,39,87));
        stuList.add(new Student("루피",88,79,79));
        stuList.add(new Student("뽀로로",81,82,67));

        for(int i = 0; i<stuList.size(); i++){
            System.out.println(stuList.get(i));
        }

        //정렬
        /*for(int k = 0; k<stuList.size() -1; k++){
            for(int i = 0; i < stuList.size()-1-k; i++){
                //if문 내부 조건이 true일 때 자리를 바꿈
                //if문 내부 조건이 정렬의 기준이 됨
                if(stuList.get(i).getAvg() < stuList.get(i).getAvg()) {
                    Student temp = stuList.get(i);
                    stuList.set(i, stuList.get(i + 1));
                    stuList.set(i + 1, temp);
                }
            }
        }*/

        for(int i = 0; i<stuList.size(); i++){
            System.out.println(stuList.get(i));
        }

        System.out.println("\n===================================\n");


        //인터페이스의 추상메소드를 이용한 콜백함수 구현
        //콜백함수란? 추상메소드를 이용하여 메소드의 실행 시점만 설정한 후 메소드를 실행하는 쪽에서 해당 추상메소드를 구현하게끔 만든 메소드

        //Collections 클래스에 sort 메소드가 존재함
        //sort 안에 Comparator 인터페이스 내 compare 추상메소드를 집어넣음
        Collections.sort(stuList, new Comparator<Student>(){
            public int compare(Student left, Student right){
                if(left.getAvg() - right.getAvg() < 0){
                    return -1;
                }
                return 0;
            }
        });
        /*Collections.sort(stuList, (left, right) -> {
            if(left.getAvg() - right.getAvg() < 0){
                return -1;
            }
            return 0;
        });*/

        System.out.println("\n=================================\n");
        MyCollections.mySort(stuList, new MyComparator<Student>() {
            @Override
            public boolean myCompare(Student left, Student right) {
                return left.getAvg()-right.getAvg() < 0;
            }
        });
        for(int i = 0; i < stuList.size(); i++){
            System.out.println(stuList.get(i));
        }

        MyCollections.mySort(stuList, new MyComparator<Student>() {
            @Override
            public boolean myCompare(Student left, Student right) {
                return left.getMath() > right.getMath();
            }
        });

        /*MyCollections.mySort(stuList, ((left, right) -> left.getEng() < right.getEng()));*/

        for(int i = 0; i < stuList.size(); i++){
            System.out.println(stuList.get(i));
        }
    }
}
