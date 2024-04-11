package ch03.operator;

import java.util.Scanner;

public class ConditionalExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("점수를 입력하세요: ");
        int score = scanner.nextInt();
        /*
        String result = "";
        if (score >= 60) {
            result = "합격";
        } else {
            result = "불합격";
        }
         */
        String result = score >= 70 ? "상급" : score >= 30 && score < 70 ? "중급" : "하급";
        System.out.println("결과: " + result);

    }
}
