package ch02.variable;

import java.util.Scanner;

public class Exercise23 {
    public static void main(String[] args) {
        /*
        원기둥의 밑면의 반지름과 높이를 입력 받아서
        밑면의 넓이와 부피를 계산하는 프로그램을 작성하여 보자.
        원주율은 Math.PI를 사용한다.

        <console>
        원기둥 밑변의 반지름을 입력하시오.(단위: cm): 4.0
        원기둥의 높이를 입력하시오.(단위: cm): 11.0
        원기둥 밑변의 넓이는 50.26548245743669㎠이고,
        원기둥의 부피는 552.9203070318035㎤이다.
         */
        Scanner scanner = new Scanner(System.in);
        // 입력
        System.out.print("원기둥 밑변의 반지름을 입력하시오.(단위: cm): ");
        // double radius = scanner.nextDouble();
        double radius = Double.parseDouble(scanner.nextLine());
        System.out.print("원기둥의 높이를 입력하시오.(단위: cm): ");
        double height = Double.parseDouble(scanner.nextLine());
        // 처리
        double area = Math.PI * radius * radius;
        double volume = area * height;
        // 출력
        System.out.println("원기둥 밑변의 넓이는 " + area + "㎠이고, 원기둥의 부피는 " + volume + "㎤이다.");
    }
}
