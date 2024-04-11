package source.seokchan.as;

import source.ch08_class.homepage.BoardDB;
import source.seokchan.as.Rank;
import source.seokchan.as.RankDB;

import java.util.Scanner;

public class ReactionTimeTest {
    public static final String green = "\u001B[32m";
    public static final String exit = "\u001B[0m";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        RankDB rankDB = RankDB.getInstance();

        while(true) {
            System.out.println("반응 속도 테스트 프로그램입니다");
            System.out.println("1. 테스트 시작 | 2. 설명 | 3. 순위 | 4. 종료");
            System.out.print(">>> ");
            int command = Integer.parseInt(scan.nextLine());

            double totalReactionTime = 0;
            if(command == 1) {
                System.out.println("반응 속도 테스트를 시작합니다!!");
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep((long) (Math.random() * 5000));
                        System.out.println(green+"\n" +
                                "███████████████████████████████████████████████████████████████████████████████████\n" +
                                "███████████████████████████████████████████████████████████████████████████████████\n" +
                                "███████████████████████████████████████████████████████████████████████████████████\n" +
                                "███████████████████████████████████████████████████████████████████████████████████\n" +
                                "███████████████████████████████████████████████████████████████████████████████████\n" +
                                "███████████████████████████████████████████████████████████████████████████████████"+exit);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    long startTime = System.currentTimeMillis();
                    scanner.nextLine();
                    float reactionTime = (float) ((System.currentTimeMillis() - startTime)/ 1000.0);
                    System.out.println("반응 속도 : " + Math.round(reactionTime*1000)/1000.0 + " 초");
                    totalReactionTime += reactionTime;
                }
                float avgTime = (float)(totalReactionTime / 5);
                System.out.println("평균 반응 속도 : " + Math.round(avgTime*1000)/1000.0 + " 초");
                if(avgTime <= 0.21)
                    System.out.println("당신의 반응 속도는 상위 1% 입니다.\n혹시 당신은 외계인입니까?");
                else if(avgTime<=0.24)
                    System.out.println("당신의 반응 속도는 상위 5% 입니다.\n혹시 당신은 손가락에 자동 반사신경을 탑재하고 있습니까?");
                else if(avgTime<=0.27)
                    System.out.println("당신의 반응 속도는 상위 10% 입니다.\n혹시 당신의 손가락은 기계입니까?");
                else if(avgTime<=0.28)
                    System.out.println("당신의 반응 속도는 상위 20%입니다.\n당신은 더 이상 마우스가 필요없는 경지에 도달 했습니다.");
                else if(avgTime<=0.3)
                    System.out.println("당신의 반응 속도는 상위 30%입니다.\n당신은 손가락을 쓰는 직업을 가지면 유리하겠군요.");
                else if(avgTime<=0.32)
                    System.out.println("당신의 반응 속도는 평균 이상입니다.");
                else if(avgTime<=0.34)
                    System.out.println("당신의 반응 속도는 평균입니다.\n결과에 만족하십니까?");
                else if(avgTime<=0.36)
                    System.out.println("당신의 반응 속도는 평균 이하입니다.\nㅋㅋ");
                else if(avgTime<=0.4)
                    System.out.println("당신의 반응 속도는 하위 30%입니다.\n이 정도면 손가락 트레이너를 고용할 필요가 있을 수 있습니다.");
                else if(avgTime<=0.42)
                    System.out.println("당신의 반응 속도는 하위 20%입니다.\n혹시 생각과 손가락이 따로 움직이나요? 다시 한 번 해보세요.");
                else if(avgTime<=0.6)
                    System.out.println("당신의 반응 속도는 하위 10%입니다.\n정말 느린 편입니다. 반응 속도 트레이닝이 필요합니다.");
                else if(avgTime > 1.0)
                    System.out.println("당신의 반응 속도는 하위 5%입니다.\n참으로 흔치 않은 수치인데요. 이 정도면 몸과 마음이 따로 노는게 아닐까요? 분발하세요.");

                while(true) {
                    System.out.println("결과를 기록하시겠습니까?");
                    System.out.println("Y | N");
                    System.out.print(">>> ");
                    String a = scan.nextLine();
                    if (a.equalsIgnoreCase("Y")) {
                        System.out.print("이름 입력 : ");
                        String name = scan.nextLine();
                        Rank rk = new Rank(name, avgTime);
                        rankDB.rankADD(rk);
                        break;
                    } else if (a.equalsIgnoreCase("N"))
                        break;
                    else
                        System.out.println("다시 입력해주세요");
                }
            }
            else if(command == 2){
                System.out.println("===========================================================================================");
                System.out.println("일반적으로 나이가 들면 뇌의 운동정보 교환능력이 쇠퇴하면서 외부 자극에 반응하는 속도가 떨어진다고 합니다.\n당신은 반응 속도가 얼마나 빠른가요?\n본 테스트는 총 5회로 구성되어 있습니다.");
                System.out.println("콘솔 창에 초록색 화면이 나오면 엔터를 눌러주세요");
                System.out.println("===========================================================================================");
            }
            else if(command == 3){
                System.out.println("랭킹\t\t이름\t\t\t\t\t\t반응속도");
                rankDB.showRank();
            }
            else if(command == 4){
                System.out.println("프로그램을 종료합니다");
                break;
            }
        }
    }
}
