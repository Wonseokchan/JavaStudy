package ch02.variable;

public class PrintExample {
    public static void main(String[] args) {
        System.out.println("출력 방법1");
        int hour = 3;
        int minute = 5;
        System.out.println(hour + "시간 " + minute + "분");
        System.out.printf("%d시간 %d분\n", hour, minute);
        /*
        %d: => digit(숫자)
        %f: => float(실수)
        %s: => string(문자열)
        \n => 줄바꿈, \t => 탭
         */
        int value = 1234;
        System.out.printf("상품의 가격: %,d원\n", value);
        System.out.printf("상품의 가격: %,6d원\n", value);
        System.out.printf("상품의 가격: %,-6d원\n", value);
        System.out.printf("상품의 가격: %,06d원\n", value);
        double area = 3.141592 * 10 * 10;
        System.out.printf("반지름이 %d인 원의 넓이: %10.2f\n", 10, area);
        String name = "홍길동";
        String job = "도적";
        String result = String.format("%3d번 | %10s | %10s\n", 1, name, job);
        System.out.println(result);
    }
}
