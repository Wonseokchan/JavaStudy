package source.ch07_collection;

import java.util.*;


public class CollectionSet {
    public static void main(String[] args) {
        //set은 우리가 직접 만들어서 사용하는 경우는 드뭄 하지만 set의 사용법은 알아두셔야 한다.

        //Set의 선언
        //HashSet
        HashSet<String> stuSet = new HashSet<>();

        //다형성 이용한 선언
        List<String> strList = new ArrayList<>();
        Set<String> setList = new HashSet<>();

        //값 추가
        //.add()
        //중복된 값이 들어가지 않는다
        stuSet.add("경택");
        stuSet.add("상연");
        stuSet.add("진율");
        stuSet.add("지인");
        System.out.println(".add() : "+stuSet);

        //저장된 값의 갯수 리턴
        //.size()
        System.out.println(".size() : "+stuSet.size());

        System.out.println("\n==================================\n");
        //Set 내부 요소 순회
        //1. Iterator 사용(while문)
        Iterator<String> stuIter = stuSet.iterator();
        while(stuIter.hasNext()){
            String stu = stuIter.next();
            System.out.println(stu);
        }

        //2. 향상된 for문 사용
        for(String stu : stuSet)
            System.out.println(stu);

        //3.forEach문 사용
        stuSet.forEach(stu -> System.out.println(stu));

        System.out.println("\n=========================================\n");

        List<Integer> intList = new ArrayList<>();
        for(int i = 0; i < 10; i++)
            intList.add((int)(Math.random()*11)+10);
        System.out.println(intList);

        //Set의 중복을 허용하지 않는 특성을 이용한 중복 제거
        Set<Integer> intSet = new HashSet<>();
        for(int i = 0; i < intList.size(); i++){
            intSet.add(intList.get(i));
        }
        System.out.println("Set의 중복제거 : "+intSet);

        //Set 비우기
        //.clear()
        intSet.clear();

        //List의 값을 Set에 옮기기
        intSet.addAll(intList);
        System.out.println(intSet);

        //Set의 값을 List에 옮기기
        intList.clear();
        for(int num : intSet){
            intList.add(num);
        }
        System.out.println("향상for : "+intList);

        //순서는 보장되지 않는다
        intList.clear();
        intList.addAll(intSet);
        System.out.println(".addAll : "+intList);









    }
}
