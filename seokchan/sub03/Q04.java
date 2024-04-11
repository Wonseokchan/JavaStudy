package source.seokchan.sub03;

import java.util.Scanner;

public class Q04 {
    public static void main(String[] args) {
        //로꾸꺼 로꾸꺼
        //
        //사용자에게 문자열을 입력받으시고, 입력받은 문자열의 순서를 뒤집어서 출력해보세요.

        Scanner scanner = new Scanner(System.in);
        System.out.print("문자를 입력해주세요 : ");
        String str = scanner.nextLine();

        String reverse = "";
        for(int i=str.length() -1; i>=0;i--){
            //reverse += str.charAt(i);
            reverse += str.substring(i,i+1);
        }
        System.out.println("뒤집은 결과 : "+reverse);

    }
}
