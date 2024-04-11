package source.ch11_exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExMethod {
    //날짜형 문자열이 들어오면 그 밀리초로 바꾼 값을 리턴
    //yyyy.MM.dd로 들어와야 함
    public static long dateToLong(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

        //sdf.parse()는 패턴(yyyy.MM.dd)과 다른 형태의 문자열이 파라미터로 들어오면 ParseException 발생 -> 에러처리 해야함
        //1. 해당 에러에 대한 처리를 여기서 할거면 try-catch 사용
        //2. 해당 에러에 대한 처리를 여기서 안할거면 throws로 던진다 -> dateLong 메소드를 실행하는 곳에서 try-catch 사용해야 함
        Date temp = sdf.parse(date);

        return temp.getTime();
    }

    //파라미터로 0이 들어오면 문자열 "가위" 리턴
    //파라미터로 1이 들어오면 문자열 "바위" 리턴
    //파라미터로 2가 들어오면 문자열 "보" 리턴
    //그 외 다른 숫자가 들어오면 에러 발생
    public static String game(int n) throws Exception{
        if(n == 0){
            return "가위";
        }
        else if(n == 1){
            return "바위";
        }
        else if(n == 2){
            return "보";
        }
        else{
            //에러 발생시키기(= 에러 객체를 생성)
            //메소드 내에 에러를 발생시키는 코드가 존재하면 해당 메소드에 throws를 표기해주어야 함
            //throw new Exception(); //Exception 객체를 생성하여 던짐

            //Exception의 생성자에 에러 메시지를 적어줄 수 있음
            //throw new Exception("0~2 사이의 숫자를 입력하세요");

            throw new BizException("0~2 사이의 숫자를 입력하세요",ExCode.PARAM_OUT_OF_BOUND);
        }
    }

    //입력받은 이름을 콘솔창에 출력
    //파라미터로 들어온 문자열이 숫자이거나 empty면 안됨
    public static void printName(String name) throws BizException{
        if(name.length() == 0){
            throw new BizException("빈 문자열은 안됩니다.", ExCode.PARAM_IS_EMPTY);
        }
        else if(name.matches("^.*[0-9].*$")){
            throw new BizException("이름에 숫자는 빼주세요.", ExCode.PARAM_CONTAIN_NUMBER);
        }
        //throw new Exception()이 실행되면 현재 메소드는 즉시 종료된다
        System.out.println(name);
    }
}
