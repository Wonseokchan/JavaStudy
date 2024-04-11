package source.ch10_java_api;

import jdk.jfr.SettingDefinition;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ApiDate {
    public static void main(String[] args) throws ParseException, ParseException {
        //JDK - 자바 개발 도구
        //자바로 개발하기 편하라고 만들어진 라이브러리리들 (= API)

        //API - 다른 사람이 만들어 놓은 라이브러리를 우리가 가져다 쓸 수 있음

        //현재 시간 구하기
        //1. Date 클래스 사용
        Date dateToday = new Date();

        //Date 객체가 생성될 떄 = new Date() 실행시
        //실행되었을 당시의 시간이 Date 객체 내부에 저장된다
        //Tue Mar 26 10:40:17 KST 2024
        System.out.println(dateToday);

        //2초 뒤에 실행되어도, dateToday의 시간이 바뀌지 않음
//        Thread.sleep(2000);
//        System.out.println(dateToday);

        //날짜 포멧
        //2024-03-26 10:45:45으로 출력하기
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strToday = sdf.format(dateToday);
        System.out.println(strToday);

        System.out.println("\n====================================\n");

        //2. Calendar 클래스
        //.getInstance() 실행 시, 새로운 객체가 생성된다 = new Calendar() 실행
        //객체가 생성될 때의 시간이 저장된다.
        Calendar calToday = Calendar.getInstance();

        System.out.println(calToday);

        // Caledar 객체로부터 Date 객체 얻기
        Date calToDate = calToday.getTime();
        System.out.println(calToDate);
        System.out.println(sdf.format(calToDate));

        //3. System 클래스 사용
        //현재 시간에 대해 밀리초 단위로 리턴(long)
        long longToday = System.currentTimeMillis();
        System.out.println(longToday);

        //날짜 포맷팅
        System.out.println(sdf.format(longToday));

        System.out.println("\n============================\n");

        //다양한 날짜 타입 만들기
        //1. 2024/03/26 11:28:30
        //2. 24-03-26 오전 11:28:30
        //3. 화요일 11:28:30
        //4. 2024.03.26 AM 11:28:30

        //1.
        sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));

        //2.
        sdf = new SimpleDateFormat("yy-MM-dd a hh:mm:ss");
        System.out.println(sdf.format(new Date()));

        //3.
        sdf = new SimpleDateFormat("E요일 hh:mm:ss");
        System.out.println(sdf.format(new Date()));

        //4.
        sdf = new SimpleDateFormat("yyyy.MM.dd a hh:mm:ss", Locale.US);
        System.out.println(sdf.format(new Date()));

        System.out.println("\n==========================================\n");

        //날짜형 문자열(String) -> Date 객체로 변환
        String strTomorrow = "2024-03-27 12:04:40";

        //SimpleDateFormat에 변환하고자 하는 날짜형 문자열과 완전히 일치하는 형태로 포맷 설정 (띄어쓰기 하나라도 불일치하면 에러발생)
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date dateTomorrow = sdf.parse(strTomorrow);
        System.out.println(dateTomorrow);


        String strTime = "12:10:05";
        sdf = new SimpleDateFormat("HH:mm:ss");
        Date dateTime = sdf.parse(strTime);
        System.out.println(dateTime); //Thu Jan 01 12:10:05 KST 1970


        String strYear = "2024.03.28";
        sdf = new SimpleDateFormat("yyyy.MM.dd");
        Date dateYear = sdf.parse(strYear);
        System.out.println(dateYear);

        System.out.println("\n==========================================\n");

        //날짜 세팅하기
        Calendar cal = Calendar.getInstance();
        //2005년 08월 19일 로 세팅하기
        //month 는 1월이 0, 2월이 1, .... 12월이 11
        cal.set(2005,7,19);
        System.out.println(sdf.format(cal.getTime()));

        cal.set(2005,7,19,14,23,40);
        sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        System.out.println(sdf.format(cal.getTime()));

        //Date 타입 객체의 시간을 Calendar 객체에 반영
        Calendar dateToCal = Calendar.getInstance();
        dateToCal.setTime(dateTomorrow);
        System.out.println(sdf.format(dateToCal.getTime()));

        //Calendar 객체 내 특정 날짜만 꺼내기
        //년도
        System.out.println(cal.get(Calendar.YEAR));

        //월
        System.out.println(cal.get(Calendar.MONTH) + 1);

        //'getYear()' is deprecated = 지원 종료 예정, 나중에 사라질지 모르는 메소드
        System.out.println(dateToday.getYear() + 1900); //1900년을 기준으로 지나간 연도 > 2024 = 124 >> +1900

        //일
        System.out.println(cal.get(Calendar.DATE));

        //시간
        System.out.println(cal.get(Calendar.HOUR)); //오후 2시면 2
        System.out.println(cal.get(Calendar.HOUR_OF_DAY)); //오후 2시면 14

        //분, 초
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.SECOND));

        System.out.println("\n=========================================\n");

        //날짜 연산
        String oneDay = "2024.03.20 10:32:20";
        String twoDay = "2024.05.22 12:40:20";

        sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Date oneDate = sdf.parse(oneDay);
        Date twoDate = sdf.parse(twoDay);

        System.out.println(oneDate);
        System.out.println(oneDate.getTime());
        System.out.println(twoDate.getTime());
        long diffMillSec = twoDate.getTime() - oneDate.getTime();
        System.out.println(diffMillSec + " 밀리초 차이");

        //밀리초 -> 초 단위 변경
        //1초 = 1000밀리초
        long diffSec = diffMillSec / 1000;
        System.out.println(diffSec + " 초 차이");

        //초 - > 분 단위 변경
        long diffMin = diffSec / 60;
        System.out.println(diffMin + " 분 차이");

        //분 -> 시간 단위 변경
        long diffHour = diffMin / 60;
        System.out.println(diffHour + " 시간 차이");

        //시간 -> 날짜 단위 변경
        long diffDate = diffHour / 24;
        System.out.println(diffDate + " 일 차이");

        System.out.println("\n=========================================\n");

        //d-day 계산기
        //2024.2.19 에 대해
        String startDay = "2024.02.19";
        String restday = "2024.04.10";

        Date today = new Date();
        //today의 시간을 00:00:00 로 변경하기
        String todayStr = sdf.format(today);
        today = sdf.parse(todayStr);

        sdf = new SimpleDateFormat("yyyy.MM.dd");
        Date startDate = sdf.parse(startDay);
        long diff = (today.getTime() - startDate.getTime()) / (1000*60*60*24);
        System.out.println("D+"+diff);

        Date abc = sdf.parse(restday);
        long diff2 = (today.getTime() - abc.getTime()) / (1000*60*60*24);
        System.out.println("D"+diff2);

        System.out.println("\n=========================================\n");
        //디데이 계산기를 메소드화
        calDay("2024.05.05"); //D-39
        calDay("2024.01.05"); //D+82

        System.out.println("\n=========================================\n");
        //Calendar 날짜 연산
        //특정 날짜를 기준으로 날짜를 더하거나 뺄때 유용
        Calendar toCal = Calendar.getInstance();
        System.out.println(sdf.format(toCal.getTime()));

        //3일 뒤 날짜
        toCal.add(Calendar.DATE, 3);
        System.out.println(sdf.format(toCal.getTime()));

        //7일 전 날짜
        toCal.add(Calendar.DATE, -7);
        System.out.println(sdf.format(toCal.getTime()));

        //10달 뒤 날짜
        toCal.add(Calendar.MONTH,10);
        System.out.println(sdf.format(toCal.getTime()));
    }
    public static void calDay(String args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        Date now = new Date();
        String nowStr = sdf.format(now);
        now = sdf.parse(nowStr);

        Date inputDate = sdf.parse(args);

        long diff = (now.getTime() - inputDate.getTime()) / 1000 / 60 / 60 / 24;
        if(diff<0)
            System.out.println("D"+diff);
        else
            System.out.println("D+"+diff);

    }
}
