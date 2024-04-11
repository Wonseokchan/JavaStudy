package source.ch08_class.homepage;

import java.util.ArrayList;
import java.util.Scanner;

public class HomepageMain {
    public static void main(String[] args) {
        //회원가입, 로그인 구현
        //Member는 아이디, 비밀번호, 이름

        //MemberDB 안에는 Member를 관리하는 memList 보유
        //MemberDB 는 이 프로젝트 내에서 단 하나만 필요하다( = MemberDB에 대한 객체 생성을 딱 한번만 하면 된다)
        //해당 클래스에 싱글톤 패턴을 적용

        //MemberDB가 아닌 클래스에서는 MemberDB의 기본생성자를 사용할 수 없음
        //MemberDB에 대한 객체를 생성할 수 없음
        //memDB = 202호
        MemberDB memDB = MemberDB.getInstance();
        memDB = null; //memDB = null호, instance = 202호
        BoardDB boardDB = BoardDB.getInstance();

        //memberDB = 202호
        MemberDB memberDB = MemberDB.getInstance();
        //memberDB = null;

        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("1. 회원가입 | 2. 로그인 | 3. 회원목록 | 4. 종료");
            System.out.print(">>> ");
            int command = (Integer.parseInt(scan.nextLine()));
            if(command == 1){
                //회원가입
                System.out.print("ID 입력 : ");
                String ID = scan.nextLine();
                System.out.print("비밀번호 입력 : ");
                String PW = scan.nextLine();
                System.out.print("이름 입력 : ");
                String name = scan.nextLine();
                //입력받은 데이터에 대한 member 객체 생성
                Member mem = new Member(ID, PW, name);

                //MemberDB 내 memList에 추가
                memberDB.signUP(mem);
            }
            else if(command == 2){
                //로그인
                System.out.print("ID 입력 : ");
                String ID = scan.nextLine();
                System.out.print("비밀번호 입력 : ");
                String PW = scan.nextLine();
                //memberDb의 memList 내 Member 객체 중 입력한 ID와 PW가 일치하는 객체를 찾아 리턴
                Member login = memberDB.login(ID, PW);

                //login에 null값이 담기면 유효하지 않은 id 또는 pw임
                if(login!=null){
                    System.out.println("로그인 성공 " + login.getName() + "님 환영합니다");
                    while(true){
                        boardDB.show();
                        System.out.println();
                        System.out.println("1. 글쓰기 | 2. 글보기 | 3. 로그아웃");
                        System.out.print(">>> ");
                        int cmd = (Integer.parseInt(scan.nextLine()));
                        if(cmd == 1){
                            System.out.print("글 제목 입력 : ");
                            String title = scan.nextLine();
                            System.out.print("글 내용 입력 : ");
                            String contents = scan.nextLine();

                            Board bd = new Board(title,contents,login.getName());
                            boardDB.boardADD(bd);
                        }
                        else if(cmd == 2){
                            System.out.println("글 번호 입력 : ");
                            int a = Integer.parseInt(scan.nextLine());
                            boardDB.viewBoard(a);
                        }
                        else if(cmd == 3){
                            System.out.println("로그아웃 되었습니다");
                            break;
                        }
                    }
                }
                else
                    System.out.println("아이디 혹은 비밀번호가 다릅니다");
            }
            else if(command == 3 ){
                //회원목록
                memberDB.showMemlist();
            }
            else if(command == 4 ){
                break;
            }
        }
    }
}
