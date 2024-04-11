package source.ch09_extends_interface.starcraft;

import com.sun.jdi.ArrayReference;

import java.util.ArrayList;

public class StarcraftMain {
    public static void main(String[] args) {
        Marine marine = new Marine();
        System.out.println(marine);
        marine.stimpack();
        System.out.println(marine);

        Zealot zealot = new Zealot();
        System.out.println(zealot);


        HighTemplar highTemplar = new HighTemplar();
        System.out.println(highTemplar);
        highTemplar.psionicStorm();

        //마린이 질럿을 때린다
        marine.attack(zealot);
        System.out.println(zealot);

        marine.attack(highTemplar);
        System.out.println(highTemplar);

        Zealot zealot2 = new Zealot();
        Zealot zealot3 = new Zealot();
        Zealot zealot4 = new Zealot();
        Zealot zealot5 = new Zealot();

        zealot.move(10, 20);
        zealot2.move(10, 20);
        zealot3.move(10, 20);
        zealot4.move(10, 20);
        zealot5.move(10, 20);

        ArrayList<Zealot> zealotList = new ArrayList<>();
        zealotList.add(zealot);
        zealotList.add(zealot2);
        zealotList.add(zealot3);
        zealotList.add(zealot4);
        zealotList.add(zealot5);

        for(int i = 0 ; i < zealotList.size(); i++){
            zealotList.get(i).move(20,30);
        }

        //다형성
        //하나의 객체가 여러 타입을 가질 수 있는 것
        //자식 객체에서 부모 객체로 형변환이 가능하다
        StarUnit starZealot = zealot;
        StarUnit starHigh = highTemplar;

        System.out.println(starZealot);
        System.out.println(starZealot.toString()); //Zealot의 toString이 실행

        //StarUnit을 담을 수 있는 ArrayList
        ArrayList<StarUnit> starList = new ArrayList<>();
        //StarUnit의 자식객체는 다 담을 수 있음
        starList.add(zealot);
        starList.add(zealot2);
        starList.add(zealot3);
        starList.add(zealot4);
        starList.add(zealot5);      // Zealot -> StarUnit로 자동 형변환되어 담김
        starList.add(highTemplar);  // HighTemplar -> StarUnit로 자동 형변환되어 담김
        starList.add(marine);       // Marine -> StarUnit로 자동 형변환되어 담김

        for(int i = 0; i<starList.size(); i++){
            starList.get(i).move(50, 100);
        }

        //인덱스 5번은 하이템플러
        //starList.get(i) -> StarUnit 타입인 상태
        //starList.get(5).psionicStorm();

        //StarUnit 타입에서 다시 HighTemplar 타입으로 변환해준 후 메소드 사용
        ((HighTemplar)starList.get(5)).psionicStorm();

        //인덱스 5번의 경우
        //HightTemplar -> StarUnit -> HighTemplar

        //인덱스 0번의 경우
        //Zealot -> StarUnit -> HighTemplar 불가능
        //((HighTemplar)starList.get(0)).psionicStorm();

        //starList에서 highTemplar를 찾아서 스톰사용하기
        for(int i = 0; i < starList.size(); i++){
            if(starList.get(i).getName().equals("하이템플러")){
                ((HighTemplar)starList.get(i)).psionicStorm();
            }
            //객체 instanceof 클래스
            //왼쪽의 객체가 오른쪽 클래스로 형변환이 가능하다면 true, 불가능하다면 false 리턴
            //HighTemplar -> StarUnit 인 경우에만 true 리턴
            if(starList.get(i) instanceof HighTemplar){
                ((HighTemplar)starList.get(i)).psionicStorm();
            }
            //Marine 찾아서 스팀팩 사용
            if(starList.get(i) instanceof Marine){
                ((Marine)starList.get(i)).stimpack();
            }
        }

        //부모 <-> 자식 형변환 정리
        //부모 객체
        StarUnit star = new StarUnit();
        //일반적으로 부모 객체는 자식 클래스로 형변환할 수 없다.
        System.out.println(star instanceof Zealot);

        //자식 객체는 부모 클래스로 형변환이 가능하다.
        System.out.println(zealot instanceof StarUnit);
        System.out.println(marine instanceof StarUnit);

        //부모 클래스로 형변환 되었던 자식 객체는 다시 해당 자식 객체로 형변환이 가능하다
        StarUnit temp = marine;
        System.out.println(temp instanceof Marine);
    }
}
