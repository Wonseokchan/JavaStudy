package source.seokchan.sub09.quiz02;
import java.util.Scanner;
import java.util.ArrayList;

public class FishMain {
    public static void main(String[] args) {
        ArrayList<Fish> fishList = new ArrayList<>();
        fishList.add(new Fish("고등어", 5000));
        fishList.add(new Fish("광어", 25000));
        fishList.add(new Fish("우럭", 27000));
        fishList.add(new Fish("참돔", 30000));
        fishList.add(new Fish("돌돔", 35000));
        fishList.add(new Fish("능성어", 70000));
        fishList.add(new Fish("다금바리", 120000));
        Scanner scan = new Scanner(System.in);

        // 잡은 물고기를 담을 가방
        ArrayList<Fish> fishBag = new ArrayList<>();

        //낚시의 횟수는 10번이 전부
        //10번 이후로는 잡은 물고기 목록만 확인 가능
        int count = 10;
        int sum=0;
        while(count>0) {
            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 낚시하기 | 2. 잡은 물고기 목록 | 3. 떠나기");
            System.out.print(">>> ");

            int select = Integer.parseInt(scan.nextLine());
            if(select == 1) { //낚시하기 | 50%확률로 낚시 실패
                int a = (int)(Math.random()*2);
                if(a==0){
                    int rand = (int)(Math.random()*(fishList.size()));
                    System.out.println(fishList.get(rand).getName()+"를 잡았다!!");
                    fishBag.add(fishList.get(rand));
                }
                else{
                    System.out.println("놓쳤다!!");
                }
                count --;
            }else if(select == 2) { //잡은 물고기 목록 보기
                System.out.println("내 가방=================================");
                for(Fish fis : fishBag){
                    sum+=fis.getPrice();
                    System.out.println(fis);
                }
                System.out.println("총 "+sum+"원=============================");
            }else if(select == 3) { //종료
                break;
            }
            System.out.println();
        }
        System.out.println("내 가방=================================");
        for(Fish fis : fishBag){
            sum+=fis.getPrice();
            System.out.println(fis);
        }
        System.out.println("총 "+sum+"원=============================");
    }
}
