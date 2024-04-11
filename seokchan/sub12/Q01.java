package source.seokchan.sub12;

import java.util.Scanner;

public class Q01 {
    public static void main(String[] args) {
        int rand = (int)(Math.random()*50);
        Scanner scan = new Scanner(System.in);
        int cnt = 5;
        while(cnt>0){
            System.out.print("숫자를 입력해주세요 : ");
            int input = 0;
            try {
                input = Integer.parseInt(scan.nextLine());
            }catch(NumberFormatException e){
                System.out.println("숫자만 입력해주세요");
                continue;
            }

            if(input > rand){
                cnt--;
                if(cnt==0){
                    System.out.println("실패하였습니다. 정답은 "+ rand + "입니다.");
                    break;
                }
                System.out.println("다운!! 기회가" + cnt + "번 남았습니다.");
            }
            else if(input < rand){
                cnt--;
                if(cnt==0){
                    System.out.println("실패하였습니다. 정답은 "+ rand + "입니다.");
                    break;
                }
                System.out.println("업!! 기회가" + cnt +"번 남았습니다.");
            }
            else if(input == rand){
                System.out.println("정답입니다.");
                break;
            }
        }
    }
}
