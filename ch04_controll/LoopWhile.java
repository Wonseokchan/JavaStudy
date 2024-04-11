package source.ch04_controll;

import java.util.Scanner;

public class LoopWhile {
    public static void main(String[] args) {
        //while문
        /*int i = 0;
        while(i <= 10){
            System.out.println(i);
            i++;
        }*/
        boolean isRun = true;
        Scanner scan = new Scanner(System.in);

        /*while(isRun){
            System.out.println("채팅 입력[종료 q]");
            System.out.println(">>> ");

            String input = scan.nextLine();

            System.out.println("나: "+ input);

            if(input.equals("q")){
                isRun = false;
            }

        }
        while(true){
            System.out.println("채팅 입력[종료 q]");
            System.out.println(">>> ");
            String input = scan.nextLine();

            if(input.equalsIgnoreCase("q")){
                break;
            }
            System.out.println("나: "+ input);
        }

        int hp = 100; //파이리 체력
        outer: while(true){ //외부 while문에 outer라는 이름부여
            System.out.println("야생의 파이리가 나타났다!");
            System.out.println("1.공격 | 2. 도망");
            System.out.println(">>> ");
            int input = Integer.parseInt(scan.nextLine());

            if(input == 1){
            while(true){
                System.out.println("공격 방법 선택");
                System.out.println("1. 백만볼트 | 2. 전광석화 | 3. 취소");
                System.out.println(">>> ");

                int skil = Integer.parseInt(scan.nextLine());

                if(skil==1){
                    System.out.println("피카츄 백만볼트!!");
                    hp -= 50;
                }
                else if(skil==2){
                    System.out.println("피카츄 전광석화!!");
                    hp -= 30;
                }
                else if(skil==3){
                    //내부 while문 종료
                    //외부 while문은 계속 실행
                    break;
                }
                if(hp<=0){
                    System.out.println("야생의 파이리는 쓰러졌다");
                    break outer; //외부 while문 outer 종료
                }
            }
            else if(input == 2){
                System.out.println("무사히 도망쳤다.");
                break;
            }
        }*/
        int A = 7;
        int B = 1;

        while(true){
            System.out.println("===========희영빌딩 엘리베이터=============");
            System.out.println("승강기 A의 현재 위치: " +A+"층");
            System.out.println("승강기 B의 현재 위치: " +B+"층");
            System.out.print("몇층에 계시나요?[종료하시려면 q 또는 exit 입력]: ");
            String input = scan.nextLine();

            if(input.equalsIgnoreCase("q")|| input.equalsIgnoreCase("exit")){
                break;
            }
            int local = Integer.parseInt(input);
            if (local>=A || Math.abs(A-local)==Math.abs(B-local)) {
                System.out.println(local + "층에서 엘리베이터를 호출합니다.");
                System.out.println("승강기 A가 " + local + "층으로 이동하였습니다.");
                A = local;
                break;
            } else if (local >= B) {
                System.out.println(local + "층에서 엘리베이터를 호출합니다.");
                System.out.println("승강기 B가 " + local + "층으로 이동하였습니다.");
                B = local;
                break;
            }
        }
    }
}


