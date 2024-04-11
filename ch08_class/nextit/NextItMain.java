package source.ch08_class.nextit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NextItMain {
    public static void main(String[] args) {
        //넥스트 아이티 학생들 레벨 시뮬레이션
        //각 학생들은 이름과 나이, 레벨과 경험치를 가진다
        //하루가 지날때마다 학생들은 경험치를 얻는다
        //경험치가 100이상이 될때마다 레벨업을 한다
        String sdName = "선동";
        int sdAge = 25;
        int sdLevel = 5;
        int sdExp = 20;

        String siName = "상일";
        int siAge = 25;
        int siLevel = 1;
        int siExp = 10;

        //day1
        sdExp += 30;
        siExp += 30;

        //day2
        sdExp += 30;
        siExp += 30;

        //day3
        sdExp += 30;
        siExp += 30;


        if (sdExp >= 100) {
            sdLevel++;
            sdExp -= 100;
        }
        if (siExp >= 100) {
            siExp++;
            siExp -= 100;
        }
        System.out.println("\n===========================\n");
        NextStudent seondong = new NextStudent();
        System.out.println(seondong.name);
        System.out.println(seondong.age);
        System.out.println(seondong.level);
        System.out.println(seondong.exp);

        //필드 변수에 값을 따로 담아주지 않으면 생성된 객체의 필드변수 값들은 초기값(deafalt)을 가지고 있다.
        //숫자 -> 0, boolean -> false, 참조타입 -> null
        seondong.name = "선동";
        seondong.age = 25;
        seondong.level = 5;
        seondong.exp = 20;

        NextStudent sangil = new NextStudent();
        sangil.name = "상일";
        sangil.age = 25;
        sangil.level = 1;
        sangil.exp = 10;

        seondong.oneDayAfter();
        sangil.oneDayAfter();

        //객체 내 필드변수값 한눈에 보기
        // -> 해당 클래스 내에 toString() 메소드를 override 하기
        System.out.println(seondong);
        System.out.println(sangil);

        System.out.println("\n===========================\n");

        NextStudent youngyoon = new NextStudent();
        youngyoon.name = "영윤";
        youngyoon.age = 26;
        youngyoon.level = 1;
        youngyoon.exp = 20;


        youngyoon.oneDayAfter();
        youngyoon.oneDayAfter();
        youngyoon.oneDayAfter();
        System.out.println(youngyoon);
        System.out.println("\n===========================\n");

        //필드변수에 값을 입력받는 생성자(Constructor)를 이용하여 객체를 생성하기
        //new NextStudent() 에서 NextStudent() 을 생성자라고 부른다.
        //파라미터를 입력받지 않는 생성자를 기본 생성자라고 부른다.

        NextStudent jaegyeong = new NextStudent("재경", 26, 1, 30);
        System.out.println(jaegyeong);

        NextStudent sangyeon = new NextStudent("상연", 26, 1, 0);
        NextStudent jiin = new NextStudent("지인", 25, 1, 0);
        NextStudent seokchan = new NextStudent("석찬", 25);
        System.out.println(seokchan);
        //생성자를 더 만들어서 이름과 나이만 입력해도 되게 만들기


        System.out.println("\n==================================\n");
        NextStudent seokchanBot = seokchan;
        seokchanBot.name = "석찬봇";
        System.out.println(seokchan);
        System.out.println(seokchanBot);

        NextStudent seondongBot = new NextStudent(seondong.name, seondong.age, seondong.level, seondong.exp);
        seondongBot.name = "선동봇";
        System.out.println(seondongBot);
        System.out.println(seondong);

        //하루가 지났습니다.
        seondong.oneDayAfter();
        sangil.oneDayAfter();
        jaegyeong.oneDayAfter();
        youngyoon.oneDayAfter();
        sangyeon.oneDayAfter();
        jiin.oneDayAfter();
        seokchan.oneDayAfter();

        System.out.println("\n=================\n");
        //여러개의 객체들을 한번에 다루기
        ArrayList<NextStudent> stuList = new ArrayList<>();
        stuList.add(seondong);
        stuList.add(sangil);
        stuList.add(jaegyeong);
        stuList.add(youngyoon);
        stuList.add((jiin));
        stuList.add(sangyeon);
        stuList.add(seokchan);

        //하루가 지났습니다.
        for(int i = 0; i < stuList.size(); i++){
            stuList.get(i).oneDayAfter();
        }
        //이틀이 지났습니다
        for(NextStudent stu : stuList){
            stu.oneDayAfter();
        }
        //한달이 지났습니다
        for(int i =0; i<30; i++) {
            for (NextStudent stu : stuList) {
                stu.oneDayAfter();
            }
        }
        for (NextStudent stu : stuList) {
            System.out.println(stu);
        }

        NextStudent jaeyeon = new NextStudent("재연", 26);
        stuList.add(jaeyeon);

        stuList.add(new NextStudent("진율", 26));

        //수료를 위한 100일이 지남
        for(int i =0; i<100; i++) {
            for (NextStudent stu : stuList) {
                stu.oneDayAfter();
            }
        }
        System.out.println("\n======================\n");
        for (NextStudent stu : stuList) {
            System.out.println(stu);
        }
        System.out.println("\n======================\n");
        //레벨 기준 내림차순 정렬
        Collections.sort(stuList, new Comparator<NextStudent>() {
            @Override
            public int compare(NextStudent stuA, NextStudent stuB) {
                //왼쪽 객체와 오른쪽 객체 비교
                //리턴값이 양수인지 음수인지 알려주면됨
                //리턴값이 음수일때만 자리가 바뀌게끔 설계가 되어있음

                //왼쪽 객체의 레벨이 오른쪽 객체의 레벨보다 크면 양수리턴
                return stuA.level - stuB.level; //오름차순
                //     stuB.level - stuA.level; 내림차순
            }
        });
        for( NextStudent stu : stuList ){
            System.out.println(stu);
        }
        System.out.println("\n======================\n");
        //람다식 사용
        Collections.sort(stuList, (stuA, stuB) -> stuA.level - stuB.level);
        for( NextStudent stu : stuList ){
            System.out.println(stu);
        }




    }
}
