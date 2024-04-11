package ch02.variable;


import java.util.Scanner;

public class InputExample {
    public static void main(String[] args) {
        // 콘솔창에서 사용자로부터 데이터를 입력 받기 위해 사용
        // Scanner 스캐너
        // 스캐너 준비
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력하세요: ");
        // 사용자가 입력한 데이터를 숫자로 변환해서 반환
        int firstNumber = scanner.nextInt();
        int result = firstNumber + 100;
        System.out.println(result);
    }
}
