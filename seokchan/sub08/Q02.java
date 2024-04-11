package source.seokchan.sub08;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Q02 {
    public static void main(String[] args) {
        //infoMap의 Key는 사용자의 아이디, Value는 사용자의 비밀번호라고 했을 때 아래와 같이 데이터를 추가해주세요.
        HashMap<String, String> infoMap = new HashMap<>();
        infoMap.put("a001", "1234a");
        infoMap.put("b001", "1234b");
        infoMap.put("c001", "1234c");
        infoMap.put("d001", "1234d");
        infoMap.put("e001", "1234e");

        //사용자가 아이디와 비밀번호를 입력했을때, infoMap의 Key(아이디)와 Value(비밀번호)와 비교하여
        //1. 아이디와 비밀번호가 infoMap 내에 존재하는 데이터와 일치하면 로그인 성공 출력
        //2. 아이디가 존재하지 않으면, 존재하지 않는 아이디입니다. 출력
        //3. 아이디는 존재하지만 비밀번호가 일치하지 않으면 비밀번호가 틀렸습니다. 출력
        Scanner scan = new Scanner(System.in);
        System.out.println("아이디를 입력해주세요");
        System.out.print(">>> ");
        String ID = scan.nextLine();
        System.out.println("비밀번호를 입력해주세요");
        System.out.print(">>> ");
        String PW = scan.nextLine();

        if (infoMap.get(ID)!=null) {
            if(infoMap.get(ID).equals(PW))
                System.out.println("로그인 성공");
            else
                System.out.println("비밀번호가 틀렸습니다");
        }
        else
            System.out.println("존재하지 않는 아이디입니다.");

        if(infoMap.get(ID) != null && infoMap.get(ID).equals(PW))
            System.out.println("로그인 성공");
        else
            System.out.println("아이디 혹은 비밀번호가 유효하지 않습니다.");
    }
}
