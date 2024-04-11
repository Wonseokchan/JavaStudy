package ch02.variable;

public class VariableUseExample {
    public static void main(String[] args) {
        int hour = 3; // 변수의 선언 및 초기화
        int minute = 5;
        System.out.println(hour + "시간 " + minute + "분");
        
        int totalMinute = hour * 60 + minute;
        System.out.println("총 " + totalMinute + "분");
    }
}
