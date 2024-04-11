package ch03.operator;

import java.util.Scanner;

public class Exercise31 {
    public static void main(String[] args) {
        /*
        두 정수를 입력받아 큰 수를 작은 수로 나눈 몫과 나머지를 출력하는 프로그램을 만들어보자.
        임의의 두 정수는 a, b에 대하여 ((a + b) + |a - b|) / 2 는 큰 수,
        ((a + b) - |a - b|) / 2 는 작은수이다.
        절대값은 Math.abs(숫자)로 나타낸다. 만약 |-3|을 절대값으로 변경하려면 Math.abs(-3)
        이라고 쓰면 3이 나온다.

        <console>
        첫 번째 숫자를 입력하세요: 10
        두 번째 숫자를 입력하세요: 3
        몫은 3이고, 나머지는 1이다.
         */
        Scanner scanner = new Scanner(System.in);
        // 입력
        System.out.print("첫 번째 숫자를 입력하세요: ");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.print("두 번째 숫자를 입력하세요: ");
        int b = Integer.parseInt(scanner.nextLine());
        // 처리
        int big = ((a + b) + Math.abs(a - b)) / 2;
        int small = ((a + b) - Math.abs(a - b)) / 2;
        // 몫
        int quotient = big / small;
        // 나머지
        int remainder = big % small;
        // 출력
        System.out.println("몫은 " + quotient + "이고, 나머지는 " + remainder + "이다.");
        System.out.printf("몫은 %d이고, 나머지는 %d이다.", quotient, remainder);
    }
}
