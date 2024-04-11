package source.ch07_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;

public class CollectionList {
    public static void main(String[] args) {
        //리스트
        //collection은 타입 옆에 제너릭<>을 붙여주고, 해당 collection 객체가 담는 데이터의 타입을 넣어준다.
        ArrayList<String> students = new ArrayList<String>();
        ArrayList<String> students2 = new ArrayList<>(); //뒤쪽 제너릭 내부는 생략가능

        //collection은 데이터로 객체(참조타입)만 담을 수 있다.
        //기본타입을 담기 위해서 Wrapper class를 이용
        ArrayList<Integer> intList = new ArrayList<>();
        //Wrapper class는 기본 타입의 데이터를 객체로 사용해야 하는 경우 사용한다.
        int intVal = 13;
        //기본 타입의 데이터를 Wrapper class로 만들기 = 박싱(boxing)
        //Integer num = new Integer(13); --기존
        Integer num = 13; //오토박싱

        //Wrapper class에 저장된 기본 타입 값을 꺼내기 = 언박싱
        //int intVar = num.intValue(); --기존
        int intVar = num; //오토언박싱
        System.out.println(intVar);
        System.out.println("\n================\n");

        //ArrayList에 값 담기
        intList.add(1);
        intList.add(5);
        intList.add(31);
        System.out.println(intList);

        students.add("석찬");
        students.add("지윤");
        students.add("지인");
        System.out.println(students);
        //한번에 여러개의 데이터를 넣을 수 없다.
        //해당 컬렉션의 제너릭 타입과 일치하는 데이터만 추가 가능
        System.out.println("\n===============================\n");

        //List의 메소드들
        //.size()
        //리스트에 담긴 값의 개수를 리턴
        System.out.println(intList.size());

        intList.add(42);
        System.out.println(intList.size());

        //값이 들어있지 않으면 size는 0
        System.out.println(students2.size());

        //.get(인덱스)
        //해당 인덱스의 값 리턴
        System.out.println(intList.get(1));

        //.set(인덱스, 값)
        //해당 인덱스의 값을 괄호 안 값으로 교체
        intList.set(1,20);
        System.out.println(intList);

        //.remove(인덱스)
        //해당 인덱스의 값을 삭제
        intList.remove(1);
        System.out.println(intList);

        //.clear()
        //해당 리스트를 비움
        intList.clear();
        System.out.println(intList);

        //리스트를 초기화해도 상관없음
        intList = new ArrayList<>();
        System.out.println(intList);

        System.out.println("\n==============================\n");
        System.out.println(students);
        //for문으로 List 제어
        // 석찬, 지윤, 지인, .... >> 1. 석찬, 2. 지윤, 3. 지인, ....
        for(int i = 0; i < students.size(); i++){
            students.set(i, (i+1) + ". " + students.get(i));
        }
        System.out.println(students);
        System.out.println("\n==============================\n");

        //리스트의 복사
        ArrayList<String> copyList = students;
        //System.out.println(copyList);
        copyList.set(0, "1. 진율");
        System.out.println(".copy : " +copyList);

        //리스트의 복사 1 - .clone() 사용
        ArrayList<String> cloneList = (ArrayList<String>) students.clone();
        //System.out.println(cloneList);

        cloneList.set(0, "1. 상연");
        System.out.println(".clone() : " + cloneList);

        //리스트의 복사 2 - .addAll() 사용
        ArrayList<String> addList = new ArrayList<>();
        addList.addAll(students);
        System.out.println(".addAll() : " +addList);

        //리스트의 복사 3 - 생성자 사용
        ArrayList<String> constList = new ArrayList<>();
        System.out.println(constList);

        //리스트의 복사 4 - 기본 로직으로 구현
        ArrayList<String> basicList = new ArrayList<>();
        for(int i = 0; i < students.size(); i++){
            basicList.add(students.get(i));
        }
        System.out.println("기본 로직 : " +basicList);

        System.out.println("\n================================\n");

        //향상된 for문 (= 일반적으로 말하는 foreach문)
        /*for(int i = 0; i <students.size(); i++)
            System.out.println(students.get(i));*/

        //인덱스가 존재하는 List에서는 향상된 for문의 사용이 큰 메리트가 있는건 아니다. 코드가 좀 더 간결해지는 느낌이 전부
        for( String stu : students)
            System.out.println(stu);

        //자바의 forEach문
        students.forEach(new Consumer<String>() {
            @Override
            public void accept(String stu) {
                System.out.println(stu);
                System.out.println(stu);
                System.out.println(stu);
                System.out.println(stu);
            }
        });

        //forEach문을 람다식(->)으로 작성
        students.forEach(stu -> System.out.println(stu));
        //코드 라인이 여러줄이면 중괄호 필요
        students.forEach(stu -> {
            System.out.println(stu);
            System.out.println(stu);
            System.out.println(stu);
            System.out.println(stu);
        });

        System.out.println("\n================================\n");

        //값을 주면서 리스트 선언
        Integer[] array = { 30, 23, 1, 6, 54, 22 };
        //ArrayList<String> numbers = new ArrayList<>(Arrays.asList(30, 23, 1, 6, 54, 22));
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(array));
        System.out.println(numbers);

        //정렬 메소드 이용(버블정렬)
        for(int i = 0; i < numbers.size()-1; i++) {
            for (int j = 0; j < numbers.size()-1; j++) {
                if (numbers.get(j) > numbers.get(j+1)) {
                    Integer temp = numbers.get(j);
                    numbers.set(j, numbers.get(j+1));
                    numbers.set(j+1, temp);
                }
            }
        }
        System.out.println("정렬 메소드 : "+numbers);

        //제공되는 메소드로 정렬하기
        Collections.sort(numbers); //오름차순
        System.out.println("오름차순 : "+numbers);
        Collections.sort(numbers, Collections.reverseOrder()); //내림차순
        System.out.println("내림차순 : "+numbers);


    }
}
