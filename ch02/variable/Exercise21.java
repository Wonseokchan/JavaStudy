package ch02.variable;

import java.util.Scanner;

public class Exercise21 {
    public static void main(String[] args) {
        /*
        실수 자료형을 이용하여 직사각형의 둘레와 면적을 구하는 프로그램을 만들어 보자.
        실수형 변수 width(가로), height(세로), area(넓이), perimeter(둘레)를 선언하고,
        Scanner 클래스를 이용하여 사용자로부터 직사각형의 가로, 세로 길이를 입력받아
        다음과 같이 넓이와 둘레를 출력한다.

        <console>
        가로의 길이는?(단위: m): 3.7
        세로의 길이는?(단위: m): 7.5
        직사각형의 넓이: 27.75
        직사각형의 둘레: 22.4
         */
        // 프로그램: 입력(input) - 처리(processing) - 출력(output)
        // 입력
        Scanner scanner = new Scanner(System.in);
        System.out.print("가로의 길이는?(단위: m): ");
        double width = scanner.nextDouble();
        System.out.print("세로의 길이는?(단위: m): ");
        double height = scanner.nextDouble();

        // 처리
        double area = width * height;
        double perimeter = (width + height) * 2;

        // 출력
        System.out.println("직사각형의 넓이: " + area);
        System.out.println("직사각형의 둘레: " + perimeter);

    }
}
