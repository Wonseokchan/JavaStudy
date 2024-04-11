package source.ch08_class.school;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SchoolMain {
    public static void main(String[] args) {
        //학생들의 시험 성적을 관리하는 프로그램
        //학생의 이름, 국어, 영어, 수학, 평균
        Student bbangbbang = new Student();
        System.out.println(bbangbbang);

        /*bbangbbang.getname = "빵빵이";
        bbangbbang.kor = 80;
        bbangbbang.eng = 70;
        bbangbbang.math = 91;
        bbangbbang.avg = (bbangbbang.kor + bbangbbang.eng + bbangbbang.math) / 3.0;
        System.out.println(bbangbbang);*/

        Student okji = new Student("옥지", 80, 86, 87, (80+86+87)/3.0);
        System.out.println(okji);

        //학생의 이름, 국어, 영어, 수학만 입력하더라도 평균 점수는 자동으로 계산되어 출력반영되게 하기
        Student jjinbbang = new Student("찐빵", 70, 76, 73);
        System.out.println(jjinbbang);

        System.out.println("\n===========================================\n");
        //필드변수에 그냥 바로 접근이 가능하면 수정을 할 수 있으므로 문제가 발생하는 경우가 존재
        jjinbbang.setKor(81);
        System.out.println(jjinbbang);

        System.out.println("\n======================\n");

        ArrayList<Student> stuList = new ArrayList<>();
        stuList.add(bbangbbang);
        stuList.add(okji);
        stuList.add(jjinbbang);
        stuList.add(new Student("호빵맨", 90, 50, 56));
        stuList.add(new Student("식빵맨", 78, 60, 56));
        for(int i = 0; i < stuList.size(); i++){
            System.out.println(stuList.get(i));
        }

        System.out.println("\n================================\n");
        /*Collections.sort(stuList, (stA, stB) -> (int) (stB.getAvg() - stA.getAvg()));
        for(int i = 0; i < stuList.size(); i++)
            System.out.println(stuList.get(i));*/
        Collections.sort(stuList, new Comparator<Student>() {
            @Override
            public int compare(Student stuA, Student stuB) {
                if(stuB.getAvg() - stuA.getAvg() < 0){
                    return -1;
                }
                return 0;
            }
        });
        stuList.forEach(System.out::println);
    }
}
