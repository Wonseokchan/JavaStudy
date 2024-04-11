package source.ch04_controll;

public class Conditional {
    public static void main(String[] args) {
        //조건문
        //if문
        int price = 30000;
        int myMoney = 10000;

        if(myMoney < price) {
            System.out.println("You've not enough minerals.");;
        }
        System.out.println("=====================");

        //변수의 사용범위(Scope) !!!
        //중괄호 블록 안에 선언된 변수는 해당 중괄호 블록 바깥에서 사용할 수 없다.
        String review = "맛있어용";
        String warning = "리뷰 등록 완료";
        if(review.length() < 12){
            warning = "리뷰는 12글자 이상 작성해주세요.";
        }
        System.out.println(warning);

        System.out.println("========else와 else if=========");
        int num = 0;
        if(num<0){
            System.out.println("num가 0보다 작다.");
        }
        else{
            System.out.println("num가 0보다 크거나 같다.");
        }

        if(num<0){
            System.out.println("num가 0보다 작다.");
        }
        else if(num==0){
            System.out.println("num가 0이다.");
        }
        else{
            System.out.println("num가 0보다 크다.");
        }
        System.out.println();
        System.out.println("==========================");
        System.out.println();

        //리모콘의 전원 버튼의 경우 버튼 하나로 전원 on/off가 가능
        //TV의 전원 상태에 대한 변수 선언
        boolean isPowerOn = false;
        if(isPowerOn){
            System.out.println("TV를 끕니다.");
            isPowerOn = false;
        }
        else{
            System.out.println("TV를 켭니다.");
            isPowerOn = true;
        }
        System.out.println();
        //boolean 의 true/false 값을 마치 스위치의 on/off 처럼 사용하는 boolean 타입 변수를 토글 혹은 플래그 변수라고 한다.
        System.out.println("===============");

        int score = 85;
        String grade = "";

        if(score>=90){
            grade = "A";
        }
        else if(score>=80){
            grade = "B";
        }
        else{
            grade = "C";
        }
        System.out.println(grade);

        score = 82;
        grade = "";

        grade = score >= 90 ? "A" : (score >= 80 ? "B" : "C");  //삼항 연산자        = () ? () : ()
        System.out.println(grade);

        System.out.println("\n=====================\n");

        //회원가입 조건 체크
        //이름이 한글자 이상 | 휴대폰 번호는 11자리 또는 10자리 | 나이는 14세 이상
        String name = "";
        String Phnum = "01012345678";
        int age = 20;

        if(name.length()>=1){
            //이름이 한글자 이상
            if(Phnum.length()==10 || Phnum.length()==11 ){
                //휴대폰 번호 조건 만족
                if(age>=14){
                    //나이 조건 만족
                }
                else
                    System.out.println("14세 미만은 회원가입 불가");
            }
            else{
                System.out.println("휴대폰 번호 조건 불충");
            }
        }
        else{
            System.out.println("회원가입 불가");
        }
        System.out.println("회원가입 성공");

        //코드 다듬기(1번)
        boolean isValid = false;

        //name의 길이가 1이상 = name의 문자열이 empty("")이 아니라는 것
        //.isEmpty() -> 해당 문자열이 empty면 true리턴 | 아니라면 false리턴
        if(name.length()>=1){ // ==> !name.isEmpty()
            if(Phnum.length() == 10 || Phnum.length() == 11){
                if(age>=14){
                    isValid = true;
                }
            }
        }

        if(isValid == true){
            System.out.println("회원가입 성공");
        }
        else{
            System.out.println("회원가입 실패");
        }
        System.out.println("\n=========코드다듬기2번=============\n");
        //코드 다듬기 2번
        //논리 연산자 이용
        if(!name.isEmpty() && (Phnum.length() == 10 || Phnum.length() == 11) && age >= 14 ){
            System.out.println("회원가입 성공");
        }
        else{
            System.out.println("회원가입 실패");
        }

        System.out.println("\n=========================\n");

        //switch문
        //특정 변수의 값에 따라서 다른 명령어를 실행하는 경우 사용

        //여러분들의 교육기간 (단위 : 월)
        int month = 1;
        if(month==0){
            System.out.println("자바, DB배우는 중");
        }
        else if(month == 1){
            System.out.println("자바, 화면구현 배우는 중");
        }
        else if(month == 2){
            System.out.println("IOT, 화면구현 배우는 중");
        }
        else if(month == 3){
            System.out.println("중간 프로젝트");
        }
        else if(month == 4 ){
            System.out.println("스프링, 파이썬 배우는 중");
        }
        else if(month == 5){
            System.out.println("스프링, 리액트 배우는 중");
        }
        else if(month == 6){
            System.out.println("팀 프로젝트");
        }
        else{
            System.out.println("취업");
        }

        switch (month){
            case 0: System.out.println("자바, DB배우는 중"); break;
            case 1: System.out.println("자바, 화면구현 배우는 중"); break;
            case 2: System.out.println("IOT, 화면구현 배우는 중"); break;
            case 3: System.out.println("중간 프로젝트"); break;
            case 4: System.out.println("스프링, 파이썬 배우는 중"); break;
            case 5: System.out.println("스프링, 리액트 배우는 중"); break;
            case 6: System.out.println("팀 프로젝트"); break;
            default: System.out.println("취업");
        }
        System.out.println("\n==================\n");
        //개선된 switch문
        //람다식 사용
        //자바는 ->, 자바스크립트는 => 사용
        switch(month){
            case 0 -> {System.out.println("자바, DB");}
            case 1 -> {System.out.println("자바, 화면구현");}
            case 2 -> {System.out.println("IOT, 화면구현");}
            case 3 -> {System.out.println("중간 프로젝트");}
            case 4 -> {System.out.println("스프링, 파이썬");}
            case 5 -> {System.out.println("스프링, 리액트");}
            case 6 -> {System.out.println("팀 프로젝트");}
            default -> System.out.println("취업");
        }




    }
}
