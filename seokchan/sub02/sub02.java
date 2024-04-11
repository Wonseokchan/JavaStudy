package seokchan.sub02;

import java.util.Scanner;

public class sub02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("이름을 입력해주세요.");
        String name = scanner.nextLine();

        System.out.println("국어 점수를 입력해주세요.");
        int kor = Integer.parseInt(scanner.nextLine());

        System.out.println("영어 점수를 입력해주세요.");
        int eng = Integer.parseInt(scanner.nextLine());

        System.out.println("수학 점수를 입력해주세요.");
        int math = Integer.parseInt(scanner.nextLine());

        double avg = (kor + eng + math) / 3.0;

        System.out.println("이름 : " + name);
        System.out.println("국어 : " + kor);
        System.out.println("영어 : " + eng);
        System.out.println("수학 : " + math);
        System.out.printf("평균 : %.2f", avg);

    }
}
