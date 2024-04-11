package source.ch10_java_api;

import java.awt.*;

public class ApiPattern {
    public static void main(String[] args) {
        //정규표현식(Regular Expression)

        //유효성 검증(Validation)

        //숫자만 존재하는지 검증
        String example = "010-9787-4561";
        String regex = "^[0-9]$"; //^ : 문자 시작, $ : 문자 끝, []: 문자 >> 문자열 시작과 끝 사이에 숫자가 1개 존재함
        regex = "^[0-9]+$"; //문자열의 시작과 끝 사이에 숫자가 1개 이상 존재함
        regex = "^[0-9]{11}$"; //문자열의 시작과 끝 사이에 숫자가 11개 존재함
        regex = "^[0-9]{10,11}$"; //문자열의 시작과 끝 사이에 숫자가 10~11개 존재함
        regex = "^010[0-9]{7,8}$"; //010문자 뒤에 숫자가 7~8개 존재함
        regex = "^010-[0-9]{3,4}-[0-9]{4}$";

        //검사 진행
        System.out.println(example + "의 검증" + regex + "결과 : " + example.matches(regex));

        System.out.println();
        //알파벳만 존재하는지 검증
        example = "Jeong Chanung";
        regex = "^[a-z|A-Z| ]+$"; //문자열의 시작과 끝에 알파벳 소문자 또는 대문자가 1개 이상 존재함
        regex = "^[a-zA-Z ]+$"; // 또는 을 의미하는 | 생략 가능 // 띄어쓰기는 명시적이지 않아서 띄어쓰기를 의미하는 \\s로 사용가능
        regex = "^[a-zA-Z\\s]+$"; // 띄어쓰기는 명시적이지 않아서 띄어쓰기를 의미하는 \\s로 사용가능
        System.out.println(example + "의 검증" + regex + "결과 : " + example.matches(regex));

        System.out.println();
        //한글만 존재하는지 검증
        example = "정찬웅";
        regex = "^[ㄱ-ㅎ|ㅏ-ㅣ]+$"; //한글 자음 또는 모음에 대해 검사
        regex = "^[가-힣]+$"; //한글이 1개 이상
        System.out.println(example + "의 검증" + regex + "결과 : " + example.matches(regex));

        //아이디 검증
        //영어와 숫자로 구성 7글자 이상 12글자 이하
        example = "sdfsf12414";
        regex = "^[a-z|A-Z|0-9]{7,12}+$";
        regex = "^\\w{7,12}$"; //[a-z|A-Z|0-9]와 \\w는 같다
        System.out.println(example + "의 검증" + regex + "결과 : " + example.matches(regex));

        //비밀번호
        //영어 + 숫자 + 특수문자 8~16글자 사이
        example = "1q2w3e4r!";
        regex = "^[a-z|A-Z|0-9|~!@#$%^&]{8,12}$";
        System.out.println(example + "의 검증" + regex + "결과 : " + example.matches(regex));

        //영어 소문자, 대문자, 숫자, 특수문자 각 1개 이상 10~16글자 사이
        example = "Qwer1234~!";
        regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[~!@#$%^&*])[a-z|A-Z|0-9|~!@#$%^&]{10,16}$";
        System.out.println(example + "의 검증" + regex + "결과 : " + example.matches(regex));

        //PIN 비밀번호 설정 시
        example = "211116";
        regex = "^.*([0-9])\\1\\1\\1.*$";
        System.out.println(example + "의 검증" + regex + "결과 : " + example.matches(regex));

        //이메일
        example = "akow283@gamil.com";
        //@앞에 영어또는 숫자 1개이상
        //@뒤에 영어 1개 이ㅏㅇ
        //.뒤에 영어 1개 이상
        regex = "^(?=.*[a-z])(?=.*[0-9])@(?=.*[a-z])$";

    }
}
