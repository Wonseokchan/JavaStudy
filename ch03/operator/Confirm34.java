package ch03.operator;

public class Confirm34 {
    public static void main(String[] args) {
        int value = 356;
        // 십의 자리 이하를 버리는 코드를 작성하시오.
//        System.out.println(value / 100 * 100);
        System.out.println(value - value % 100);
    }
}
