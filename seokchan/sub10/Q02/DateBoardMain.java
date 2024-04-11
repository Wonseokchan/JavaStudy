package source.seokchan.sub10.Q02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateBoardMain {

    public static void main(String[] args) throws ParseException {
        // dbList에 랜덤 날짜를 가지는 DateBoard 객체 100개 삽입
        ArrayList<DateBoard> dbList = new ArrayList<DateBoard>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

        for(int i = 0; i < 100; i++) {
            int randDay = (int)(Math.random() * 365) + 1;		// 1~365
            Calendar cal = Calendar.getInstance(); // 오늘날짜
            cal.add(Calendar.DATE, randDay * -1); // 오늘날짜에서 1~365 중 랜덤한 일수를 뺀다.

            String strDate = sdf.format(cal.getTime());
            dbList.add(new DateBoard((i+1) + "번째 생성된 글", strDate));
        }

        for(int i = 0; i < dbList.size(); i++) {
            System.out.println(dbList.get(i));
        }

        //정렬
        System.out.println();
        System.out.println("======================최신 순 정렬======================");
        for(int i = 0; i < dbList.size()-1; i++){
            for(int j = 0; j < dbList.size()-1; j++){
                Date date1 = sdf.parse(dbList.get(j).getDate());
                Date date2 = sdf.parse(dbList.get(j+1).getDate());

                if(date1.getTime() < date2.getTime()) {
                    DateBoard temp = dbList.get(j);
                    dbList.set(j, dbList.get(j+1));
                    dbList.set(j+1, temp);
                }
            }
        }
        for(int i = 0; i < dbList.size(); i++) {
            System.out.println(dbList.get(i));
        }

        System.out.println();
        System.out.println("======================과거 순 정렬======================");
        for(int i = 0; i < dbList.size()-1; i++){
            for(int j = 0; j < dbList.size()-1; j++){
                Date date1 = sdf.parse(dbList.get(j).getDate());
                Date date2 = sdf.parse(dbList.get(j+1).getDate());
                if(date1.getTime() > date2.getTime()) {
                    DateBoard temp = dbList.get(j);
                    dbList.set(j, dbList.get(j+1));
                    dbList.set(j+1, temp);
                }
            }
        }
        for(int i = 0; i < dbList.size(); i++) {
            System.out.println(dbList.get(i));
        }

        System.out.println();
        System.out.println("=======================최근 한달 내===========================");
        for(int i = 0; i < dbList.size(); i++){
            Date date1 = sdf.parse(dbList.get(i).getDate());
            Date now = new Date();
            String nowStr = sdf.format(now);
            now = sdf.parse(nowStr);
            long diff = (now.getTime() - date1.getTime()) / 1000 / 60 / 60 / 24;
            if(diff <= 30)
                System.out.println(dbList.get(i));
        }

        System.out.println();
        System.out.println("======================이번 달 출력======================");
        for(int i = 0; i < dbList.size(); i++){
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM");
            Date date1 = sdf1.parse(dbList.get(i).getDate());
            Date now = new Date();
            String nowStr = sdf1.format(now);
            now = sdf1.parse(nowStr);
            if(now.getTime() == date1.getTime())
                System.out.println(dbList.get(i));
        }

        System.out.println();
        System.out.println("======================6월 만 출력======================");
        for(int i = 0; i < dbList.size(); i++) {
            Date date1 = sdf.parse(dbList.get(i).getDate());
            Calendar cal = Calendar.getInstance();
            cal.setTime(date1);
            if(cal.get(Calendar.MONTH) + 1 == 6 )
                System.out.println(dbList.get(i));
        }

        //2023년 7월 14일부터 2023년 8월 21일까지 작성된 게시글만 출력해주세요.
        System.out.println();
        System.out.println("======================7.14 ~ 8.21 출력======================");
        for(int i = 0; i < dbList.size(); i++) {
            Date date1 = sdf.parse(dbList.get(i).getDate());
            Calendar cal = Calendar.getInstance();
            cal.setTime(date1);
            if(cal.get(Calendar.YEAR) == 2023){
                if((cal.get(Calendar.MONTH) + 1 == 7 && cal.get(Calendar.DATE) >= 14) || (cal.get(Calendar.MONTH) + 1 == 8 && cal.get(Calendar.DATE) <= 21))
                    System.out.println(dbList.get(i));
            }
        }
    }
}
