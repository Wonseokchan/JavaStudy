package source.ch08_class.common;

import jdk.jfr.SettingDefinition;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtil {
    public static int makeRandom(int a, int b) {
        // a 이상 b 이하의 정수를 반환하는 방법
        return (int)(Math.random() * (b - a + 1)) + a;
    }

    public static double myRound(double num, int n) {
        // 소수점 아래 n자리까지 반올림하는 방법
        double powerOfTen = Math.pow(10, n);
        double rounded = Math.round(num * powerOfTen) / powerOfTen;
        return rounded;
    }

    public static String makeUniqueID(){
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
        String todaystr = sdf.format(today);
        StringBuffer numStr = new StringBuffer(todaystr);
        for(int i = 0; i < 6; i++){
            int rand = (int)(Math.random()*10);
            todaystr += rand;
        }
        return todaystr;
    }
}

