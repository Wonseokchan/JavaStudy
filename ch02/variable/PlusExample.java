package ch02.variable;

import java.util.Scanner;

public class PlusExample {
    public static void main(String[] args) {
        // 강제적
        int a = 10; // 예약어는 변수로 사용할 수 없다.
        int abc10 = 10; // 숫자로 시작하는 변수도 사용할 수 없다.
        int _abc$ = 10;// 특수문자는 _(underscore), $만 사용 가능하다.
        // Naming Convention(명명 규칙): 교통 신호등
        /*
        변수: camel case
        함수(메소드): camel case
        클래스: pascal case
        상수: 모두 대문자 그리고 연결문자는 underscore
         */

        // 스캐너 준비
        Scanner scanner = new Scanner(System.in);

        // 첫번째 숫자 입력
        System.out.print("첫번째 숫자 입력: ");
//        scanner.nextInt();// 정수 받는 함수
//        scanner.next(); // 문자열로 데이터 받는 함수 10 20
//        scanner.nextLine(); // 문자열로 데이터 받는 함수 10 20
        String firstString = scanner.nextLine();
        int firstNumber = Integer.parseInt(firstString);

        // 두번째 숫자 입력
        System.out.print("두번째 숫자 입력: ");
        String secondString = scanner.nextLine();
        int secondNumber = Integer.parseInt(secondString);

        // 두 수 더하기
        int result = firstNumber + secondNumber;
        System.out.printf("%d + %d = %d", firstNumber, secondNumber, result);

    }
}
