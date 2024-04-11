package ch02.variable;

public class VariableExchangeExample {
    public static void main(String[] args) {
        int x = 3;
        int y = 5;
        // x: 3, y: 5
        System.out.println("x: " + x + ", y: " + y);
        // x의 값과 y의 값을 바꿔서 저장하기
        int t = x;
        x = y;
        y = t;
        System.out.println("x: " + x + ", y: " + y);
    }
}
