package ch02.variable;

import java.util.Scanner;

public class Exercise24 {
    public static void main(String[] args) {
        /*
        사용자로부터 500원, 100원, 50원, 10원짜리 동전의 갯수를 입력 받아
        저금통 안에 총 얼마가 들어 있는지 출력하는 프로그램을 만들어 보자.

        <console>
        500원짜리 동전의 개수: 13
        100원짜리 동전의 개수: 35
        50원짜리 동전의 개수: 21
        10원짜리 동전의 개수: 17
        저금통 안의 동전의 총 액수: 11,220원
         */
        Scanner scanner = new Scanner(System.in);
        // 입력
        System.out.print("500원짜리 동전의 개수: ");
        int coin500 = scanner.nextInt();
        System.out.print("100원짜리 동전의 개수: ");
        int coin100 = scanner.nextInt();
        System.out.print("50원짜리 동전의 개수: ");
        int coin50 = scanner.nextInt();
        System.out.print("10원짜리 동전의 개수: ");
        int coin10 = scanner.nextInt();
        // 처리
        int amount = coin500 * 500 + coin100 * 100 + coin50 * 50 + coin10 * 10;
        // 출력
        System.out.printf("저금통 안의 동전의 총 액수: %,d원", amount);

    }
}
