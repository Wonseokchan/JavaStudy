package ch02.variable;

public class StringMethodExample {

    public static void main(String[] args) {
        // 문자열(String) 타입의 메소드
        // 변수의 타입 -> 1. 기본타입 | 2. 참조타입
        // 값의 종류 -> 숫자, 문자열, true/false
        // 기본타입 -> 숫자, true/false
        // 기본 타입 외에는 전부 참조타입
        // 기본타입은 메소드가 없음
        int age = 30;
        String name = "찬웅";

        // 문자열(String)은 클래스(class)이므로
        // 클래스 안에 다양한 메소드가 만들어져 있다.
        // 문자열은 쌍따옴표("") 안 문자들을 말한다.
        // char 타입의 '가' 와 String 타입의 "가"는 서로 다르다.
        String fruits = "Apple, Banana, Cherry";
        System.out.println(fruits);

        // .length()
        // 해당 문자열의 길이를 리턴
        System.out.println(fruits.length());
        System.out.println("Apple, Banana, Cherry".length());

        // .charAt(인덱스)
        // 인덱스는 배열, 문자열에서 해당 값이 몇 번째에
        // 해당하는지에 대한 숫자를 의미
        // 인덱스는 0부터 시작
        // (첫번째 글자 = 인덱스가 0)
        // (두번째 글자 = 인덱스가 1)
        // 해당 문자열에서 인덱스에 해당하는 문자(char)를 리턴한다.
        System.out.println(fruits.charAt(7));
        // 유니코드
        char b = fruits.charAt(7);
        System.out.println(b);


        // .indexOf(문자열)
        // 해당 문자열에서 괄호 안에 있는 문자의 인덱스를 리턴
        System.out.println(fruits.indexOf("Cherry"));
        // 문자열의 대소문자를 구분하며,
        // 존재하지 않는 문자열에 대해 -1 리턴
        System.out.println(fruits.indexOf("cherry"));
        // 여러개 존재한다면, 처음 발견된 문자의 인덱스만 리턴
        System.out.println(fruits.indexOf("a"));


        // .substring(시작 인덱스, 끝 인덱스)
        // 해당 문자열을 시작 인덱스에서 끝 인덱스 전까지
        // 자른 문자열을 리턴
        System.out.println(fruits.substring(7, 13));
        // substring을 실행하더라도 원본이 변하지는 않는다.
        System.out.println(fruits);
        // substring에 시작인덱스만 넣게 되면
        // 시작인덱스부터 문자열 끝까지 자른 값을 리턴
        System.out.println(fruits.substring(7));


        // .replace(바뀔 문자열, 바꾸고 싶은 문자열)
        // 해당 문자열에서 특정 문자열을 바꾸고 싶은 문자열로 교체
        System.out.println(fruits.replace("Cherry", "Coconut"));
        // 원본은 변하지 않는다.
        System.out.println(fruits);

        // 원본을 바꾸고 싶다면
        fruits = fruits.replace("Cherry", "Coconut");
        System.out.println(fruits);

        // 특정 문자열을 제거하는데 사용
        String world = "   The New World !!   ";

        // 공백문자 제거
        System.out.println(world.replace(" ", ""));

        // .trim()
        // 해당 문자열의 양 끝에 존재하는 모든 공백문자를 제거해준다.
        // 사용자의 입력값, 외부에서 가져온 데이터를 다듬을 때 유용함




    }

}
