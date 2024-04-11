package ch03.operator;
public class CastExample {
    public static void main(String[] args) {

        //강제 형변환
        //(변환활 타입 값)
        //값을 변환하고자 하는 타입으로 강제 형변환할 수 있다
        //(변환이 가능한 경우에만 가능)
        int intCast = (int)3.9999;
        System.out.println(intCast);

        //주의해야할 점
        int mulVal = (int)(10 * 3.333);
        System.out.println(mulVal);

        //가장 많이하는 실수
        double result = 10 / 3;     //3.333 예상
        System.out.println(result); //3.0

        //3.3333으로 출력되려면??
        double result2 = (double)10/3;
        System.out.println(result2);

        //숫자 문자열과 숫자간의 형변환
        String strNum = "123";
        System.out.println(strNum + 2); //1232

        //숫자 문자열을 정수로 형변환
        //Integer.parseInt(숫자 문자열) !!!!!
        System.out.println(Integer.parseInt(strNum) + 2); //125

        String id = "19990309";
        int year = 2024;
        System.out.println();

        //만 나이 계산하기
        String idYear = id.substring(0,4);
        int intId = Integer.parseInt(idYear);

        System.out.println(year-intId);

        //숫자를 숫자형 문자열로 변환
        int today = 27;
        String strToday = today + "";
        System.out.println(strToday);





    }
}
