package ch03.operator;

public class Confirm32 {
    public static void main(String[] args) {
        int score = 85;
        String result = (!(score > 90)) ? "가" : "나";
        System.out.println(result);
    }
}
