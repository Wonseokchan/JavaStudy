package source.ch11_exception;

import java.text.ParseException;
import java.util.Scanner;

public class ExceptionMain {
    public static void main(String[] args) {
        //굳이 나누자면 에러와 예외는 서로 다르지만 대부분 예외 상황에 대해서 에러가 났다고 표현(=뻑났다)
        //에러는 예측이 가능한 에러와 예측하지 못한 에러로 나눌 수 있다
        //둘 다 try-catch 문으로 처리 가능

        int[] intArray = {1,2,3};

        //예외처리
        //try-catch문
        /*try {
            //try 중괄호 내부에는 에러가 발생할 수 있는 코드를 넣는다.
            System.out.println(intArray[5]);
            System.out.println("인덱싱 종료");
        }catch (ArrayIndexOutOfBoundsException e){ //에러 발생 시 생성이 된 에러 객체가 들어옴
            //try 내부에서 발생한 에러 타입이 catch에 적어 놓은 에러의 타입과 일치하면 catch 중괄호 내부 코드 실행
            System.out.println(e.getMessage());
            e.printStackTrace();
        }*/
        //기본적으로 에러 발생 시 프로그램이 종료되어 이후 코드가 실행되지 않는다
        // = 에러에 대해 예외처리를 하면 프로그램이 종료되지 않는다
        System.out.println("프로그램 종료");

        //직접 빨간줄을 콘솔창에 출력하기
        //에러 메시지가 콘솔창에 출력되는 시점과 println()이 콘솔창에 출력되는 시점이 다르다
        System.out.println("블루베리");
        System.out.println("딸기");
        System.out.println("포도");
        System.out.println("토마토");

        System.out.println("\n===================================\n");
        /*try {
            System.out.println(1 / 0);
        }
        catch(Exception er){ // Exception은 모든 예외 클래스의 최상위 클래스이므로 어떤 예외 객체든 catch 가능
            throw new RuntimeException(er);
        }
        System.out.println("프로그램 종료");*/

        System.out.println("\n===================================\n");
        Scanner scan = new Scanner(System.in);
//        while (true){
//            System.out.println("행동 선택");
//            System.out.println("1. 밥먹기 | 2. 잠자기 | 3. 종료");
//            System.out.print(">>> ");
//            int cmd = 0;
//            try {
//                cmd = Integer.parseInt(scan.nextLine());
//            }catch(NumberFormatException e){
//                System.out.println("숫자만 입력해주세요");
//                continue;
//            }
//            if(cmd == 1){
//                System.out.println("냠냠");
//            }
//            else if(cmd == 2){
//                System.out.println("쿨쿨");
//            }
//            else if(cmd == 3){
//                System.out.println("종료");
//                break;
//            }
//            else {
//                System.out.println("다시 입력해주세요");
//            }
//        }
        System.out.println("\n===================================\n");
        try{
            System.out.println(intArray[5]);
        }catch(ArrayIndexOutOfBoundsException e){ // 예측 가능한 예외 상황 처리
            System.out.println("배열의 인덱스 넘어감");
        }catch (Exception e){ //예측하지 못한 에러 상황 처리(최후의 보험)
            System.out.println("예측하지 못한 상황 발생");
        }

        //일반적으로 예측 가능한 예외 상황 처리를 위해 따로 Exception을 상속받은 클래스를 만들어서 사용
        System.out.println("\n===================================\n");

        try{
            ExMethod.dateToLong("2024.03.01");
        }catch(ParseException e){
            System.out.println("날짜 포맷이 불일치함");
        }
        System.out.println("프로그램 종료3");

        try {
            System.out.println(ExMethod.game(30));
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        try {
            ExMethod.printName("대머4리");
        } catch (BizException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(e.getErrCode()); //사용자에게 넘겨줌
            //사용자는 에러코드를 보고 가이드 문서와 함께 원인을 파악
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("프로그램 종료3");
    }
}
