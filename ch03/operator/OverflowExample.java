package ch03.operator;

public class OverflowExample {
    public static void main(String[] args) {
        byte a = -128;
        a--;
        System.out.println(a);
    }
}
