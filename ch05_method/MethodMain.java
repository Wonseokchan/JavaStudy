package source.ch05_method;
import java.util.Scanner;
public class MethodMain {
    public static void main(String[] args) {
        //LoopFor에서 했던 숫자형 문자열의 각 자리수 더하기를 메소드화
        String example = "435";
        int result = eachAdd(example);
        System.out.println(result);

        System.out.println("\n=========================\n");

        //LoopWhile에서 했던 포켓몬
        //pokemon();

        System.out.println("\n=========================\n");

        //재귀함수
        //n부터 1까지 출력하는 메소드
        recursionPrint(10);

        //n의 팩토리얼을 리턴하는 메소드
        long factorial = recFactorial(15);
        System.out.println(factorial);
    }

    public static int eachAdd(String args) {
        int rst = 0;
        for (int i = 0; i < args.length(); i++)
            rst += Integer.parseInt(args.substring(i, i + 1));
        return rst;
    }
    public static void pokemon() {
        Scanner scan = new Scanner(System.in);
        int hp = 100; //파이리 체력
        outer:
        while (true) { //외부 while문에 outer라는 이름부여
            System.out.println("야생의 파이리가 나타났다!");
            System.out.println("1.공격 | 2. 도망");
            System.out.println(">>> ");
            int input = Integer.parseInt(scan.nextLine());

            if (input == 1) {
                while (true) {
                    System.out.println("공격 방법 선택");
                    System.out.println("1. 백만볼트 | 2. 전광석화 | 3. 취소");
                    System.out.println(">>> ");

                    int skil = Integer.parseInt(scan.nextLine());

                    if (skil == 1) {
                        System.out.println("피카츄 백만볼트!!");
                        hp -= 50;
                    } else if (skil == 2) {
                        System.out.println("피카츄 전광석화!!");
                        hp -= 30;
                    } else if (skil == 3) {
                        //내부 while문 종료
                        //외부 while문은 계속 실행
                        break;
                    }
                    if (hp <= 0) {
                        System.out.println("야생의 파이리는 쓰러졌다");
                        return;
                    }
                }
            } else if (input == 2) {
                System.out.println("무사히 도망쳤다.");
                break;
            }
        }
    }
    public static void recursionPrint(int a){
        System.out.println(a);
        //종료 조건
        if(a==1){
            return;
        }
        //재귀함수란, 어떤 함수 내에서 자기 자신(함수)을 실행하는 함수를 의미
        //함수가 반복 실행되므로, while문처럼 종료를 잘 시켜주어야 한다.
        recursionPrint(a-1);
    }
    public static long recFactorial(int n){
        if(n==1){
            return 1;
        }
        return n * recFactorial(n-1);
    }
}
