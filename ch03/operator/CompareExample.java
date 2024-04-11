package ch03.operator;

import java.util.Scanner;

public class CompareExample {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 10;
        System.out.println(num1 == num2);
        System.out.println(num1 != num2);
        System.out.println(num1 >= num2);

        float num3 = 0.1f; // 0.99999997
        double num4 = 0.1; // 0.100000000000003
        System.out.println(num3 == num4);

        Scanner scanner = new Scanner(System.in);
//        String str1 = "java"; // 0x1234
//        String str2 = "java"; // 0x1234
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));



    }
}
