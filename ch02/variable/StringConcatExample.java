package ch02.variable;

public class StringConcatExample {
    public static void main(String[] args) {
        // "10"와 10
        // 1. 숫자를 문자로 변환
        // (1) + 연산자: 부호, 덧셈, 결합
        // 10 + 20
        //"10" + 20, 10 + "20"
        String var1 = 10 + "";
        String var2 = String.valueOf(10);
        // 2. 문자를 숫자로 변환
        int var3 = Integer.parseInt("10");
        double var4 = Double.parseDouble("10.1");
        byte var5 = Byte.parseByte("10");
    }
}
