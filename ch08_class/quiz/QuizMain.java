package source.ch08_class.quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizMain {
    public static void main(String[] args) {
        //영화의 명대사를 보고 영화 제목을 맞추는 프로그램
        //영화 목록을 가지고 있어야 함
        //각 영화는 제목과 명대사를 가지고 있어야 한다
        //사용자가 명대사를 보고 영화 제목을 한번에 맞추지 못하면 영화제목에 대한 초성힌트가 출력되고 다시 한번 영화 제목을 맞출 기회를 준다(+1점)

        //1. 영화를 객체로 생성해서 써야겠다 -> 클래스로 정의 내려야겠다
        //2. 퀴즈에 사용할 영화 목록과 명대사를 가지고 있어야겠다.
        ArrayList<Movie> movList = new ArrayList<>();
        movList.add(new Movie("베테랑", "어이가 없네", "ㅂㅌㄹ"));
        movList.add(new Movie("해리포터", "닥쳐 말포이", "ㅎㄹㅍㅌ"));
        movList.add(new Movie("범죄도시", "진실의 방으로", "ㅂㅈㄷㅅ"));
        movList.add(new Movie("범죄와의전쟁", "느그 서장 남천동 살제?", "ㅂㅈㅇㅇㅈㅈ"));
        movList.add(new Movie("신세계", "죽기 딱 좋은 날씨네", "ㅅㅅㄱ"));

        Scanner scan = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < movList.size(); i++) {
            System.out.println(movList.get(i).getTalk());
            System.out.print(">>>");
            String answer = scan.nextLine();
            if (movList.get(i).getTitle().equals(answer)) {
                System.out.println("정답 +2점");
                score += 2;
                continue;
            }
            System.out.println("틀렸습니다");
            System.out.println("초성힌트 : " + movList.get(i).getA());
            System.out.print(">>>");
            answer = scan.nextLine();

            if (movList.get(i).getTitle().equals(answer)) {
                System.out.println("정답 +1점");
                score += 1;
                continue;
            }
            System.out.println("넌 나가라");
            break;
        }
        System.out.println("최종 점수 : " + score + "점");
    }
}
